package com.winemood.winemood_backend.service.impl;

import com.winemood.winemood_backend.constants.ExceptionMessageConstant;
import com.winemood.winemood_backend.constants.SecurityConstants;
import com.winemood.winemood_backend.dto.request.UserLoginRequestDto;
import com.winemood.winemood_backend.dto.request.UserRegistrationRequestDto;
import com.winemood.winemood_backend.dto.response.*;
import com.winemood.winemood_backend.entity.User;
import com.winemood.winemood_backend.entity.Wine;
import com.winemood.winemood_backend.exceptions.RegistrationException;
import com.winemood.winemood_backend.exceptions.UserNotFoundException;
import com.winemood.winemood_backend.exceptions.WineNotFoundException;
import com.winemood.winemood_backend.mapper.UserMapper;
import com.winemood.winemood_backend.mapper.WineMapper;
import com.winemood.winemood_backend.repository.UserRepository;
import com.winemood.winemood_backend.repository.WineRepository;
import com.winemood.winemood_backend.security.JwtUtil;
import com.winemood.winemood_backend.service.CloudinaryService;
import com.winemood.winemood_backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;
    private final UserMapper userMapper;
    private final CloudinaryService cloudinaryService;

    private final WineRepository wineRepository;
    private final WineMapper wineMapper;

    @Override
    public AuthenticationResponseDto register(UserRegistrationRequestDto requestDto) throws RegistrationException {
        if (userRepository.findByEmail(requestDto.getEmail()).isPresent()) {
            throw new RegistrationException(ExceptionMessageConstant.EXISTING_USER);
        }
        User user = new User();
        user.setEmail(requestDto.getEmail());
        user.setName(requestDto.getName());
        user.setPassword(passwordEncoder.encode(requestDto.getPassword()));

        User savedUser = userRepository.save(user);
        String token = jwtUtil.generateToken(savedUser);

        return new AuthenticationResponseDto(
                token,
                SecurityConstants.TOKEN_TYPE,
                userMapper.toDto(savedUser)
        );
    }

    @Override
    public AuthenticationResponseDto login(UserLoginRequestDto requestDto) {
        User user = userRepository.findByEmail(requestDto.getEmail())
                .orElseThrow(
                        () -> new BadCredentialsException(
                                ExceptionMessageConstant.INVALID_CREDENTIALS
                        )
                );

        if (!passwordEncoder.matches(requestDto.getPassword(), user.getPassword())) {
            throw new BadCredentialsException(
                    ExceptionMessageConstant.INVALID_CREDENTIALS
            );
        }
        String token = jwtUtil.generateToken(user);
        return new AuthenticationResponseDto(
                token,
                SecurityConstants.TOKEN_TYPE,
                userMapper.toDto(user)
        );
    }

    @Override
    public UserResponseDto uploadAvatar(MultipartFile image) {
        User authenticatedUser = getAuthenticatedUser();

        if (StringUtils.hasText(authenticatedUser.getAvatarPublicId())) {
            cloudinaryService.delete(authenticatedUser.getAvatarPublicId());
        }

        UploadedImageResultDto uploadedImage = cloudinaryService.upload(image);
        authenticatedUser.setAvatarUrl(uploadedImage.getUrl());
        authenticatedUser.setAvatarPublicId(uploadedImage.getPublicId());

        User savedUser = userRepository.save(authenticatedUser);

        return userMapper.toDto(savedUser);
    }

    @Override
    public UserResponseDto deleteAvatar() {
        User authenticatedUser = getAuthenticatedUser();

        if (StringUtils.hasText(authenticatedUser.getAvatarPublicId())) {
            cloudinaryService.delete(authenticatedUser.getAvatarPublicId());
        }

        authenticatedUser.setAvatarUrl(null);
        authenticatedUser.setAvatarPublicId(null);
        User savedUser = userRepository.save(authenticatedUser);

        return userMapper.toDto(savedUser);
    }

    @Override
    public void addFavorite(Long wineId) {
        User authenticatedUser = getAuthenticatedUser();

        authenticatedUser.getFavoriteWines().add(getWine(wineId));
        userRepository.save(authenticatedUser);
    }

    @Override
    public void removeFavorite(Long wineId) {
        User authenticatedUser = getAuthenticatedUser();

        authenticatedUser.getFavoriteWines().remove(getWine(wineId));
        userRepository.save(authenticatedUser);
    }

    @Override
    public FavoriteWineResponseDto getFavoriteWines() {
        User authenticatedUser = getAuthenticatedUser();

        List<WineCatalogResponseDto> wines = authenticatedUser.getFavoriteWines()
                .stream()
                .map(wine -> {
                    WineCatalogResponseDto dto = wineMapper.toCatalogDto(wine);
                    dto.setFavorite(true);
                    return dto;
                })
                .toList();

        return new FavoriteWineResponseDto(wines.size(), wines);
    }

    private User getAuthenticatedUser() {
        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null
                || !authentication.isAuthenticated()
                || !(authentication.getPrincipal() instanceof UserDetails userDetails)) {
            throw new UserNotFoundException(
                    ExceptionMessageConstant.USER_NOT_FOUND
            );
        }

        return userRepository.findByEmail(userDetails.getUsername())
                .orElseThrow(
                        () -> new UserNotFoundException(
                                ExceptionMessageConstant.USER_NOT_FOUND
                        )
                );
    }

    private Wine getWine(Long wineId) {
        return wineRepository.findById(wineId)
                .orElseThrow(() -> new WineNotFoundException(wineId));
    }
}

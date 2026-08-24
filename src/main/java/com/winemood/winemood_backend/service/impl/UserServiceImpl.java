package com.winemood.winemood_backend.service.impl;

import com.winemood.winemood_backend.constants.ExceptionMessageConstant;
import com.winemood.winemood_backend.constants.SecurityConstants;
import com.winemood.winemood_backend.dto.request.UserLoginRequestDto;
import com.winemood.winemood_backend.dto.request.UserRegistrationRequestDto;
import com.winemood.winemood_backend.dto.response.*;
import com.winemood.winemood_backend.entity.User;
import com.winemood.winemood_backend.entity.Wine;
import com.winemood.winemood_backend.enums.AchievementCode;
import com.winemood.winemood_backend.enums.AnalyticsEventType;
import com.winemood.winemood_backend.exceptions.RegistrationException;
import com.winemood.winemood_backend.exceptions.WineNotFoundException;
import com.winemood.winemood_backend.mapper.UserMapper;
import com.winemood.winemood_backend.mapper.WineMapper;
import com.winemood.winemood_backend.repository.ReviewRepository;
import com.winemood.winemood_backend.repository.UserAchievementRepository;
import com.winemood.winemood_backend.repository.UserRepository;
import com.winemood.winemood_backend.repository.WineRepository;
import com.winemood.winemood_backend.security.JwtUtil;
import com.winemood.winemood_backend.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final WineRepository wineRepository;
    private final UserAchievementRepository userAchievementRepository;
    private final ReviewRepository reviewRepository;
    private final CloudinaryService cloudinaryService;
    private final AuthenticatedUserService authenticatedUserService;
    private final AchievementService achievementService;
    private final AnalyticsEventService analyticsEventService;
    private final UserMapper userMapper;
    private final WineMapper wineMapper;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    @Override
    public RegistrationResponseDto register(UserRegistrationRequestDto requestDto) throws RegistrationException {
        if (userRepository.findByEmail(requestDto.getEmail()).isPresent()) {
            throw new RegistrationException(ExceptionMessageConstant.EXISTING_USER);
        }

        User user = new User();
        user.setEmail(requestDto.getEmail());
        user.setName(requestDto.getName());
        user.setPassword(passwordEncoder.encode(requestDto.getPassword()));
        user.setCreatedAt(LocalDateTime.now());

        User savedUser = userRepository.save(user);
        return userMapper.toRegisterDto(savedUser);
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
                SecurityConstants.TOKEN_TYPE
        );
    }

    @Override
    public UserResponseDto uploadAvatar(MultipartFile image) {
        User authenticatedUser = authenticatedUserService.getCurrentUser();

        if (StringUtils.hasText(authenticatedUser.getAvatarPublicId())) {
            cloudinaryService.delete(authenticatedUser.getAvatarPublicId());
        }

        UploadedImageResultDto uploadedImage = cloudinaryService.upload(image);
        authenticatedUser.setAvatarUrl(uploadedImage.getUrl());
        authenticatedUser.setAvatarPublicId(uploadedImage.getPublicId());

        User savedUser = userRepository.save(authenticatedUser);

        UserResponseDto dto = userMapper.toDto(savedUser);
        dto.setReviewCount(reviewRepository.countByUser(savedUser));

        return dto;
    }

    @Override
    public UserResponseDto deleteAvatar() {
        User authenticatedUser = authenticatedUserService.getCurrentUser();

        if (StringUtils.hasText(authenticatedUser.getAvatarPublicId())) {
            cloudinaryService.delete(authenticatedUser.getAvatarPublicId());
        }

        authenticatedUser.setAvatarUrl(null);
        authenticatedUser.setAvatarPublicId(null);
        User savedUser = userRepository.save(authenticatedUser);

        UserResponseDto dto = userMapper.toDto(savedUser);
        dto.setReviewCount(reviewRepository.countByUser(savedUser));

        return dto;
    }

    @Override
    public void addFavorite(Long wineId) {
        User authenticatedUser = authenticatedUserService.getCurrentUser();
        Wine wine = getWine(wineId);

        boolean added = authenticatedUser.getFavoriteWines().add(wine);

        if (!added) {
            return;
        }

        userRepository.save(authenticatedUser);

        analyticsEventService.saveEvent(
                AnalyticsEventType.FAVORITE,
                Map.of(
                        "wine_id", wineId,
                        "action", "added"
                )
        );

        achievementService.grantAchievement(
                authenticatedUser,
                AchievementCode.FIRST_FAVORITE
        );
    }

    @Override
    public void removeFavorite(Long wineId) {
        User authenticatedUser = authenticatedUserService.getCurrentUser();
        Wine wine = getWine(wineId);

        boolean removed = authenticatedUser.getFavoriteWines().remove(wine);

        if (!removed) {
            return;
        }

        userRepository.save(authenticatedUser);

        analyticsEventService.saveEvent(
                AnalyticsEventType.FAVORITE,
                Map.of(
                        "wine_id", wineId,
                        "action", "removed"
                )
        );
    }

    @Override
    public FavoriteWineResponseDto getFavoriteWines() {
        User authenticatedUser = authenticatedUserService.getCurrentUser();

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

    @Override
    public UserResponseDto getCurrentUser() {
        User authenticatedUser = authenticatedUserService.getCurrentUser();
        UserResponseDto dto = userMapper.toDto(authenticatedUser);

        dto.setReviewCount(reviewRepository.countByUser(authenticatedUser));
        dto.setAchievementCount(userAchievementRepository.countByUser(authenticatedUser));

        return dto;
    }

    private Wine getWine(Long wineId) {
        return wineRepository.findById(wineId)
                .orElseThrow(() -> new WineNotFoundException(wineId));
    }
}

package com.winemood.winemood_backend.service.impl;

import com.winemood.winemood_backend.constants.security.SecurityConstants;
import com.winemood.winemood_backend.dto.request.UserLoginRequestDto;
import com.winemood.winemood_backend.dto.request.UserRegistrationRequestDto;
import com.winemood.winemood_backend.dto.response.AuthenticationResponseDto;
import com.winemood.winemood_backend.entity.User;
import com.winemood.winemood_backend.exceptions.RegistrationException;
import com.winemood.winemood_backend.repository.UserRepository;
import com.winemood.winemood_backend.security.JwtUtil;
import com.winemood.winemood_backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    @Override
    public AuthenticationResponseDto register(UserRegistrationRequestDto requestDto) throws RegistrationException {
        if (userRepository.findByEmail(requestDto.getEmail()).isPresent()) {
            throw new RegistrationException(SecurityConstants.EXISTING_USER);
        }
        User user = new User();
        user.setEmail(requestDto.getEmail());
        user.setName(requestDto.getName());
        user.setPassword(passwordEncoder.encode(requestDto.getPassword()));

        User savedUser = userRepository.save(user);
        String token = jwtUtil.generateToken(savedUser);

        return new AuthenticationResponseDto(
                token,
                SecurityConstants.TOKEN_TYPE
        );
    }

    @Override
    public AuthenticationResponseDto login(UserLoginRequestDto requestDto) {
        User user = userRepository.findByEmail(requestDto.getEmail())
                .orElseThrow(
                        () -> new BadCredentialsException(
                                SecurityConstants.INVALID_CREDENTIALS
                        )
                );

        if (!passwordEncoder.matches(requestDto.getPassword(), user.getPassword())) {
            throw new BadCredentialsException(
                    SecurityConstants.INVALID_CREDENTIALS
            );
        }
        String token = jwtUtil.generateToken(user);
        return new AuthenticationResponseDto(
                token,
                SecurityConstants.TOKEN_TYPE);
    }
}

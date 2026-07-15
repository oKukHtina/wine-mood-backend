package com.winemood.winemood_backend.service;

import com.winemood.winemood_backend.dto.request.UserLoginRequestDto;
import com.winemood.winemood_backend.dto.request.UserRegistrationRequestDto;
import com.winemood.winemood_backend.dto.response.AuthenticationResponseDto;
import com.winemood.winemood_backend.dto.response.UserResponseDto;
import com.winemood.winemood_backend.exceptions.RegistrationException;
import org.springframework.web.multipart.MultipartFile;

public interface UserService {
    AuthenticationResponseDto register(UserRegistrationRequestDto requestDto) throws RegistrationException;

    AuthenticationResponseDto login(UserLoginRequestDto requestDto);

    UserResponseDto uploadAvatar(MultipartFile image);

    UserResponseDto deleteAvatar();
}

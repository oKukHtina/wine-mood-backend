package com.winemood.winemood_backend.service;

import com.winemood.winemood_backend.dto.request.UserRegistrationRequestDto;
import com.winemood.winemood_backend.dto.response.AuthenticationResponseDto;
import com.winemood.winemood_backend.exceptions.RegistrationException;

public interface UserService {
    AuthenticationResponseDto register(UserRegistrationRequestDto requestDto) throws RegistrationException;
}

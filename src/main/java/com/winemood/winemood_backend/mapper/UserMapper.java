package com.winemood.winemood_backend.mapper;

import com.winemood.winemood_backend.dto.response.RegistrationResponseDto;
import com.winemood.winemood_backend.dto.response.UserResponseDto;
import com.winemood.winemood_backend.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mapping(target = "reviewCount", ignore = true)
    @Mapping(target = "achievementCount", ignore = true)
    UserResponseDto toDto(User user);
    RegistrationResponseDto toRegisterDto(User user);
}

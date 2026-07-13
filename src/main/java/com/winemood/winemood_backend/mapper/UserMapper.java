package com.winemood.winemood_backend.mapper;

import com.winemood.winemood_backend.dto.response.UserResponseDto;
import com.winemood.winemood_backend.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserResponseDto toDto(User user);
}

package com.winemood.winemood_backend.mapper;

import com.winemood.winemood_backend.dto.response.MoodResponseDto;
import com.winemood.winemood_backend.entity.Mood;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MoodMapper {
    MoodResponseDto toDto(Mood mood);
}

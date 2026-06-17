package com.winemood.winemood_backend.mapper;

import com.winemood.winemood_backend.dto.response.SweetnessLevelResponseDto;
import com.winemood.winemood_backend.entity.SweetnessLevel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SweetnessLevelMapper {
    SweetnessLevelResponseDto toDto(SweetnessLevel sweetnessLevel);
}

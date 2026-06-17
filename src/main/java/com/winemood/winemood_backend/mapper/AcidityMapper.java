package com.winemood.winemood_backend.mapper;

import com.winemood.winemood_backend.dto.response.AcidityResponseDto;
import com.winemood.winemood_backend.entity.Acidity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AcidityMapper {
    AcidityResponseDto toDto(Acidity entity);
}

package com.winemood.winemood_backend.mapper;

import com.winemood.winemood_backend.dto.response.GrapeVarietiesResponseDto;
import com.winemood.winemood_backend.entity.GrapeVariety;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GrapeVarietyMapper {
    GrapeVarietiesResponseDto toDto(GrapeVariety grapeVariety);
}

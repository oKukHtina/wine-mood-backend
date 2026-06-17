package com.winemood.winemood_backend.mapper;

import com.winemood.winemood_backend.dto.response.FilterMetadataResponseDto;
import com.winemood.winemood_backend.entity.FilterMetadata;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FilterMetadataMapper {
    FilterMetadataResponseDto toDto(FilterMetadata filterMetadata);
}

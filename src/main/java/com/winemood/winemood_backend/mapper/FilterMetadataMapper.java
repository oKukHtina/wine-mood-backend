package com.winemood.winemood_backend.mapper;

import com.winemood.winemood_backend.dto.response.FilterMetadataResponseDto;
import com.winemood.winemood_backend.entity.FilterMetadata;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface FilterMetadataMapper {
    @Mapping(target = "options", ignore = true)
    FilterMetadataResponseDto toDto(FilterMetadata filterMetadata);
}

package com.winemood.winemood_backend.mapper;

import com.winemood.winemood_backend.dto.response.WineResponseDto;
import com.winemood.winemood_backend.entity.Wine;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface WineMapper {
    @Mapping(source = "category.type", target = "type")
    WineResponseDto toDto(Wine wine);
}

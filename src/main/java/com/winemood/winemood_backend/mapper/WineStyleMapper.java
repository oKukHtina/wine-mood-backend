package com.winemood.winemood_backend.mapper;

import com.winemood.winemood_backend.dto.response.WineStyleResponseDto;
import com.winemood.winemood_backend.entity.WineStyle;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface WineStyleMapper {
    WineStyleResponseDto toDto(WineStyle wineStyle);
}

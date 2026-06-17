package com.winemood.winemood_backend.mapper;

import com.winemood.winemood_backend.dto.response.WineTasteProfileResponseDto;
import com.winemood.winemood_backend.entity.WineTasteProfile;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring",
        uses = {
                GrapeVarietyMapper.class,
                AcidityMapper.class,
                SweetnessLevelMapper.class,
                WineStyleMapper.class
        })
public interface WineTasteProfileMapper {
    @Mapping(source = "grapeVariety", target = "grapeVariety")
    @Mapping(source = "acidity", target = "acidity")
    @Mapping(source = "wineStyle", target = "wineStyle")
    WineTasteProfileResponseDto toDto(WineTasteProfile tasteProfile);
}

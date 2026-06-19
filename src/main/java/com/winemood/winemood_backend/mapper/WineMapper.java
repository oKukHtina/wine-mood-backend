package com.winemood.winemood_backend.mapper;

import com.winemood.winemood_backend.dto.response.WineCatalogResponseDto;
import com.winemood.winemood_backend.dto.response.WineResponseDto;
import com.winemood.winemood_backend.entity.Wine;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring",
        uses = {
                FoodMapper.class,
                SweetnessLevelMapper.class,
                WineStyleMapper.class,
                AromaNoteMapper.class,
                MoodMapper.class,
                EventMapper.class,
                SeasonMapper.class
        })
public interface WineMapper {
    @Mapping(source = "category.type", target = "type")
    @Mapping(source = "producer.name", target = "producerName")
    @Mapping(source = "producer.country.name", target = "countryName")
    @Mapping(source = "producer.region", target = "region")

    @Mapping(source = "tasteProfile.sweetnessLevel", target = "sweetnessLevel")
    @Mapping(source = "tasteProfile.agingMonths", target = "agingMonths")
    @Mapping(source = "tasteProfile.environmentalAttributes", target = "environmentalAttributes")
    @Mapping(source = "tasteProfile.fermentationType", target = "fermentationType")
    @Mapping(source = "tasteProfile.appellation", target = "appellation")
    @Mapping(source = "tasteProfile.grapeVariety", target = "grapeVariety")
    @Mapping(source = "tasteProfile.acidity", target = "acidity")
    @Mapping(source = "tasteProfile.wineStyle", target = "wineStyle")

    @Mapping(source = "foodPairings", target = "foodPairings")
    WineResponseDto toDto(Wine wine);

    @Mapping(source = "producer.country.name", target = "countryName")
    @Mapping(source = "category.type", target = "type")
    @Mapping(source = "tasteProfile.sweetnessLevel", target = "sweetnessLevel")

    WineCatalogResponseDto toCatalogDto(Wine wine);
}

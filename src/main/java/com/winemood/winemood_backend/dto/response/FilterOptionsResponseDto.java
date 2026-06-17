package com.winemood.winemood_backend.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FilterOptionsResponseDto {
    private List<FilterMetadataResponseDto> filterMetadata;
    private List<CountryResponseDto> countries;
    private List<MoodResponseDto> moods;
    private List<EventResponseDto> events;
    private List<SeasonResponseDto> seasons;

    private List<SweetnessLevelResponseDto> sweetnessLevels;
    private List<WineStyleResponseDto> wineStyles;
    private List<AcidityResponseDto> acidityLevels;

    private List<GrapeVarietiesResponseDto> grapeVarieties;
    private List<FoodFilterGroupResponseDto> foods;
}

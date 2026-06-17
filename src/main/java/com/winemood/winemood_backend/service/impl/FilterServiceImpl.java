package com.winemood.winemood_backend.service.impl;

import com.winemood.winemood_backend.dto.response.FilterOptionsResponseDto;
import com.winemood.winemood_backend.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FilterServiceImpl implements FilterService {

    private final FilterMetadataService filterMetadataService;

    private final CountryService countryService;
    private final MoodService moodService;
    private final EventService eventService;
    private final SeasonService seasonService;

    private final SweetnessLevelService sweetnessLevelService;
    private final WineStyleService wineStyleService;
    private final AcidityService acidityService;

    private final GrapeVarietyService grapeVarietyService;
    private final FoodService foodService;

    @Override
    public FilterOptionsResponseDto getFilterOptions() {

        return new FilterOptionsResponseDto(
                filterMetadataService.getAllFilters(),

                countryService.getAllCountries(),
                moodService.getAllMood(),
                eventService.getAllEvents(),
                seasonService.getAllSeasons(),

                sweetnessLevelService.getAllSweetnessLevel(),
                wineStyleService.getAllWineStyle(),
                acidityService.getAllAcidity(),

                grapeVarietyService.getAllGrapeVarieties(),
                foodService.getFoodFilterGroups()
        );
    }
}
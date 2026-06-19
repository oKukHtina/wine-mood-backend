package com.winemood.winemood_backend.filter.options.impl;

import com.winemood.winemood_backend.dto.response.MoodFilterOptionsResponseDto;
import com.winemood.winemood_backend.enums.FilterKey;
import com.winemood.winemood_backend.filter.options.FilterOptionProvider;
import com.winemood.winemood_backend.service.EventService;
import com.winemood.winemood_backend.service.MoodService;
import com.winemood.winemood_backend.service.SeasonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MoodFilterOptionProvider implements FilterOptionProvider {
    private final MoodService moodService;
    private final EventService eventService;
    private final SeasonService seasonService;

    @Override
    public FilterKey getKey() {
        return FilterKey.MOOD;
    }

    @Override
    public Object getOptions() {
        return new MoodFilterOptionsResponseDto(
                moodService.getAllMood(),
                eventService.getAllEvents(),
                seasonService.getAllSeasons()
        );
    }
}

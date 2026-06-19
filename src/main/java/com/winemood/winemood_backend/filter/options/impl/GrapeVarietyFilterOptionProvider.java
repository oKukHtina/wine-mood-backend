package com.winemood.winemood_backend.filter.options.impl;

import com.winemood.winemood_backend.enums.FilterKey;
import com.winemood.winemood_backend.filter.options.FilterOptionProvider;
import com.winemood.winemood_backend.service.GrapeVarietyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class GrapeVarietyFilterOptionProvider implements FilterOptionProvider {
    private final GrapeVarietyService service;
    @Override
    public FilterKey getKey() {
        return FilterKey.GRAPE_VARIETY;
    }

    @Override
    public Object getOptions() {
        return service.getAllGrapeVarieties();
    }
}

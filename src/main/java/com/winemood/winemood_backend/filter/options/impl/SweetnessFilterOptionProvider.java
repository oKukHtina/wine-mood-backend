package com.winemood.winemood_backend.filter.options.impl;

import com.winemood.winemood_backend.enums.FilterKey;
import com.winemood.winemood_backend.filter.options.FilterOptionProvider;
import com.winemood.winemood_backend.service.SweetnessLevelService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SweetnessFilterOptionProvider implements FilterOptionProvider {
    private final SweetnessLevelService service;

    @Override
    public FilterKey getKey() {
        return FilterKey.SWEETNESS;
    }

    @Override
    public Object getOptions() {
        return service.getAllSweetnessLevel();
    }
}

package com.winemood.winemood_backend.filter.options.impl;

import com.winemood.winemood_backend.enums.FilterKey;
import com.winemood.winemood_backend.filter.options.FilterOptionProvider;
import com.winemood.winemood_backend.service.FoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FoodFilterOptionProvider implements FilterOptionProvider {
    private final FoodService service;

    @Override
    public FilterKey getKey() {
        return FilterKey.FOOD_PAIRING;
    }

    @Override
    public Object getOptions() {
        return service.getFoodFilterGroups();
    }
}

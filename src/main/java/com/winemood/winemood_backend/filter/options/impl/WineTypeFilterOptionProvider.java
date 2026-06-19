package com.winemood.winemood_backend.filter.options.impl;

import com.winemood.winemood_backend.enums.FilterKey;
import com.winemood.winemood_backend.filter.options.FilterOptionProvider;
import com.winemood.winemood_backend.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class WineTypeFilterOptionProvider implements FilterOptionProvider {
    private final CategoryService service;

    @Override
    public FilterKey getKey() {
        return FilterKey.WINE_TYPE;
    }

    @Override
    public Object getOptions() {
        return service.getAllWineTypeFilterOptions();
    }
}

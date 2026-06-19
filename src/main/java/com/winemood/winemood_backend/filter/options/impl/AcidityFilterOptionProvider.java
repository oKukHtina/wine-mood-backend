package com.winemood.winemood_backend.filter.options.impl;

import com.winemood.winemood_backend.entity.Acidity;
import com.winemood.winemood_backend.enums.FilterKey;
import com.winemood.winemood_backend.filter.options.FilterOptionProvider;
import com.winemood.winemood_backend.service.AcidityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AcidityFilterOptionProvider implements FilterOptionProvider {
    private final AcidityService service;

    @Override
    public FilterKey getKey() {
        return FilterKey.ACIDITY;
    }

    @Override
    public Object getOptions() {
        return service.getAllAcidity();
    }
}

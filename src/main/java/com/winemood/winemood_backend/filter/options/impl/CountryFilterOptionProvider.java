package com.winemood.winemood_backend.filter.options.impl;

import com.winemood.winemood_backend.enums.FilterKey;
import com.winemood.winemood_backend.filter.options.FilterOptionProvider;
import com.winemood.winemood_backend.service.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CountryFilterOptionProvider implements FilterOptionProvider {
    private final CountryService countryService;

    @Override
    public FilterKey getKey() {
        return FilterKey.COUNTRY;
    }

    @Override
    public Object getOptions() {
        return countryService.getCountryFilterOptions();
    }
}

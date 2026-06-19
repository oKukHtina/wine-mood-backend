package com.winemood.winemood_backend.filter.options.impl;

import com.winemood.winemood_backend.enums.FilterKey;
import com.winemood.winemood_backend.filter.options.FilterOptionProvider;
import com.winemood.winemood_backend.service.WineStyleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class WineStyleFilterOptionProvider implements FilterOptionProvider {
    private final WineStyleService service;

    @Override
    public FilterKey getKey() {
        return FilterKey.WINE_STYLE;
    }

    @Override
    public Object getOptions() {
        return service.getAllWineStyle();
    }
}

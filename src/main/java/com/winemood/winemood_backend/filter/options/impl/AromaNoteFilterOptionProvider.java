package com.winemood.winemood_backend.filter.options.impl;

import com.winemood.winemood_backend.enums.FilterKey;
import com.winemood.winemood_backend.filter.options.FilterOptionProvider;
import com.winemood.winemood_backend.service.AromaNoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AromaNoteFilterOptionProvider implements FilterOptionProvider {
    private final AromaNoteService service;

    @Override
    public FilterKey getKey() {
        return FilterKey.AROMA_NOTE;
    }

    @Override
    public Object getOptions() {
        return service.getAllAromaNote();
    }
}

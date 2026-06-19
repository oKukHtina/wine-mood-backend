package com.winemood.winemood_backend.filter.options;

import com.winemood.winemood_backend.enums.FilterKey;

public interface FilterOptionProvider {
    FilterKey getKey();
    Object getOptions();
}

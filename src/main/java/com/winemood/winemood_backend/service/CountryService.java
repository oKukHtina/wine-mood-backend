package com.winemood.winemood_backend.service;

import com.winemood.winemood_backend.dto.response.CountryResponseDto;
import com.winemood.winemood_backend.dto.response.FilterCountryOptionResponseDto;

import java.util.List;

public interface CountryService {
    List<CountryResponseDto> getAllCountries();

    CountryResponseDto getCountryById(Long id);

    List<FilterCountryOptionResponseDto> getCountryFilterOptions();
}

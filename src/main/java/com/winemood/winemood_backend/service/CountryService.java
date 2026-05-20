package com.winemood.winemood_backend.service;

import com.winemood.winemood_backend.dto.response.CountryResponseDto;
import java.util.List;

public interface CountryService {
    List<CountryResponseDto> getAllCountries();

    CountryResponseDto getCountryById(Long id);
}

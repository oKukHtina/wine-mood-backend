package com.winemood.winemood_backend.service.impl;

import com.winemood.winemood_backend.dto.response.CountryResponseDto;
import com.winemood.winemood_backend.dto.response.FilterCountryOptionResponseDto;
import com.winemood.winemood_backend.exceptions.CountryNotFoundException;
import com.winemood.winemood_backend.mapper.CountryMapper;
import com.winemood.winemood_backend.repository.CountryRepository;
import com.winemood.winemood_backend.service.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CountryServiceImpl implements CountryService {
    private final CountryRepository repository;
    private final CountryMapper mapper;
    @Override
    public List<CountryResponseDto> getAllCountries() {
        return repository.findAll()
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    @Override
    public CountryResponseDto getCountryById(Long id) {
        return repository.findById(id)
                .map(mapper::toDto)
                .orElseThrow(() -> new CountryNotFoundException(id));
    }

    @Override
    public List<FilterCountryOptionResponseDto> getCountryFilterOptions() {
        return repository.findAll()
                .stream()
                .map(mapper::toFilterDto)
                .toList();
    }
}

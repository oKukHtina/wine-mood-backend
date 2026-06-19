package com.winemood.winemood_backend.mapper;

import com.winemood.winemood_backend.dto.response.CountryResponseDto;
import com.winemood.winemood_backend.dto.response.FilterCountryOptionResponseDto;
import com.winemood.winemood_backend.entity.Country;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CountryMapper {
    CountryResponseDto toDto(Country country);
    FilterCountryOptionResponseDto toFilterDto(Country country);
}

package com.winemood.winemood_backend.service;

import com.winemood.winemood_backend.dto.response.FilterMetadataResponseDto;

import java.util.List;

public interface FilterMetadataService {
    List<FilterMetadataResponseDto> getAllFilters();
}

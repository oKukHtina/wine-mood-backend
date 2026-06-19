package com.winemood.winemood_backend.service;

import com.winemood.winemood_backend.dto.response.AcidityResponseDto;

import java.util.List;

public interface AcidityService {
    List<AcidityResponseDto> getAllAcidity();
}

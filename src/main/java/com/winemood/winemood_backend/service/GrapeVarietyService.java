package com.winemood.winemood_backend.service;

import com.winemood.winemood_backend.dto.response.GrapeVarietiesResponseDto;

import java.util.List;

public interface GrapeVarietyService {
    List<GrapeVarietiesResponseDto> getAllGrapeVarieties();
}

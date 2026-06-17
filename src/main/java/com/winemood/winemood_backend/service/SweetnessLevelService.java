package com.winemood.winemood_backend.service;

import com.winemood.winemood_backend.dto.response.SweetnessLevelResponseDto;

import java.util.List;

public interface SweetnessLevelService {
    List<SweetnessLevelResponseDto> getAllSweetnessLevel();
}

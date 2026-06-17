package com.winemood.winemood_backend.service;

import com.winemood.winemood_backend.dto.response.SeasonResponseDto;

import java.util.List;

public interface SeasonService {
    List<SeasonResponseDto> getAllSeasons();
}

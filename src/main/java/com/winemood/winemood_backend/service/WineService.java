package com.winemood.winemood_backend.service;

import com.winemood.winemood_backend.dto.request.WineFilterRequestDto;
import com.winemood.winemood_backend.dto.response.ApiResponseDto;
import com.winemood.winemood_backend.dto.response.WineCatalogResponseDto;
import com.winemood.winemood_backend.dto.response.WineResponseDto;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface WineService {
    List<WineCatalogResponseDto> getAllWines(Pageable pageable);

    WineResponseDto getWineById(Long id);

    List<WineCatalogResponseDto> getRecommendations(Long wineId);

    ApiResponseDto<List<WineCatalogResponseDto>> filterWines(
            WineFilterRequestDto filterRequest,
            Pageable pageable
    );

    ApiResponseDto<List<WineCatalogResponseDto>> searchWines(String query, Pageable pageable);
}

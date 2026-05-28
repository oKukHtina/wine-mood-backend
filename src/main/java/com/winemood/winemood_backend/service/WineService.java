package com.winemood.winemood_backend.service;

import com.winemood.winemood_backend.dto.request.WineFilterRequestDto;
import com.winemood.winemood_backend.dto.response.WineCatalogResponseDto;
import com.winemood.winemood_backend.dto.response.WineResponseDto;
import java.util.List;

public interface WineService {
    List<WineCatalogResponseDto> getAllWines();

    WineResponseDto getWineById(Long id);

    List<WineCatalogResponseDto> filterWines(
            WineFilterRequestDto filterRequest
    );
}

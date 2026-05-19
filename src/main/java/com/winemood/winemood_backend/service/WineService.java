package com.winemood.winemood_backend.service;

import com.winemood.winemood_backend.dto.response.WineResponseDto;
import java.util.List;

public interface WineService {
    List<WineResponseDto> getAllWines();

    WineResponseDto getWineById(Long id);
}

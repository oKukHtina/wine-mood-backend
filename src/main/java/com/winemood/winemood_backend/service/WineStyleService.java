package com.winemood.winemood_backend.service;

import com.winemood.winemood_backend.dto.response.WineStyleResponseDto;

import java.util.List;

public interface WineStyleService {
    List<WineStyleResponseDto> getAllWineStyle();
}

package com.winemood.winemood_backend.service;

import com.winemood.winemood_backend.dto.WineResponse;

import java.util.List;

public interface WineService {
    List<WineResponse> getAllWines();

    WineResponse getWineById(Long id);
}

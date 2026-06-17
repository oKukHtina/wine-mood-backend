package com.winemood.winemood_backend.service;

import com.winemood.winemood_backend.dto.response.FoodFilterGroupResponseDto;
import com.winemood.winemood_backend.dto.response.FoodResponseDto;

import java.util.List;

public interface FoodService {
    List<FoodResponseDto> getAllFoods();

    List<FoodResponseDto> getFoodsByCategory(String category);

    List<FoodResponseDto> findByName(String name);

    List<FoodFilterGroupResponseDto> getFoodFilterGroups();
}

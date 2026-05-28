package com.winemood.winemood_backend.service;

import com.winemood.winemood_backend.dto.response.FoodResponseDto;
import com.winemood.winemood_backend.enums.FoodCategory;
import com.winemood.winemood_backend.enums.FoodType;
import java.util.List;

public interface FoodService {
    List<FoodResponseDto> getAllFoods();

    List<FoodResponseDto> getFoodsByCategory(FoodCategory category);

    List<FoodResponseDto> getFoodsByType(FoodType type);
}

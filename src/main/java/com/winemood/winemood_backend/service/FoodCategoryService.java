package com.winemood.winemood_backend.service;

import com.winemood.winemood_backend.dto.response.FoodCategoryResponseDto;

import java.util.List;

public interface FoodCategoryService {
    List<FoodCategoryResponseDto> getAllFoodCategory();
}

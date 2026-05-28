package com.winemood.winemood_backend.service.impl;

import com.winemood.winemood_backend.dto.response.FoodResponseDto;
import com.winemood.winemood_backend.enums.FoodCategory;
import com.winemood.winemood_backend.enums.FoodType;
import com.winemood.winemood_backend.mapper.FoodMapper;
import com.winemood.winemood_backend.repository.FoodRepository;
import com.winemood.winemood_backend.service.FoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FoodServiceImpl implements FoodService {
    private final FoodRepository foodRepository;
    private final FoodMapper foodMapper;

    @Override
    public List<FoodResponseDto> getAllFoods() {
        return foodRepository.findAll()
                .stream()
                .map(foodMapper::toDto)
                .toList();
    }

    @Override
    public List<FoodResponseDto> getFoodsByCategory(FoodCategory category) {
        return foodRepository.findByFoodCategory(category)
                .stream()
                .map(foodMapper::toDto)
                .toList();
    }

    @Override
    public List<FoodResponseDto> getFoodsByType(FoodType type) {
        return foodRepository.findByFoodType(type)
                .stream()
                .map(foodMapper::toDto)
                .toList();
    }
}

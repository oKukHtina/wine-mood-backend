package com.winemood.winemood_backend.service.impl;

import com.winemood.winemood_backend.dto.response.FoodFilterGroupResponseDto;
import com.winemood.winemood_backend.dto.response.FoodFilterOptionResponseDto;
import com.winemood.winemood_backend.dto.response.FoodResponseDto;
import com.winemood.winemood_backend.entity.Food;
import com.winemood.winemood_backend.mapper.FoodMapper;
import com.winemood.winemood_backend.repository.FoodRepository;
import com.winemood.winemood_backend.service.FoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
    public List<FoodResponseDto> getFoodsByCategory(String category) {
        return foodRepository.findByFoodCategory(category)
                .stream()
                .map(foodMapper::toDto)
                .toList();
    }

    @Override
    public List<FoodResponseDto> findByName(String type) {
        return foodRepository.findByName(type)
                .stream()
                .map(foodMapper::toDto)
                .toList();
    }

    @Override
    public List<FoodFilterGroupResponseDto> getFoodFilterGroups() {

        List<Food> foods = foodRepository.findAll();

        Map<String, List<FoodFilterOptionResponseDto>> grouped =
                foods.stream()
                        .collect(Collectors.groupingBy(
                                food -> food.getFoodCategory().getName(),
                                Collectors.mapping(
                                        foodMapper::toFilterDto,
                                        Collectors.toList()
                                )
                        ));

        return grouped.entrySet().stream()
                .map(entry -> new FoodFilterGroupResponseDto(
                        entry.getKey(),
                        entry.getValue()
                ))
                .toList();
    }
}

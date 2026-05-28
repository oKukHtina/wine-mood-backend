package com.winemood.winemood_backend.controller;

import com.winemood.winemood_backend.dto.response.FoodResponseDto;
import com.winemood.winemood_backend.enums.FoodCategory;
import com.winemood.winemood_backend.service.FoodService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/foods")
@Tag(name = "Foods", description = "Endpoints for food pairings")
public class FoodController {
    private final FoodService foodService;

    @GetMapping
    public List<FoodResponseDto> getAllFoods() {
        return foodService.getAllFoods();
    }

    @GetMapping("/category/{category}")
    public List<FoodResponseDto> getFoodsByCategory(
            @PathVariable FoodCategory category
    ) {
        return foodService.getFoodsByCategory(category);
    }
}

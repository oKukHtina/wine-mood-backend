package com.winemood.winemood_backend.controller;

import com.winemood.winemood_backend.dto.response.FoodCategoryResponseDto;
import com.winemood.winemood_backend.service.FoodCategoryService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/foodCategory")
@Tag(name = "Food Category", description = "Endpoints for managing food category")
public class FoodCategoryController {
    private final FoodCategoryService foodCategoryService;

    @GetMapping
    public List<FoodCategoryResponseDto> getAllFoodCategory() {
        return foodCategoryService.getAllFoodCategory();
    }
}

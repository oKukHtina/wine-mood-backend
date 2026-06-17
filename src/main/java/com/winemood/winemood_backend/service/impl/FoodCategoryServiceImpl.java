package com.winemood.winemood_backend.service.impl;

import com.winemood.winemood_backend.dto.response.FoodCategoryResponseDto;
import com.winemood.winemood_backend.mapper.FoodCategoryMapper;
import com.winemood.winemood_backend.repository.FoodCategoryRepository;
import com.winemood.winemood_backend.service.FoodCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FoodCategoryServiceImpl implements FoodCategoryService {
    private final FoodCategoryRepository repository;
    private final FoodCategoryMapper mapper;

    @Override
    public List<FoodCategoryResponseDto> getAllFoodCategory() {
        return repository.findAll()
                .stream()
                .map(mapper::toDto)
                .toList();
    }
}

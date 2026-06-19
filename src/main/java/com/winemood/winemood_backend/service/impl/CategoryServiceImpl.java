package com.winemood.winemood_backend.service.impl;

import com.winemood.winemood_backend.dto.response.CategoryUiResponseDto;
import com.winemood.winemood_backend.dto.response.FilterWineTypeOptionsResponseDto;
import com.winemood.winemood_backend.mapper.CategoryMapper;
import com.winemood.winemood_backend.repository.CategoryRepository;
import com.winemood.winemood_backend.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository repository;
    private final CategoryMapper mapper;

    @Override
    public List<CategoryUiResponseDto> getAllCategories() {
        return repository.findAll()
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    @Override
    public List<FilterWineTypeOptionsResponseDto> getAllWineTypeFilterOptions() {
        return repository.findAll()
                .stream()
                .map(mapper::toFilterDto)
                .toList();
    }
}

package com.winemood.winemood_backend.service.impl;

import com.winemood.winemood_backend.dto.CategoryResponse;
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
    public List<CategoryResponse> getAllCategories() {
        return repository.findAll()
                .stream()
                .map(mapper::toDto)
                .toList();
    }
}

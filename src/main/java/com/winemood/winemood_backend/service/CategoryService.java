package com.winemood.winemood_backend.service;

import com.winemood.winemood_backend.dto.CategoryUiResponse;

import java.util.List;

public interface CategoryService {
    List<CategoryUiResponse> getAllCategories();
}

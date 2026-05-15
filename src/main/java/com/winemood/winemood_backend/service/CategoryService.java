package com.winemood.winemood_backend.service;

import com.winemood.winemood_backend.dto.CategoryResponse;

import java.util.List;

public interface CategoryService {
    List<CategoryResponse> getAllCategories();
}

package com.winemood.winemood_backend.service;

import com.winemood.winemood_backend.dto.response.CategoryUiResponseDto;
import java.util.List;

public interface CategoryService {
    List<CategoryUiResponseDto> getAllCategories();
}

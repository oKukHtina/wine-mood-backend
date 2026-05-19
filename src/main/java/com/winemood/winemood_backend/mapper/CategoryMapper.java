package com.winemood.winemood_backend.mapper;

import com.winemood.winemood_backend.dto.CategoryUiResponse;
import com.winemood.winemood_backend.entity.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    CategoryUiResponse toDto(Category category);
}

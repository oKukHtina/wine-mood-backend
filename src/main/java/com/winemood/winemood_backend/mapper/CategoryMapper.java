package com.winemood.winemood_backend.mapper;

import com.winemood.winemood_backend.dto.CategoryResponse;
import com.winemood.winemood_backend.entity.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    CategoryResponse toDto(Category category);
    Category toEntity(CategoryResponse dto);
}

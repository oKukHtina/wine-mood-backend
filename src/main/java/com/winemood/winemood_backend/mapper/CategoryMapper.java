package com.winemood.winemood_backend.mapper;

import com.winemood.winemood_backend.dto.response.CategoryUiResponseDto;
import com.winemood.winemood_backend.entity.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    CategoryUiResponseDto toDto(Category category);
}

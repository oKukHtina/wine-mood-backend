package com.winemood.winemood_backend.mapper;

import com.winemood.winemood_backend.dto.response.FoodCategoryResponseDto;
import com.winemood.winemood_backend.entity.FoodCategory;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FoodCategoryMapper {
    FoodCategoryResponseDto toDto(FoodCategory foodCategory);
}

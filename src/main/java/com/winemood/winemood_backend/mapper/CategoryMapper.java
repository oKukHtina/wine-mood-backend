package com.winemood.winemood_backend.mapper;

import com.winemood.winemood_backend.dto.response.CategoryUiResponseDto;
import com.winemood.winemood_backend.dto.response.FilterWineTypeOptionsResponseDto;
import com.winemood.winemood_backend.entity.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    CategoryUiResponseDto toDto(Category category);

    @Mapping(source = "title", target = "name")
    FilterWineTypeOptionsResponseDto toFilterDto(Category category);
}

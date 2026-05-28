package com.winemood.winemood_backend.mapper;

import com.winemood.winemood_backend.dto.response.FoodResponseDto;
import com.winemood.winemood_backend.entity.Food;
import org.mapstruct.Mapper;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface FoodMapper {
    FoodResponseDto toDto(Food food);

    Set<FoodResponseDto> toDtoSet(Set<Food> foods);
}

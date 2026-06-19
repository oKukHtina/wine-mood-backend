package com.winemood.winemood_backend.mapper;

import com.winemood.winemood_backend.dto.response.FoodFilterOptionResponseDto;
import com.winemood.winemood_backend.dto.response.FoodResponseDto;
import com.winemood.winemood_backend.entity.Food;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Set;

@Mapper(componentModel = "spring",
        uses = {
                FoodCategoryMapper.class
        })
public interface FoodMapper {

    @Mapping(source = "foodCategory", target = "foodCategory")
    FoodResponseDto toDto(Food food);

    Set<FoodResponseDto> toDtoSet(Set<Food> foods);

    FoodFilterOptionResponseDto toFilterDto(Food food);

    default String map(Food food) {
        return food.getName();
    }
}

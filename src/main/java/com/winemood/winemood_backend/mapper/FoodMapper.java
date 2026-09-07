package com.winemood.winemood_backend.mapper;

import com.winemood.winemood_backend.dto.response.FoodFilterOptionResponseDto;
import com.winemood.winemood_backend.dto.response.FoodResponseDto;
import com.winemood.winemood_backend.entity.Food;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring",
        uses = {
                FoodCategoryMapper.class
        })
public interface FoodMapper {

    @Mapping(source = "foodCategory", target = "foodCategory")
    FoodResponseDto toDto(Food food);

    default List<FoodResponseDto> toDtoList(Set<Food> foods) {
        return foods.stream()
                .sorted(Comparator.comparing(Food::getName))
                .map(this::toDto)
                .toList();
    }

    FoodFilterOptionResponseDto toFilterDto(Food food);

    default String map(Food food) {
        return food.getName();
    }
}

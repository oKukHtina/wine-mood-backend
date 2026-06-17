package com.winemood.winemood_backend.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FoodResponseDto {
    private Long id;
    private String foodImageUrl;
    private FoodCategoryResponseDto foodCategory;
    private String name;
}

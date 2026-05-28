package com.winemood.winemood_backend.dto.response;

import com.winemood.winemood_backend.enums.FoodCategory;
import com.winemood.winemood_backend.enums.FoodType;
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
    private FoodCategory foodCategory;
    private FoodType foodType;
}

package com.winemood.winemood_backend.dto;

import com.winemood.winemood_backend.enums.CategoryType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryResponse {
    private Long id;
    private String title;
    private CategoryType type;
    private String image;
}

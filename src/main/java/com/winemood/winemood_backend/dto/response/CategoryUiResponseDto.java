package com.winemood.winemood_backend.dto.response;

import com.winemood.winemood_backend.enums.CategoryType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryUiResponseDto {
    private Long id;
    private String title;
    private CategoryType type;
    private String image;
}

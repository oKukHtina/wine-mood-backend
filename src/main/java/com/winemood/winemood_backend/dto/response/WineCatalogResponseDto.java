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
public class WineCatalogResponseDto {
    private Long id;
    private String name;
    private CategoryType type;
    private SweetnessLevelResponseDto sweetnessLevel;
    private Integer volumeMl;
    private String countryName;
    private String imageUrl;
    private Double rating;
}

package com.winemood.winemood_backend.dto.response;

import com.winemood.winemood_backend.enums.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.math.BigDecimal;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WineResponseDto {
    private Long id;
    private String name;
    private CategoryType type;
    private Integer volumeMl;
    private String description;
    private String imageUrl;
    private BigDecimal alcoholPercentage;
    private SweetnessLevel sweetnessLevel;
    private GrapeVariety grapeVariety;
    private Integer agingMonths;
    private Set<EnvironmentalAttribute> environmentalAttributes;
    private String fermentationType;
    private Integer vintage;
    private String appellation;
    private String producerName;
    private String countryName;
    private String region;
    private Double rating;
    private Set<FoodResponseDto> foodPairings;
}

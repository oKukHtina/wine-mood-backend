package com.winemood.winemood_backend.dto.response;

import com.winemood.winemood_backend.enums.CategoryType;
import com.winemood.winemood_backend.enums.EnvironmentalAttribute;
import io.swagger.v3.oas.annotations.media.Schema;
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
@Schema(description = "Detailed wine information")
public class WineResponseDto {
    @Schema(
            description = "Wine identifier",
            example = "15"
    )
    private Long id;

    @Schema(
            description = "Wine name",
            example = "Merlot Reserve"
    )
    private String name;

    @Schema(
            description = "Whether this wine is in the authenticated user's favorites",
            example = "true"
    )
    private boolean favorite;

    @Schema(
            description = "Wine description",
            example = "Dry red wine with notes of blackberry, plum and vanilla."
    )
    private String description;

    @Schema(
            description = "Wine image URL",
            example = "https://example.com/images/merlot.jpg"
    )
    private String imageUrl;

    @Schema(
            description = "Producer name",
            example = "Antinori"
    )
    private String producerName;

    @Schema(
            description = "Country of origin",
            example = "Italy"
    )
    private String countryName;

    @Schema(
            description = "Region of origin",
            example = "Tuscany"
    )
    private String region;

    @Schema(
            description = "Average user rating",
            example = "4.37"
    )
    private BigDecimal rating;

    @Schema(
            description = "Wine category",
            example = "RED"
    )
    private CategoryType type;

    @Schema(
            description = "Bottle volume in milliliters",
            example = "750"
    )
    private Integer volumeMl;

    @Schema(
            description = "Wine sweetness level"
    )
    private SweetnessLevelResponseDto sweetnessLevel;

    private BigDecimal alcoholPercentage;

    private GrapeVarietiesResponseDto grapeVariety;

    private Integer agingMonths;

    private Set<EnvironmentalAttribute> environmentalAttributes;

    private String fermentationType;

    private Integer vintage;

    private String appellation;

    private AcidityResponseDto acidity;

    private Set<FoodResponseDto> foodPairings;

    private WineStyleResponseDto wineStyle;
}

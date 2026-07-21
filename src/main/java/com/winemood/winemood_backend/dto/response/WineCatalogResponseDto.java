package com.winemood.winemood_backend.dto.response;

import com.winemood.winemood_backend.enums.CategoryType;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Short information about a wine displayed in catalogs, search results and quiz recommendations")
public class WineCatalogResponseDto {
    @Schema(
            description = "Unique wine identifier",
            example = "15"
    )
    private Long id;

    @Schema(
            description = "Wine name",
            example = "Château Margaux 2018"
    )
    private String name;

    @Schema(
            description = "Wine category",
            example = "RED"
    )
    private CategoryType type;

    @Schema(
            description = "Wine sweetness level"
    )
    private SweetnessLevelResponseDto sweetnessLevel;

    @Schema(
            description = "Bottle volume in milliliters",
            example = "750"
    )
    private Integer volumeMl;

    @Schema(
            description = "Country of origin",
            example = "France"
    )
    private String countryName;

    @Schema(
            description = "URL of the wine image",
            example = "https://res.cloudinary.com/demo/image/upload/wine.jpg"
    )
    private String imageUrl;

    @Schema(
            description = "Average user rating",
            example = "4.8"
    )
    private Double rating;

    @Schema(
            description = "Whether the wine is in the authenticated user's favorites",
            example = "true"
    )
    private boolean favorite;
}

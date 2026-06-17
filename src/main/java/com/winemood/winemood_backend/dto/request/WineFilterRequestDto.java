package com.winemood.winemood_backend.dto.request;

import com.winemood.winemood_backend.enums.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Wine filtering request")
public class WineFilterRequestDto {
    @Schema(
            example = "[\"RED\", \"ROSE\","
                    + " \"SPARKLING\",  \"PREMIUM\"]"
    )
    private Set<CategoryType> wineTypes;

    @Schema(example = "[\"DRY\", \"SEMI_DRY\"]")
    private Set<String> sweetnessLevels;

    @Schema(
            example = "[\"Portugal\", \"France\", \"Italy\","
                    + " \"Spain\", \"United States\", \"Australia\"]"
    )
    private Set<String> countries;


    @Schema(example = "[\"CABERNET_SAUVIGNON\", \"MERLOT\"]")
    private Set<String> grapeVarieties;

    @Schema(example = "[\"LIGHT_BODIED\", \"FULL_BODIED\"]")
    private Set<String> wineStyles;

    @Schema(example = "[\"LOW\", \"HIGH\"]")
    private Set<String> acidityLevels;

    @Schema(example = "[\"CITRUS\", \"BERRY\"]")
    private Set<String> aromaNotes;

    @Schema(example = "[\"RELAX\", \"ROMANTIC\"]")
    private Set<String> moods;

    @Schema(example = "[\"DATE\", \"PARTY\"]")
    private Set<String> events;

    @Schema(example = "[\"SUMMER\", \"WINTER\"]")
    private Set<String> seasons;

    @Schema(example = "[\"RED_MEAT\", \"WHITE_MEAT\", \"PORK\", "
            + "\"GAME_MEAT\", \"WHITE_FISH\", \"FATTY_FISH\", \"SEAFOOD\"]")
    private Set<String> foodName;
}

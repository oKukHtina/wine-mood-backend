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

    @Schema(
            example = "[\"DRY\", \"SEMI_DRY\", "
                    + "\"SEMI_SWEET\", \"SWEET\", \"BRUT\"]"
    )
    private Set<SweetnessLevel> sweetnessLevels;

    @Schema(
            example = "[\"Portugal\", \"France\", \"Italy\","
                    + " \"Spain\", \"United States\", \"Australia\"]"
    )
    private Set<String> countries;


    @Schema(example = "[\"CABERNET_SAUVIGNON\",\"MERLOT\",\"PINOT_NOIR\","
            + "\"SHIRAZ\",\"TEMPRANILLO\",\"SANGIOVESE\", \"CHARDONNAY\",\"GRENACHE\","
            + "\"SYRAH\",\"BLEND\", \"TOURIGA_NACIONAL\",\"LOUREIRO\", "
            + "\"ARINTO\",\"NEBBIOLO\",\"MONTEPULCIANO\",\"MACABEO\","
            + "\"PARELLADA\",\"ZINFANDEL\",\"MUSCAT\"]")
    private Set<GrapeVariety> grapeVarieties;

    @Schema(example = "[\"FULL_BODIED\",\"MEDIUM_BODIED\",\"LIGHT_BODIED\"]")
    private Set<WineStyle> wineStyles;

    @Schema(example = "[\"MEDIUM\", \"LOW\", \"HIGH\"]")
    private Set<Acidity> acidityLevels;

    @Schema(example = "[\"FRUITY\", \"FLORAL\", \"SPICY\", "
            + "\"OAKY\", \"MINERAL\", \"NUTTY_HONEY\"]")
    private Set<AromaNote> aromaNotes;

    @Schema(example = "[\"ROMANTIC\", \"RELAX\", \"CELEBRATION\", "
            + "\"ENERGETIC\", \"INTELLECTUAL_TASTING\", \"PARTY\","
            + " \"DINNER_WITH_FRIENDS\", \"PICNIC\"]")
    private Set<Mood> moods;

    @Schema(example = "[\"RED_MEAT\", \"WHITE_MEAT\", \"PORK\", "
            + "\"GAME_MEAT\", \"WHITE_FISH\", \"FATTY_FISH\", \"SEAFOOD\","
            + " \"SUSHI\", \"PASTA_TOMATO\", \"PASTA_CREAM\", \"PASTA_SEAFOOD\", "
            + "\"PIZZA\", \"SOFT_CHEESE\", \"HARD_CHEESE\", "
            + "\"BLUE_CHEESE\", \"SALAD\", \"ANTIPASTI\", "
            + "\"HUMMUS_TAPAS\", \"ASIAN_CUISINE\", \"INDIAN_CUISINE\", "
            + "\"MEXICAN_CUISINE\", \"SPICY_FOOD\", \"CHOCOLATE\", "
            + "\"FRUIT_DESSERT\", \"BAKERY\"]")
    private Set<FoodType> foodTypes;
}

package com.winemood.winemood_backend.dto.request;

import com.winemood.winemood_backend.enums.QuizScoreKey;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Quiz answers used to calculate wine recommendations")
public class QuizRequestDto {
   @Schema(
           description = """
                    "experienceLevel" : BEGINNER, ENTHUSIAST, CONNOISSEUR
                    """,
           example = "BEGINNER"
   )
   private String experienceLevel;

   @Schema(
           description = """
                   Quiz answers map.
                                       
                   \nKey = question identifier.
                   \nValue = selected answer.
                                       
                   \nAvailable keys and values:
                   \nWINE_TYPE : RED, ROSE, SPARKLING, PREMIUM
                   \nSWEETNESS : DRY, SEMI_DRY, SEMI_SWEET, SWEET, BRUT
                   \nCOUNTRY : USA, PORTUGAL, SPAIN, ITALY, FRANCE, AUSTRALIA
                   \nREGION : BURGUNDY ,BORDEAUX, PIEDMONT, RIOJA, NICHE REGIONS, PROVENCE, RIBERA DEL DUERO
                   \nGRAPE_VARIETY : CABERNET SAUVIGNON, MERLOT, PINOT NOIR, CHARDONNAY, MUSCAT, GRENACHE, BLEND
                   \nFOOD_CATEGORY :MEAT, FISH_SEAFOOD, PASTA_PIZZA, CHEESE, LIGHT_DISHES, DESSERT
                   \nAROMA_NOTES : FRUITY, FLORAL, SPICY, OAKY, MINERAL, NUTTY_HONEY
                   \nPRICE_LEVEL : BUDGET, MID_RANGE, HIGHER_TIER
                   \nAGING_POTENTIAL : DRINK_NOW, SHORT_TERM_AGING, LONG_TERM_AGING
                   \nWINE_STYLE : LIGHT_BODIED, MEDIUM_BODIED, FULL_BODIED
                   \nENVIRONMENTAL_ATTRIBUTES : ORGANIC, BIODYNAMIC, VEGAN, NATURAL, SUSTAINABLE
                   \nEVENT : PICNIC, DATE, PARTY, GIFT, DINNER_WITH_FRIENDS
                   """
           ,
           example = """
        {
          "WINE_TYPE": "RED",
          "FOOD_CATEGORY": "MEAT",
          "AROMA_NOTES": "FRUITY",
          "PRICE_LEVEL": "MID_RANGE"
        }
        """
   )
   private Map<QuizScoreKey, String> answers;
}

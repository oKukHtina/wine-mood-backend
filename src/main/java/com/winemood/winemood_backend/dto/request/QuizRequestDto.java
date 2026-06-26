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
                   \nWINE_TYPE : RED, ROSE, SPARKLING, PREMIUM, NO_PREFERENCE
                   \nSWEETNESS : DRY, SEMI_DRY, SEMI_SWEET, SWEET, BRUT, OPEN_TO_EXPERIMENT
                   \nCOUNTRY : USA, PORTUGAL, SPAIN, ITALY, FRANCE, AUSTRALIA, OPEN_TO_EXPERIMENT
                   \nREGION : BURGUNDY, BORDEAUX, PIEDMONT, RIOJA, NICHE_REGIONS, PROVENCE, RIBERA_DEL_DUERO, NO_PREFERENCE
                   \nGRAPE_VARIETY : CABERNET_SAUVIGNON, MERLOT, PINOT_NOIR, CHARDONNAY, MUSCAT, GRENACHE, BLEND, NO_PREFERENCE
                   \nFOOD_CATEGORY :MEAT, FISH_SEAFOOD, PASTA_PIZZA, CHEESE, LIGHT_DISHES, DESSERT, UNIVERSAL
                   \nAROMA_NOTES : FRUITY, FLORAL, SPICY, OAKY, MINERAL, NUTTY_HONEY, NO_PREFERENCE
                   \nPRICE_LEVEL : BUDGET, MID_RANGE, HIGHER_TIER, NO_PREFERENCE
                   \nAGING_POTENTIAL : DRINK_NOW, SHORT_TERM_AGING, LONG_TERM_AGING, NO_PREFERENCE
                   \nWINE_STYLE : LIGHT_BODIED, MEDIUM_BODIED, FULL_BODIED, NO_PREFERENCE
                   \nENVIRONMENTAL_ATTRIBUTES : ORGANIC, BIODYNAMIC, VEGAN, NATURAL, SUSTAINABLE, NO_PREFERENCE
                   \nEVENT : PICNIC, DATE, PARTY, GIFT, DINNER_WITH_FRIENDS, UNIVERSAL
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

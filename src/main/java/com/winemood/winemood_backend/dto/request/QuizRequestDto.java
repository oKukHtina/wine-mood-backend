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
                    User experience level.
                    
                    Available values:
                    BEGINNER
                    ENTHUSIAST
                    CONNOISSEUR
                    """,
           example = "BEGINNER"
   )
   private String experienceLevel;

   @Schema(
           description = """
                    Quiz answers map.
                    
                    Key = question identifier.
                    Value = selected answer.
                    
                    Available keys:
                    WINE_TYPE
                    SWEETNESS
                    COUNTRY
                    REGION
                    GRAPE_VARIETY
                    FOOD_CATEGORY
                    AROMA_NOTES
                    PRICE_LEVEL
                    AGING_POTENTIAL
                    WINE_STYLE
                    ENVIRONMENTAL_ATTRIBUTES
                    EVENT
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

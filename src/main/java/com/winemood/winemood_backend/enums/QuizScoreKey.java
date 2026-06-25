package com.winemood.winemood_backend.enums;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Supported quiz scoring criteria")
public enum QuizScoreKey {
    @Schema(description = """
            VALUES:
            DRINK_NOW
            SHORT_TERM_AGING
            LONG_TERM_AGING""")
    AGING_POTENTIAL,

    @Schema(description = """
            VALUES:
            FRUITY
            FLORAL
            SPICY
            OAKY
            MINERAL
            NUTTY_HONEY""")
    AROMA_NOTES,

    @Schema(description = """
            VALUES:
            USA
            PORTUGAL
            SPAIN
            ITALY""")
    COUNTRY,
    @Schema(description = """
            VALUES:
            ORGANIC
            BIODYNAMIC
            VEGAN
            NATURAL
            SUSTAINABLE""")
    ENVIRONMENTAL_ATTRIBUTES,
    @Schema(description = """
           VALUES:
           PICNIC
           DATE
           PARTY
           GIFT
           DINNER_WITH_FRIENDS""")
    EVENT,
    @Schema(description = """
            VALUES:
            MEAT
            FISH_SEAFOOD
            PASTA_PIZZA
            CHEESE
            LIGHT_DISHES
            DESSERT""")
    FOOD_CATEGORY,
    @Schema(description = """
            VALUES:
            CABERNET_SAUVIGNON
            MERLOT
            PINOT_NOIR
            SHIRAZ
            TEMPRANILLO
            SANGIOVESE
            CHARDONNAY
            GRENACHE
            """)
    GRAPE_VARIETY,
    @Schema(description = """
            VALUES:
            BUDGET
            MID_RANGE
            HIGHER_TIER""")
    PRICE_LEVEL,
    @Schema(description = """
            VALUES:
            BURGUNDY
            BORDEAUX
            PIEDMONT
            RIOJA
            NICHE REGIONS
            PROVENCE
            RIBERA DEL DUERO
            """)
    REGION,

    @Schema(description = """
             VALUES:
             DRY
             SEMI_DRY
             SEMI_SWEET
             SWEET
             BRUT""")
    SWEETNESS,

    @Schema(description = """
            VALUES:
            LIGHT_BODIED
            MEDIUM_BODIED
            FULL_BODIED""")
    WINE_STYLE,

    @Schema(description = """
            VALUES:
            RED
            ROSE
            SPARKLING
            PREMIUM""")
    WINE_TYPE
}

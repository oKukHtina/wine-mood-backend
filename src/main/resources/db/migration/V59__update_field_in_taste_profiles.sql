UPDATE wine_taste_profiles
SET grape_variety = (
    SELECT grape_variety
    FROM wines
    WHERE wines.id = wine_taste_profiles.wine_id
),
aging_months = (
    SELECT aging_months
    FROM wines
    WHERE wines.id = wine_taste_profiles.wine_id
),
fermentation_type = (
    SELECT fermentation_type
    FROM wines
    WHERE wines.id = wine_taste_profiles.wine_id
),
appellation = (
    SELECT appellation
    FROM wines
    WHERE wines.id = wine_taste_profiles.wine_id
),
acidity = (
    SELECT acidity
    FROM wines
    WHERE wines.id = wine_taste_profiles.wine_id
),
sweetness_level = (
    SELECT sweetness_level
    FROM wines
    WHERE wines.id = wine_taste_profiles.wine_id
),
wine_style = (
    SELECT wine_style
    FROM wines
    WHERE wines.id = wine_taste_profiles.wine_id
);
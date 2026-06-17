UPDATE wine_taste_profiles
SET sweetness_id = (
    SELECT id
    FROM sweetness_levels
    WHERE sweetness_levels.name = wine_taste_profiles.sweetness_level
);
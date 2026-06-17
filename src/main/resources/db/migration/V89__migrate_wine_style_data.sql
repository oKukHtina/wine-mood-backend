UPDATE wine_taste_profiles
SET wine_style_id = (
    SELECT id
    FROM wine_styles
    WHERE wine_styles.name = wine_taste_profiles.wine_style
);
UPDATE wine_taste_profiles
SET acidity_id = (
    SELECT id
    FROM acidity
    WHERE acidity.name = wine_taste_profiles.acidity
);
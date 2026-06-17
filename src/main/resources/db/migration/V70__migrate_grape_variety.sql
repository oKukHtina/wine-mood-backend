UPDATE wine_taste_profiles
SET grape_variety_id = (
    SELECT gv.id
    FROM grape_varieties gv
    WHERE gv.name = wine_taste_profiles.grape_variety
);
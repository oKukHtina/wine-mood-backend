UPDATE wine_environmental_attributes
SET wine_taste_profile_id = (
    SELECT wtp.id
    FROM wine_taste_profiles wtp
    WHERE wtp.wine_id = wine_environmental_attributes.wine_id
);
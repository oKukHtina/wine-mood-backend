UPDATE wine_aroma_notes wan
SET wine_taste_profile_id = (
    SELECT wtp.id
    FROM wine_taste_profiles wtp
    WHERE wtp.wine_id = wan.wine_id
);
ALTER TABLE wine_taste_profiles
ADD CONSTRAINT fk_taste_profile_sweetness
FOREIGN KEY (sweetness_id)
REFERENCES sweetness_levels(id);
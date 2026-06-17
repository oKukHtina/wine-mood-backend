ALTER TABLE wine_taste_profiles
ADD CONSTRAINT fk_wine_taste_profiles_grape_variety
FOREIGN KEY (grape_variety_id)
REFERENCES grape_varieties(id);
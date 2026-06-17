ALTER TABLE wine_taste_profiles
ADD COLUMN wine_style_id BIGINT;

ALTER TABLE wine_taste_profiles
ADD CONSTRAINT fk_taste_profile_wine_style
FOREIGN KEY (wine_style_id)
REFERENCES wine_styles(id);
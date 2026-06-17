ALTER TABLE wine_taste_profiles
ADD COLUMN acidity_id BIGINT;

ALTER TABLE wine_taste_profiles
ADD CONSTRAINT fk_taste_profile_acidity
FOREIGN KEY (acidity_id)
REFERENCES acidity(id);
ALTER TABLE wine_aroma_notes
ADD CONSTRAINT fk_aroma_notes_taste_profile
FOREIGN KEY (wine_taste_profile_id)
REFERENCES wine_taste_profiles(id);
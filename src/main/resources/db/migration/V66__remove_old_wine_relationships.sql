ALTER TABLE wine_aroma_notes
DROP CONSTRAINT fk_wine_aroma_notes_wine;

ALTER TABLE wine_environmental_attributes
DROP CONSTRAINT fk_wine_environmental_attributes_wine;

ALTER TABLE wine_aroma_notes
DROP COLUMN wine_id;

ALTER TABLE wine_environmental_attributes
DROP COLUMN wine_id;
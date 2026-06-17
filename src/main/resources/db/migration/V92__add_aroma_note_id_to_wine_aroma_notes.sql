ALTER TABLE wine_aroma_notes
ADD COLUMN aroma_note_id BIGINT;

ALTER TABLE wine_aroma_notes
ADD CONSTRAINT fk_wine_aroma_note
FOREIGN KEY (aroma_note_id)
REFERENCES aroma_notes(id);
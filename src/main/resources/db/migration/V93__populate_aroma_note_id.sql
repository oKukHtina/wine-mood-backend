UPDATE wine_aroma_notes wan
SET aroma_note_id = (
    SELECT an.id
    FROM aroma_notes an
    WHERE an.name = wan.aroma_note
);
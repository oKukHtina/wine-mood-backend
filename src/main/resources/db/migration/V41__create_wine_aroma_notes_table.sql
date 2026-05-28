CREATE TABLE wine_aroma_notes (
    wine_id BIGINT NOT NULL,
    aroma_note VARCHAR(50) NOT NULL,

    CONSTRAINT fk_wine_aroma_notes_wine
        FOREIGN KEY (wine_id)
        REFERENCES wines(id)
);
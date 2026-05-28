CREATE TABLE wine_moods (
    wine_id BIGINT NOT NULL,
    mood VARCHAR(50) NOT NULL,
    CONSTRAINT fk_wine_moods_wine
        FOREIGN KEY (wine_id) REFERENCES wines(id)
        ON DELETE CASCADE
);

CREATE INDEX idx_wine_moods_wine_id ON wine_moods(wine_id);
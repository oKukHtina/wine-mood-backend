CREATE TABLE wine_seasons (
    wine_id BIGINT NOT NULL,
    season VARCHAR(50) NOT NULL,
    CONSTRAINT fk_wine_seasons_wine
        FOREIGN KEY (wine_id) REFERENCES wines(id)
        ON DELETE CASCADE
);

CREATE INDEX idx_wine_seasons_wine_id ON wine_seasons(wine_id);
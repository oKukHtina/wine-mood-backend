CREATE TABLE wine_events (
    wine_id BIGINT NOT NULL,
    event VARCHAR(50) NOT NULL,
    CONSTRAINT fk_wine_events_wine
        FOREIGN KEY (wine_id) REFERENCES wines(id)
        ON DELETE CASCADE
);

CREATE INDEX idx_wine_events_wine_id ON wine_events(wine_id);
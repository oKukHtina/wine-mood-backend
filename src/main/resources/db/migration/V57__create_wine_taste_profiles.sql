CREATE TABLE wine_taste_profiles (
    id BIGSERIAL PRIMARY KEY,
    wine_id BIGINT NOT NULL UNIQUE,

    grape_variety VARCHAR(255),
    aging_months INTEGER,
    fermentation_type VARCHAR(255),
    appellation VARCHAR(100),

    acidity VARCHAR(255),
    sweetness_level VARCHAR(255),
    wine_style VARCHAR(255),

    CONSTRAINT fk_taste_profile_wine
        FOREIGN KEY (wine_id)
        REFERENCES wines(id)
        ON DELETE CASCADE
);
CREATE TABLE wine_environmental_attributes (
    wine_id BIGINT NOT NULL,

    environmental_attribute VARCHAR(50) NOT NULL,

    CONSTRAINT fk_wine_environmental_attributes_wine
        FOREIGN KEY (wine_id)
        REFERENCES wines(id)
        ON DELETE CASCADE
);
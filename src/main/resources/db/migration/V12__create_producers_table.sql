CREATE TABLE producers (
    id BIGSERIAL PRIMARY KEY,

    name VARCHAR(255) NOT NULL,

    country_id BIGINT,

    region VARCHAR(255) NOT NULL,

    bottle_image_url VARCHAR(500) NOT NULL,

    FOREIGN KEY (country_id)
        REFERENCES countries(id)
);
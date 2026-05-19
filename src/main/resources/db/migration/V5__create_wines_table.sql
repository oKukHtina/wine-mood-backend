CREATE TABLE wines (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    volume_ml INTEGER,
    description TEXT NOT NULL,
    image_url VARCHAR(500) NOT NULL,

    category_id BIGINT,

    FOREIGN KEY (category_id)
        REFERENCES categories(id)
);
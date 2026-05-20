CREATE TABLE countries (
    id BIGSERIAL PRIMARY KEY,

    name VARCHAR(255) NOT NULL UNIQUE,

    nationality VARCHAR(255) NOT NULL,

    flag_image_url VARCHAR(500) NOT NULL
);
CREATE TABLE grape_varieties (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL UNIQUE,
    grape_icon_url TEXT
);
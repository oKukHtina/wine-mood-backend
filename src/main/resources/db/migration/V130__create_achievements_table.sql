CREATE TABLE achievements
(
    id BIGSERIAL PRIMARY KEY,

    code VARCHAR(100) NOT NULL UNIQUE,

    title VARCHAR(255) NOT NULL,

    description VARCHAR(1000),

    icon_url VARCHAR(1000)
);
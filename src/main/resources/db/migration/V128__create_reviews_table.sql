CREATE TABLE reviews
(
    id BIGSERIAL PRIMARY KEY,

    user_id BIGINT NOT NULL,
    wine_id BIGINT NOT NULL,

    rating NUMERIC(3,2) NOT NULL,

    review_text VARCHAR(2000) NOT NULL,

    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP NOT NULL,

    CONSTRAINT fk_review_user
        FOREIGN KEY (user_id)
            REFERENCES users(id)
            ON DELETE CASCADE,

    CONSTRAINT fk_review_wine
        FOREIGN KEY (wine_id)
            REFERENCES wines(id)
            ON DELETE CASCADE,

    CONSTRAINT uk_review_user_wine
        UNIQUE (user_id, wine_id)
);
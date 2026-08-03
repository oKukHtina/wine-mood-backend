CREATE TABLE user_wine_history (
    id BIGSERIAL PRIMARY KEY,
    user_id BIGINT NOT NULL,
    wine_id BIGINT NOT NULL,
    viewed_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT fk_user_wine_history_user
        FOREIGN KEY (user_id)
        REFERENCES users(id)
        ON DELETE CASCADE,

    CONSTRAINT fk_user_wine_history_wine
        FOREIGN KEY (wine_id)
        REFERENCES wines(id)
        ON DELETE CASCADE,

    CONSTRAINT uk_user_wine_history
        UNIQUE (user_id, wine_id)
);
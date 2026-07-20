CREATE TABLE favorite_wines (
    user_id BIGINT NOT NULL,
    wine_id BIGINT NOT NULL,

    CONSTRAINT pk_favorite_wines
        PRIMARY KEY (user_id, wine_id),

    CONSTRAINT fk_favorite_wines_user
        FOREIGN KEY (user_id)
        REFERENCES users(id)
        ON DELETE CASCADE,

    CONSTRAINT fk_favorite_wines_wine
        FOREIGN KEY (wine_id)
        REFERENCES wines(id)
        ON DELETE CASCADE
);
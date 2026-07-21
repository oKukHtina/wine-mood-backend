CREATE TABLE quiz_results
(
    id BIGSERIAL PRIMARY KEY,
    user_id BIGINT NOT NULL,
    created_at TIMESTAMP NOT NULL,

    CONSTRAINT fk_quiz_result_user
        FOREIGN KEY (user_id)
            REFERENCES users(id)
            ON DELETE CASCADE
);

CREATE TABLE quiz_result_wines
(
    quiz_result_id BIGINT NOT NULL,
    wine_id BIGINT NOT NULL,
    position INTEGER NOT NULL,

    PRIMARY KEY (quiz_result_id, position),

    CONSTRAINT fk_quiz_result
        FOREIGN KEY (quiz_result_id)
            REFERENCES quiz_results(id)
            ON DELETE CASCADE,

    CONSTRAINT fk_quiz_result_wine
        FOREIGN KEY (wine_id)
            REFERENCES wines(id)
);
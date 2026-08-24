CREATE TABLE quiz_result_answers (
    id BIGSERIAL PRIMARY KEY,
    quiz_result_id BIGINT NOT NULL,
    answer_key VARCHAR(100) NOT NULL,
    answer_value VARCHAR(255) NOT NULL,

    CONSTRAINT fk_quiz_result_answers_quiz_result
        FOREIGN KEY (quiz_result_id)
        REFERENCES quiz_results(id)
        ON DELETE CASCADE
);

CREATE INDEX idx_quiz_result_answers_quiz_result_id
    ON quiz_result_answers(quiz_result_id);
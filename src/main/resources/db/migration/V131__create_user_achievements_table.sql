CREATE TABLE user_achievements
(
    id BIGSERIAL PRIMARY KEY,

    user_id BIGINT NOT NULL,

    achievement_id BIGINT NOT NULL,

    earned_at TIMESTAMP NOT NULL,

    CONSTRAINT fk_user_achievement_user
        FOREIGN KEY (user_id)
            REFERENCES users(id)
            ON DELETE CASCADE,

    CONSTRAINT fk_user_achievement_achievement
        FOREIGN KEY (achievement_id)
            REFERENCES achievements(id)
            ON DELETE CASCADE,

    CONSTRAINT uk_user_achievement
        UNIQUE (user_id, achievement_id)
);
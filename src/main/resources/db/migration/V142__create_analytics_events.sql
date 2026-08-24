CREATE TABLE analytics_events (
    id BIGSERIAL PRIMARY KEY,
    user_id BIGINT,
    event_type VARCHAR(100) NOT NULL,
    created_at TIMESTAMP NOT NULL,
    event_data TEXT,

    CONSTRAINT fk_analytics_events_user
        FOREIGN KEY (user_id)
        REFERENCES users(id)
        ON DELETE SET NULL
);
ALTER TABLE wine_events
ADD COLUMN event_id BIGINT;

ALTER TABLE wine_events
ADD CONSTRAINT fk_wine_event
FOREIGN KEY (event_id)
REFERENCES events(id);
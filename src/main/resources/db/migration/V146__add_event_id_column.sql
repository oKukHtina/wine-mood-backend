ALTER TABLE analytics_events
ADD COLUMN event_id VARCHAR(255);

UPDATE analytics_events
SET event_id = 'legacy-' || id
WHERE event_id IS NULL;

ALTER TABLE analytics_events
ALTER COLUMN event_id SET NOT NULL;

ALTER TABLE analytics_events
ADD CONSTRAINT uk_analytics_events_event_id UNIQUE (event_id);
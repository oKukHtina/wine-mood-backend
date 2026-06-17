UPDATE wine_events we
SET event_id = (
    SELECT e.id
    FROM events e
    WHERE e.name = we.event
);
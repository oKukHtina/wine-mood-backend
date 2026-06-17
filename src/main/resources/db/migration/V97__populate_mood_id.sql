UPDATE wine_moods wm
SET mood_id = (
    SELECT m.id
    FROM moods m
    WHERE m.name = wm.mood
);
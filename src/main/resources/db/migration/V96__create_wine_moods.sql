ALTER TABLE wine_moods
ADD COLUMN mood_id BIGINT;

ALTER TABLE wine_moods
ADD CONSTRAINT fk_wine_mood
FOREIGN KEY (mood_id)
REFERENCES moods(id);
ALTER TABLE wine_seasons
ADD COLUMN season_id BIGINT;

ALTER TABLE wine_seasons
ADD CONSTRAINT fk_wine_seasons_season
FOREIGN KEY (season_id)
REFERENCES seasons(id);
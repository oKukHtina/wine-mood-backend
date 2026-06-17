UPDATE wine_seasons ws
SET season_id = (
    SELECT s.id
    FROM seasons s
    WHERE s.name = ws.season
);
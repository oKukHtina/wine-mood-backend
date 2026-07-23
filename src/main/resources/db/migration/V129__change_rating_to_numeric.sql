ALTER TABLE wines
ALTER COLUMN rating TYPE NUMERIC(4,2)
USING rating::numeric(4,2);
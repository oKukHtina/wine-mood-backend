ALTER TABLE wines
ADD COLUMN alcohol_percentage NUMERIC(4,1);

ALTER TABLE wines
ADD COLUMN sweetness_level VARCHAR(50);

ALTER TABLE wines
ADD COLUMN grape_variety VARCHAR(50);

ALTER TABLE wines
ADD COLUMN aging_months INTEGER;
ALTER TABLE wines DROP COLUMN sweetness_level;
ALTER TABLE wines DROP COLUMN grape_variety;
ALTER TABLE wines DROP COLUMN wine_style;
ALTER TABLE wines DROP COLUMN acidity;

ALTER TABLE wine_taste_profiles DROP COLUMN grape_variety;
ALTER TABLE wine_taste_profiles DROP COLUMN wine_style;
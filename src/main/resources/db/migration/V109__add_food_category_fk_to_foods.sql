DELETE FROM foods
WHERE food_category = 'SPICES_CUISINES';

ALTER TABLE foods
ADD COLUMN food_category_id BIGINT;

UPDATE foods f
SET food_category_id = (
    SELECT fc.id
    FROM food_categories fc
    WHERE fc.name = f.food_category
);

ALTER TABLE foods
ADD CONSTRAINT fk_foods_food_category
FOREIGN KEY (food_category_id)
REFERENCES food_categories(id);
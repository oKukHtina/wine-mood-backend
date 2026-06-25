CREATE TABLE price_level (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL UNIQUE
);

CREATE TABLE aging_potential (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL UNIQUE
);

INSERT INTO price_level (name)
VALUES
    ('BUDGET'),
    ('MID_RANGE'),
    ('HIGHER_TIER');

INSERT INTO aging_potential (name)
VALUES
    ('DRINK_NOW'),
    ('SHORT_TERM_AGING'),
    ('LONG_TERM_AGING');

ALTER TABLE wines
ADD COLUMN price_level_id BIGINT;

ALTER TABLE wines
ADD COLUMN aging_potential_id BIGINT;

ALTER TABLE wines
ADD CONSTRAINT fk_wines_price_level
    FOREIGN KEY (price_level_id)
    REFERENCES price_level(id);

ALTER TABLE wines
ADD CONSTRAINT fk_wines_aging_potential
    FOREIGN KEY (aging_potential_id)
    REFERENCES aging_potential(id);
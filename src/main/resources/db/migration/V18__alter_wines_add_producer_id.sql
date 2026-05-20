ALTER TABLE wines
ADD COLUMN producer_id BIGINT;

ALTER TABLE wines
ADD CONSTRAINT fk_wines_producer
FOREIGN KEY (producer_id)
REFERENCES producers(id);
UPDATE wines
SET acidity = 'HIGH'
WHERE id IN (22, 23, 26, 27, 30, 31, 33, 36, 39, 40);

UPDATE wines
SET acidity = 'MEDIUM'
WHERE id IN (21, 25, 28, 29, 32, 34, 35, 37);

UPDATE wines
SET acidity = 'LOW'
WHERE id IN (24, 38);
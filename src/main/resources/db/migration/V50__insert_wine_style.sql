UPDATE wines SET wine_style = 'FULL_BODIED'
WHERE id IN (24, 25, 28, 29, 32, 34, 37);

UPDATE wines SET wine_style = 'LIGHT_BODIED'
WHERE id IN (22, 26, 30, 33, 39, 23, 27, 31, 36, 40);

UPDATE wines SET wine_style = 'MEDIUM_BODIED'
WHERE id IN (21, 35, 38);
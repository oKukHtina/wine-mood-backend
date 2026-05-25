INSERT INTO wines (
    name,
    volume_ml,
    description,
    image_url,
    category_id,
    producer_id,
    alcohol_percentage,
    sweetness_level,
    grape_variety,
    aging_months,
    fermentation_type,
    vintage,
    appellation
)
VALUES
(
'Antinori Tignanello',
750,
'Iconic Tuscan red blend known for its elegance, structure, and notes of cherry, plum, and spice.',
'https://res.cloudinary.com/dtnzeg5vh/image/upload/v1779741123/AntinoriTignanello_ampi3u.svg',
1,
11,
13.5,
'DRY',
'SANGIOVESE',
24,
'Fermentation in temperature-controlled stainless steel tanks followed by aging in French and Hungarian oak barrels for complexity and refined tannins.',
2019,
'Tuscany'
),

(
'Martini Rosato',
750,
'Fresh Italian rosé with floral aromas, red berries, and a soft, balanced palate.',
'https://res.cloudinary.com/dtnzeg5vh/image/upload/v1779741173/MartiniRosato_c534pn.svg',
2,
12,
11.5,
'SEMI_SWEET',
'BLEND',
0,
'Cold fermentation in stainless steel tanks to preserve delicate fruit aromas and floral freshness.',
2023,
'Piedmont'
),

(
'Martini Asti',
750,
'Sweet sparkling wine with aromas of peach, pear, and white flowers, light and aromatic.',
'https://res.cloudinary.com/dtnzeg5vh/image/upload/v1779741217/MartiniAsti_e4evvd.svg',
3,
12,
7.5,
'SWEET',
'MUSCAT',
0,
'Partial fermentation with controlled temperature to retain natural grape sweetness and delicate sparkling character.',
2024,
'Asti'
),

(
'Sassicaia',
750,
'Prestigious Bolgheri wine with deep structure, black fruit, herbal notes, and refined oak complexity.',
'https://res.cloudinary.com/dtnzeg5vh/image/upload/v1779741257/Sassicaia_cl2hlr.svg',
4,
13,
14.0,
'DRY',
'CABERNET_SAUVIGNON',
30,
'Fermentation in stainless steel vats followed by extended maceration and long aging in French oak barrels for depth and elegance.',
2018,
'Bolgheri'
);
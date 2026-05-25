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
'Yellow Tail Shiraz',
750,
'Easy-drinking Australian Shiraz with ripe berry flavors, soft tannins, and a smooth finish.',
'https://res.cloudinary.com/dtnzeg5vh/image/upload/v1779742434/YellowTailShiraz_d7fbqp.svg',
1,
20,
13.5,
'DRY',
'SHIRAZ',
12,
'Fermentation in stainless steel tanks with controlled temperature followed by short oak aging for softness.',
2022,
'South Australia'
),

(
'Jacob’s Creek Sparkling Rosé',
750,
'Light and refreshing sparkling rosé with strawberry, raspberry, and citrus notes.',
'https://res.cloudinary.com/dtnzeg5vh/image/upload/v1779742496/Jacob_sCreekSparklingRos%C3%A9_ybu3fq.svg',
3,
24,
11.5,
'BRUT',
'GRENACHE',
0,
'Secondary fermentation in sealed tanks to create fine bubbles while preserving fresh fruit character.',
2023,
'South Australia'
),

(
'Penfolds Grange',
750,
'Iconic Australian Shiraz with intense dark fruit, spice, and powerful oak structure.',
'https://res.cloudinary.com/dtnzeg5vh/image/upload/v1779742549/PenfoldsGrange_tzou4m.svg',
1,
20,
14.5,
'DRY',
'SHIRAZ',
36,
'Extended fermentation and long maturation in new oak barrels for deep complexity and aging potential.',
2018,
'South Australia'
);
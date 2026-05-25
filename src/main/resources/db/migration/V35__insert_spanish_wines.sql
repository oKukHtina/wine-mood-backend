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
'Vega Sicilia Único',
750,
'Iconic Spanish red wine with deep complexity, notes of dark fruit, tobacco, leather, and long aging potential.',
'https://res.cloudinary.com/dtnzeg5vh/image/upload/v1779741579/VegaSicilia%C3%9Anico_b0lk1o.svg',
1,
15,
14.0,
'DRY',
'TEMPRANILLO',
36,
'Long fermentation in stainless steel tanks followed by extended aging in oak barrels for exceptional depth and structure.',
2014,
'Ribera del Duero'
),

(
'Freixenet Rosado',
750,
'Fresh Spanish rosé with bright red berry aromas, citrus notes, and light refreshing acidity.',
'https://res.cloudinary.com/dtnzeg5vh/image/upload/v1779741683/FreixenetRosado_ujahzc.svg',
2,
16,
11.5,
'SEMI_DRY',
'GRENACHE',
0,
'Cold fermentation in stainless steel tanks to preserve fruity and floral aromas.',
2023,
'Catalonia'
),

(
'Freixenet Cordon Negro',
750,
'Crisp and elegant Spanish sparkling wine with apple, citrus, and toasted bread notes.',
'https://res.cloudinary.com/dtnzeg5vh/image/upload/v1779741721/FreixenetCordonNegro_n46gux.svg',
3,
16,
11.5,
'BRUT',
'MACABEO',
12,
'Traditional method sparkling fermentation in bottle with extended lees aging for fine bubbles.',
2022,
'Cava'
);
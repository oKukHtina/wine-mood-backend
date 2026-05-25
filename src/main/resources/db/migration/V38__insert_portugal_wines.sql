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
'Graham’s Six Grapes Port',
750,
'Rich and intense Port wine with deep notes of blackberry, plum, chocolate, and spice with a velvety finish.',
'https://res.cloudinary.com/dtnzeg5vh/image/upload/v1779742942/Graham_sSixGrapesPort_t2vs15.svg',
4,
21,
20.0,
'SWEET',
'TOURIGA_NACIONAL',
36,
'Traditional foot trodden fermentation followed by fortification with grape spirit to preserve natural sweetness and aging in oak casks.',
2018,
'Douro Valley'
),

(
'Mateus Rosé',
750,
'Light and slightly sparkling rosé with fresh red berry flavors and a soft, semi-sweet finish.',
'https://res.cloudinary.com/dtnzeg5vh/image/upload/v1779742993/MateusRos%C3%A9_ti6ecn.svg',
2,
22,
11.0,
'SEMI_SWEET',
'BLEND',
0,
'Controlled cool fermentation in stainless steel tanks to maintain freshness and fruity character.',
2023,
'Bairrada'
),

(
'Vinho Verde Espumante',
750,
'Crisp and refreshing sparkling wine with citrus, green apple, and light mineral notes.',
'https://res.cloudinary.com/dtnzeg5vh/image/upload/v1779743033/VinhoVerdeEspumante_eohkop.svg',
3,
23,
11.5,
'SEMI_DRY',
'LOUREIRO',
0,
'Low-temperature fermentation to preserve natural acidity and delicate aromatic profile with slight natural effervescence.',
2023,
'Vinho Verde'
);
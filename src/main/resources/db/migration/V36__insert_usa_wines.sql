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
'Robert Mondavi Cabernet Sauvignon',
750,
'Smooth Napa Valley Cabernet with rich blackberry, vanilla, and oak notes.',
'https://res.cloudinary.com/dtnzeg5vh/image/upload/v1779742025/RobertMondaviCabernetSauvignon_g4ohwf.svg',
1,
17,
13.5,
'DRY',
'CABERNET_SAUVIGNON',
18,
'Fermentation in stainless steel tanks followed by aging in oak barrels to develop structure and soft tannins.',
2020,
'Napa Valley'
),

(
'Hampton Water Rosé',
750,
'Fresh and vibrant rosé with notes of strawberry, watermelon, and citrus.',
'https://res.cloudinary.com/dtnzeg5vh/image/upload/v1779742070/HamptonWaterRos%C3%A9_dmspcu.svg',
2,
18,
12.5,
'DRY',
'GRENACHE',
0,
'Cold fermentation in stainless steel tanks to preserve bright fruit aromas and freshness.',
2023,
'California'
),

(
'Opus One',
750,
'Luxury Napa Valley wine with deep complexity, dark fruit, chocolate, and elegant oak structure.',
'https://res.cloudinary.com/dtnzeg5vh/image/upload/v1779742106/OpusOne_vkheuz.svg',
4,
19,
14.0,
'DRY',
'CABERNET_SAUVIGNON',
24,
'Carefully controlled fermentation followed by long aging in French oak barrels for refinement and depth.',
2019,
'Napa Valley'
);
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
'Château Margaux',
750,
'Elegant Bordeaux red wine with notes of blackcurrant, cedar, and spice.',
'https://images.example.com/chateau-margaux.jpg',
1,
1,
13.5,
'DRY',
'CABERNET_SAUVIGNON',
24,
'Fermented in temperature-controlled stainless steel tanks followed by aging in French oak barrels with extended maceration for structure and complexity.',
2015,
'Bordeaux'
),

(
'Whispering Angel Rosé',
750,
'Fresh and fruity French rosé with strawberry and citrus aromas.',
'https://images.example.com/whispering-angel.jpg',
2,
2,
12.5,
'DRY',
'BLEND',
0,
'Cold fermentation in stainless steel tanks to preserve fresh fruit character and delicate floral aromas.',
2023,
'Provence'
),

(
'Moët & Chandon Brut Impérial',
750,
'Classic French champagne with apple and brioche aromas.',
'https://images.example.com/moet-brut-imperial.jpg',
3,
6,
12.0,
'BRUT',
'CHARDONNAY',
36,
'Traditional bottle fermentation (Méthode Champenoise) with extended lees aging to develop fine bubbles and creamy texture.',
2019,
'Champagne'
),

(
'Château Lafite Rothschild',
750,
'Legendary Bordeaux wine with elegant structure and cassis flavors.',
'https://images.example.com/lafite-rothschild.jpg',
4,
9,
13.0,
'DRY',
'CABERNET_SAUVIGNON',
24,
'Fermentation in stainless steel vats followed by long maceration on skins and aging in new French oak barrels for complexity and depth.',
2016,
'Pauillac'
);
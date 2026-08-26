INSERT INTO mood_assets (id, title, image_url)
VALUES
    ('celebration', 'Celebration',
     'https://res.cloudinary.com/dtnzeg5vh/image/upload/v1787783681/celebration_weqbc1.svg'),
    ('cozy', 'Cozy Evening',
     'https://res.cloudinary.com/dtnzeg5vh/image/upload/v1787783686/cozy-evening_nkdg52.svg'),
    ('dateNight', 'Date Night',
     'https://res.cloudinary.com/dtnzeg5vh/image/upload/v1787783700/date-night_ywedby.svg'),
    ('culinary', 'Culinary',
     'https://res.cloudinary.com/dtnzeg5vh/image/upload/v1787783692/culinary_d9mpnn.svg');

INSERT INTO history_woman_images (id, image_url)
VALUES
    ('default', 'https://res.cloudinary.com/dtnzeg5vh/image/upload/v1787783022/history-woman-default_icozmj.png'),
    ('cozy', 'https://res.cloudinary.com/dtnzeg5vh/image/upload/v1787783057/history-woman-cozy-evening_io6fjj.png'),
    ('dateNight', 'https://res.cloudinary.com/dtnzeg5vh/image/upload/v1787783147/history-woman-date-night_ijghvr.png'),
    ('culinary', 'https://res.cloudinary.com/dtnzeg5vh/image/upload/v1787783111/history-woman-culinary_k6rpxw.png'),
    ('celebration', 'https://res.cloudinary.com/dtnzeg5vh/image/upload/v1787783068/history-woman-celebration_gzawiv.png');

INSERT INTO history_origins (id, title, description, image_url)
VALUES
(
    'origins',
    'Origins of Wine',
    'Wine is one of the oldest alcoholic beverages in human history. Archaeological evidence suggests that winemaking began more than 8,000 years ago in the region of present-day Georgia. Clay vessels containing traces of fermented grapes reveal humanity''s long-standing relationship with wine.',
    'https://res.cloudinary.com/dtnzeg5vh/image/upload/v1787783373/history-wine-origins_rdonje.png'
),
(
    'ancient-civilizations',
    'Wine in Ancient Civilizations',
    'The Egyptians, Greeks, and Romans considered wine an essential part of daily life. It was used in religious ceremonies, celebrations, and trade. The Romans played a major role in spreading viticulture throughout Europe.',
    'https://res.cloudinary.com/dtnzeg5vh/image/upload/v1787783352/history-ancient-civilizations_m2xmkt.png'
),
(
    'monastic-traditions',
    'Monastic Traditions',
    'During the Middle Ages, monasteries became centers of winemaking knowledge. Monks carefully documented vineyard practices, improved cultivation techniques, and helped preserve wine culture across Europe.',
    'https://res.cloudinary.com/dtnzeg5vh/image/upload/v1787783360/history-monastic-traditions_eiovpd.png'
),
(
    'modern-wine-culture',
    'Modern Wine Culture',
    'Today, wine connects tradition with modern taste. From family vineyards to global wine regions, it continues to shape gastronomy, travel, celebration, and cultural identity.',
    'https://res.cloudinary.com/dtnzeg5vh/image/upload/v1787783367/history-wine-culture_t3navy.png'
);


INSERT INTO history_timeline (id, image_url, text)
VALUES
(
    '1920s',
    'https://res.cloudinary.com/dtnzeg5vh/image/upload/v1787783500/timeline-1920s_cxbath.png',
    'The first family winery and the beginning of a tradition.'
),
(
    '1950s',
    'https://res.cloudinary.com/dtnzeg5vh/image/upload/v1787783509/timeline-1950s_uqqoed.png',
    'Expansion of vineyards and refinement of winemaking techniques.'
),
(
    '1980s',
    'https://res.cloudinary.com/dtnzeg5vh/image/upload/v1787783517/timeline-1980s_omfqq1.png',
    'New technologies introduced while preserving classic methods.'
),
(
    'today',
    'https://res.cloudinary.com/dtnzeg5vh/image/upload/v1787783524/timeline-today_d0amvk.png',
    'Modern wine culture connects tradition, technology, and personal taste.'
);

INSERT INTO site_assets (section, asset_key, image_url)
VALUES
(
    'home',
    'heroBackgroundUrl',
    'https://res.cloudinary.com/dtnzeg5vh/image/upload/v1787783829/home_jg1hes.svg'
),
(
    'shared',
    'pagePatternUrl',
    'https://res.cloudinary.com/dtnzeg5vh/image/upload/v1787784127/aboutUs-pattern_fhkpmg.png'
),
(
    'auth',
    'backgroundUrl',
    'https://res.cloudinary.com/dtnzeg5vh/image/upload/v1787784012/2026-08-27_01.39.23_o3dnk1.jpg'
),
(
    'about',
    'bottleImageUrl',
    'https://res.cloudinary.com/dtnzeg5vh/image/upload/v1787783872/about_pyu9zi.svg'
),
(
    'reviews',
    'wineBackdropUrl',
    'https://res.cloudinary.com/dtnzeg5vh/image/upload/v1787784086/2026-08-27_01.40.44_o8zkgl.jpg'
);
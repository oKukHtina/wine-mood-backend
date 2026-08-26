CREATE TABLE mood_assets (
    id VARCHAR(100) PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    image_url TEXT NOT NULL
);

CREATE TABLE history_woman_images (
    id VARCHAR(100) PRIMARY KEY,
    image_url TEXT NOT NULL
);

CREATE TABLE history_origins (
    id VARCHAR(100) PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    description TEXT NOT NULL,
    image_url TEXT NOT NULL
);

CREATE TABLE history_timeline (
    id VARCHAR(100) PRIMARY KEY,
    image_url TEXT NOT NULL,
    text TEXT NOT NULL
);

CREATE TABLE site_assets (
    id BIGSERIAL PRIMARY KEY,
    section VARCHAR(100) NOT NULL,
    asset_key VARCHAR(255) NOT NULL,
    image_url TEXT NOT NULL,

    CONSTRAINT uk_site_assets_section_key
        UNIQUE (section, asset_key)
);
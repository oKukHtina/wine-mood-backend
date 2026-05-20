ALTER TABLE countries
ADD COLUMN bottle_image_url VARCHAR(500) NOT NULL
DEFAULT 'https://res.cloudinary.com/dfh79de67/image/upload/v1779274641/wine_rodv6f.png';
ALTER TABLE categories
RENAME COLUMN image TO home_image;

ALTER TABLE categories
ADD COLUMN profile_image VARCHAR(255);

UPDATE categories
SET profile_image = 'https://res.cloudinary.com/dtnzeg5vh/image/upload/v1784405000/red_pd3fs6.png'
WHERE type = 'RED';

UPDATE categories
SET profile_image = 'https://res.cloudinary.com/dtnzeg5vh/image/upload/v1784405035/rose_xcjyf8.png'
WHERE type = 'ROSE';

UPDATE categories
SET profile_image = 'https://res.cloudinary.com/dtnzeg5vh/image/upload/v1784405060/sparkling_aruijl.png'
WHERE type = 'SPARKLING';

UPDATE categories
SET profile_image = 'https://res.cloudinary.com/dtnzeg5vh/image/upload/v1784405085/premium_wpj9iu.png'
WHERE type = 'PREMIUM';
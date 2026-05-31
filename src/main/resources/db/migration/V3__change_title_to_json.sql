-- V3: Change title column from VARCHAR to JSON to support TitleItem list
-- First, convert existing string titles to JSON array format
UPDATE page_sections SET title = CONCAT('[{"type":"text","icon":"","text":"', REPLACE(REPLACE(title, '"', '\\"'), '\n', '\\n'), '"}]') WHERE title IS NOT NULL AND title NOT LIKE '[%';

-- Then alter column type
ALTER TABLE page_sections MODIFY COLUMN title JSON;

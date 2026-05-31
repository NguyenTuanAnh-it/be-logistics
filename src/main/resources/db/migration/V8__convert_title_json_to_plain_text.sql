-- V8__convert_title_json_to_plain_text.sql
-- Convert title from JSON [{"icon":"","text":"...","type":"text"}] to plain text string

UPDATE page_sections
SET title = JSON_UNQUOTE(JSON_EXTRACT(title, '$[0].text'))
WHERE title IS NOT NULL
  AND title LIKE '[%';

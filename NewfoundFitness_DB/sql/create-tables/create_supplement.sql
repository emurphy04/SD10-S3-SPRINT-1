-- This script creates the supplement table
-- The table stores information about supplements including current stock and reorder number

CREATE TABLE supplement (
    supplement_id SERIAL PRIMARY KEY,
    price_id INT REFERENCES price(price_id),
    supplement_name VARCHAR(100) NOT NULL,
    current_stock INT NOT NULL,
    reorder_number INT NOT NULL
);

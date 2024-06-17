-- This script creates the price table
-- The table stores price amounts for memberships and supplements

CREATE TABLE price (
    price_id SERIAL PRIMARY KEY,
    price_amount NUMERIC(10, 2) NOT NULL
);

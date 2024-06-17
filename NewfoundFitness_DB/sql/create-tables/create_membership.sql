-- This script creates the membership table
-- The table stores information about gym memberships, linking to price

CREATE TABLE membership (
    membership_id SERIAL PRIMARY KEY,
    price_id INT REFERENCES price(price_id),
    membership_length INT NOT NULL
);

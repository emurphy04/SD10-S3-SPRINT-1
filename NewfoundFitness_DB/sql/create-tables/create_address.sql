-- This script creates the address table
-- The table stores address details including street name, city, province, and postal code
CREATE TABLE address (
    address_id SERIAL PRIMARY KEY,
    street_name VARCHAR(255) NOT NULL,
    city VARCHAR(100) NOT NULL,
    province VARCHAR(100) NOT NULL,
    postal_code VARCHAR(20) NOT NULL
);

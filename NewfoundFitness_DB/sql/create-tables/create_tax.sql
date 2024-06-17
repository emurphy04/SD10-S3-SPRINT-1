-- This script creates the tax table
-- The table stores information about tax rates

CREATE TABLE tax (
    tax_id SERIAL PRIMARY KEY,
    tax_rate NUMERIC(5, 2) NOT NULL
);

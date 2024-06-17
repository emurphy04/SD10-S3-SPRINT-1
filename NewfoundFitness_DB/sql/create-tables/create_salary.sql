-- This script creates the salary table
-- The table stores salary amounts for employees

CREATE TABLE salary (
    salary_id SERIAL PRIMARY KEY,
    salary_amount NUMERIC(10, 2) NOT NULL
);

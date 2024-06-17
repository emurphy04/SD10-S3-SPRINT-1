-- This script creates the person_info table
-- The table stores information about individuals such as first name, last name, and email

CREATE TABLE person_info (
    name_id SERIAL PRIMARY KEY,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL
);

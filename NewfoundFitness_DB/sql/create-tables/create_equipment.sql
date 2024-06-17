-- This script creates the equipment table
-- The table stores information about gym equipment including purchase date and availability status

CREATE TABLE equipment (
    equipment_id SERIAL PRIMARY KEY,
    equipment_name VARCHAR(100) NOT NULL,
    purchase_date DATE NOT NULL,
    availability_status VARCHAR(50) NOT NULL CHECK (availability_status IN ('available', 'not available', 'under maintenance'))
);

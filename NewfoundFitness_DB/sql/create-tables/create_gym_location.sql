-- This script creates the gym_location table
-- The table stores information about gym locations, linking to addresses and managers

CREATE TABLE gym_location (
    gym_id SERIAL PRIMARY KEY,
    address_id INT REFERENCES address(address_id),
    manager_id INT REFERENCES manager(manager_id)
);

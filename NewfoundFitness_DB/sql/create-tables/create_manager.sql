-- This script creates the manager table
-- The table stores information about managers, linking to person_info, address, and salary

CREATE TABLE manager (
    manager_id SERIAL PRIMARY KEY,
    name_id INT REFERENCES person_info(name_id),
    address_id INT REFERENCES address(address_id),
    salary_id INT REFERENCES salary(salary_id)
);

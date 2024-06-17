-- This script creates the staff table
-- The table stores information about staff members, linking to person_info and salary

CREATE TABLE staff (
    employee_id SERIAL PRIMARY KEY,
    name_id INT REFERENCES person_info(name_id),
    salary_id INT REFERENCES salary(salary_id)
);

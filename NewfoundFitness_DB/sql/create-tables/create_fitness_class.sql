-- This script creates the fitness_class table
-- The table stores information about fitness classes including class name, maximum capacity, and instructor

CREATE TABLE fitness_class (
    class_id SERIAL PRIMARY KEY,
    class_name VARCHAR(100) NOT NULL,
    max_capacity INT NOT NULL,
    employee_id INT REFERENCES staff(employee_id)
);

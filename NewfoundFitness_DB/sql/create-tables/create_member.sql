-- This script creates the member table
-- The table stores information about gym members, linking to person_info and membership

CREATE TABLE member (
    member_id SERIAL PRIMARY KEY,
    name_id INT REFERENCES person_info(name_id),
    membership_id INT REFERENCES membership(membership_id),
    date_joined DATE NOT NULL
);

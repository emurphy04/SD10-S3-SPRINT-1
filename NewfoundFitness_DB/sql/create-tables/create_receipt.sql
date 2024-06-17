-- This script creates the receipt table
-- The table stores information about receipts including payment method and total amount

CREATE TABLE receipt (
    receipt_id SERIAL PRIMARY KEY,
    member_id INT REFERENCES member(member_id),
    payment_method VARCHAR(50) NOT NULL CHECK (payment_method IN ('Credit Card', 'Debit Card', 'Cash')),
    tax_id INT REFERENCES tax(tax_id),
    subtotal NUMERIC(10, 2) NOT NULL,
    total_amount NUMERIC(10, 2) NOT NULL
);

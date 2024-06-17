-- This script inserts data into the receipt table

INSERT INTO receipt (member_id, payment_method, tax_id, subtotal, total_amount) VALUES
(1, 'Credit Card', 1, 100, 113), (2, 'Debit Card', 2, 200, 230);

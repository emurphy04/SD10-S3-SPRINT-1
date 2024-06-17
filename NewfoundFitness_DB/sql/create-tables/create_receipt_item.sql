-- This script creates the receipt_item table
-- The table stores information about items in receipts, linking to receipts and supplements

CREATE TABLE receipt_item (
    receipt_item_id SERIAL PRIMARY KEY,
    receipt_id INT REFERENCES receipt(receipt_id),
    supplement_id INT REFERENCES supplement(supplement_id),
    quantity INT NOT NULL,
    price_id INT REFERENCES price(price_id)
);

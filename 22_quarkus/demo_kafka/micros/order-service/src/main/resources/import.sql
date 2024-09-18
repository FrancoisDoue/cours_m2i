DELETE FROM Orders;
INSERT INTO Orders (id, client_id, product_id, quantity, order_status, orderDate) VALUES (1, 1, 1, 2, 'CONFIRMED','2024-08-15T10:00:00');
INSERT INTO Orders (id, client_id, product_id, quantity, order_status, orderDate) VALUES (2, 2, 2, 1, 'CONFIRMED','2024-08-16T10:00:00');

ALTER TABLE Orders ALTER COLUMN id RESTART WITH 3;
-- This file allow to write SQL commands that will be emitted in test and dev.
-- The commands are commented as their support depends of the database
-- insert into myentity (id, field) values(1, 'field-1');
-- insert into myentity (id, field) values(2, 'field-2');
-- insert into myentity (id, field) values(3, 'field-3');
-- alter sequence myentity_seq restart with 4;
INSERT INTO orders (client_id, product_id, quantity, orderDate) VALUES ( 1, 1, 2, '2024-08-15T10:00:00');
INSERT INTO orders (client_id, product_id, quantity, orderDate) VALUES ( 2, 2, 1, '2024-08-16T10:00:00');
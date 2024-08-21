-- This file allow to write SQL commands that will be emitted in test and dev.
-- The commands are commented as their support depends of the database
-- insert into myentity (id, field) values(1, 'field-1');
-- insert into myentity (id, field) values(2, 'field-2');
-- insert into myentity (id, field) values(3, 'field-3');
-- alter sequence myentity_seq restart with 4;

INSERT INTO client (name, email, phone)
VALUES ('Georges', 'georges@mail.fr', '0601020304'),
       ('Dylan', 'dylan@mail.fr', '0610203040'),
       ('Bob', 'dylan@mail.fr', '0612345678')
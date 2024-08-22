-- This file allow to write SQL commands that will be emitted in test and dev.
-- The commands are commented as their support depends of the database
-- insert into myentity (id, field) values(1, 'field-1');
-- insert into myentity (id, field) values(2, 'field-2');
-- insert into myentity (id, field) values(3, 'field-3');
-- alter sequence myentity_seq restart with 4;

INSERT INTO book (title, quantity, isbn, author_id)
VALUES ('Les misérables', 2, 'guylmyif', 1),
       ('Notre-Dame', 3, 'azertyuio', 1),
       ('1984', 1, 'qsdfghjk', 2);
-- This file allow to write SQL commands that will be emitted in test and dev.
-- The commands are commented as their support depends of the database
-- insert into myentity (id, field) values(1, 'field-1');
-- insert into myentity (id, field) values(2, 'field-2');
-- insert into myentity (id, field) values(3, 'field-3');
-- alter sequence myentity_seq restart with 4;

INSERT INTO Person (firstname, lastname, age) VALUES ('Dupont', 'Jean', 30);
INSERT INTO Person (firstname, lastname, age) VALUES ('Martin', 'Marie', 25);
INSERT INTO Person (firstname, lastname, age) VALUES ('Durand', 'Paul', 40);
INSERT INTO Person (firstname, lastname, age) VALUES ('Lefevre', 'Alice', 22);
INSERT INTO Person (firstname, lastname, age) VALUES ('Bernard', 'Pierre', 35);
INSERT INTO Person (firstname, lastname, age) VALUES ('Dubois', 'Sophie', 28);
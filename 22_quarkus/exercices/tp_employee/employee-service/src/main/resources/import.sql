DELETE FROM Employee;

INSERT INTO Employee (name, position, department_id, organization_id)
VALUES ( 'Georges Abitbol', 'Cowboy', 2, 1 ),
       ('Employee 2', 'RH', 2,1),
       ('Employee 3', 'Dev', 3,2),
       ('Employee 4', 'Accountant', 4,2),
       ('Employee 5', 'Scientist', 5,3),
       ('Employee 6', 'Scientist', 5,3),
       ('Employee 7', 'Engineer', 5,3),
       ('Employee 8', 'Data scientist', 6,3),
       ('Employee 9', 'Engineer', 1,1),
       ('employee 10', 'dev', null, null);

ALTER TABLE Employee ALTER COLUMN id START WITH 11;


DELETE FROM Department;

INSERT INTO Department (id, name, organization_id)
VALUES ( 1, 'R&D', 1),
       (2, 'RH', 1),
       (3, 'Web Devlopment', 2),
       (4, 'Accounting', 2),
       (5, 'R&D', 3),
       (6, 'Data science', 3);

ALTER TABLE Department ALTER COLUMN id START WITH 7;
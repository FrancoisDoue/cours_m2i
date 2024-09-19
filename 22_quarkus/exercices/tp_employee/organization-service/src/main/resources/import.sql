DELETE FROM Organization;

INSERT INTO Organization (id, name, address, employeeNumber, lastEmployeeUpdate) VALUES (1, 'Enterprise 1', '4 av. de l\'Horizon', 2, '2024-09-18');
INSERT INTO Organization (id, name, address, employeeNumber, lastEmployeeUpdate) VALUES (2, 'Enterprise 2', '8 rue Jules Michelet', 3, '2024-09-18');
INSERT INTO Organization (id, name, address, employeeNumber, lastEmployeeUpdate) VALUES (3, 'Enterprise 3', '1 Pl. Charles de Gaulle', 1, '2024-09-18');

ALTER TABLE Organization ALTER COLUMN id START WITH 4;
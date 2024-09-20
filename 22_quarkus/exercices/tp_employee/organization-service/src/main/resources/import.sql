DELETE FROM Organization;

INSERT INTO Organization (id, name, address, last_employee_update) VALUES (1, 'Enterprise 1', '4 av. de lHorizon', '2024-09-18');
INSERT INTO Organization (id, name, address, last_employee_update) VALUES (2, 'Enterprise 2', '8 rue Jules Michelet', '2024-09-18');
INSERT INTO Organization (id, name, address, last_employee_update) VALUES (3, 'Enterprise 3', '1 Pl. Charles de Gaulle', '2024-09-18');

ALTER TABLE Organization ALTER COLUMN id START WITH 4;
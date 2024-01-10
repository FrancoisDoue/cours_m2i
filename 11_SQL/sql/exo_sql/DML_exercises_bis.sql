USE dml_test;

INSERT INTO students (first_name, last_name, age, grade)
VALUES 
	('Maria', 'Rodriguez', 21, 'B'),
    ('Ahmed', 'Khan', 19, 'A'),
    ('Emily', 'Baker', 22, 'C');
    
SET SQL_SAFE_UPDATES = 0;

UPDATE students
SET grade = 'A'
WHERE first_name = 'Maria';

UPDATE students
SET age = age+1;

DELETE FROM students
WHERE first_name = 'Emily';

DELETE FROM students
WHERE age < 20;

TRUNCATE TABLE students;

SET SQL_SAFE_UPDATES = 1;

SELECT * FROM students;
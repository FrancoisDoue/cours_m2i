USE test_bdd;
SHOW tables;
SELECT * 
FROM users;
-- select * from users where id = 8;
-- select first_name, last_name, job, age, salary from users where age <= 30 and salary > 2500;
-- SHOW databases;
SELECT * 
	FROM users;
SELECT first_name, last_name, job 
	FROM users;
SELECT * 
	FROM users
    WHERE job != 'Developer';
SELECT *
	FROM users
    WHERE first_name = 'John';
SELECT *
	FROM users
    WHERE salary >= 3000;
    
SELECT *
FROM users
WHERE age < 30 OR age >= 35;

SELECT *
FROM users
WHERE job = 'Teacher' AND salary > 2600;

SELECT first_name, last_name, job, birth_location, salary
FROM users
WHERE 
	NOT (job = 'Lawyer' OR job = 'Doctor') 
	AND birth_location = 'New York' 
    AND salary BETWEEN 2999 AND 3501;

SELECT DISTINCT job FROM users;

SELECT *
FROM users
WHERE job = 'Engineer';

SELECT first_name, last_name
FROM users
WHERE birth_location IN('London', 'Paris', 'Berlin');

SELECT *
FROM users
WHERE age BETWEEN 25 AND 35;

SELECT *
FROM users
WHERE job = 'Developer' AND salary > 2500;

SELECT *
FROM users
ORDER BY age DESC
LIMIT 5;

SELECT *
FROM users
ORDER BY first_name
LIMIT 5, 5; -- LIMIT 5 OFFSET 5

SELECT * 
FROM users
ORDER BY salary DESC
LIMIT 3;

SELECT MIN(age)
FROM users;

SELECT *
FROM users
WHERE age = (SELECT MIN(age) FROM users);

select * from users order by age limit 1;





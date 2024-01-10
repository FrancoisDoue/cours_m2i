USE test_bdd;

SELECT MIN(salary) AS min_salary
FROM users;

SELECT MAX(age) AS oldest_engineer
FROM users
WHERE job = 'Engineer';

SELECT ROUND(AVG(salary), 2) AS avg_salary
FROM users
WHERE job = 'Teacher';

SELECT birth_location, ROUND(AVG(salary), 2) AS avg_salary
FROM users
GROUP BY birth_location
HAVING avg_salary >= 2800
ORDER BY avg_salary DESC;

SELECT SUM(salary) AS total_salary
FROM users;

SELECT * FROM users
WHERE first_name LIKE 'D%';

SELECT * FROM users
WHERE last_name LIKE '%son';

SELECT * FROM users
WHERE first_name LIKE '_____';

SELECT * FROM users
WHERE job LIKE '%Doctor%';

SELECT COUNT(*) AS cnt_users, birth_location 
FROM users
GROUP BY birth_location
HAVING cnt_users > 1;

SELECT job, ROUND(AVG(salary), 2) AS avg_salary
FROM users
GROUP BY job
HAVING avg_salary > 2500;

SELECT birth_location, SUM(salary) AS total_salary
FROM users
WHERE birth_location NOT LIKE 'B%'
GROUP BY birth_location
HAVING total_salary > 5000;

SELECT birth_date, COUNT(*) AS cnt_users
FROM users
GROUP BY birth_date
HAVING cnt_users > 1;

SELECT job, birth_location, MAX(salary) AS max_salary
FROM users
GROUP BY job, birth_location
HAVING max_salary > 3000;
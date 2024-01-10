USE test_bdd;

SELECT * FROM users; -- ORDER BY age;

-- exo 1 - v1
SELECT * FROM users
WHERE birth_location = (
	SELECT birth_location 
    FROM users 
    WHERE age = (
		SELECT MIN(age) FROM users -- lol
    )
);
-- exo 1 - v2
SELECT * FROM users
WHERE birth_location = (
	SELECT birth_location FROM users ORDER BY age LIMIT 1
);
-- exo 2
SELECT * FROM users
WHERE salary < (
	SELECT AVG(salary) 
    FROM users 
    WHERE job = 'Developer'
);
-- exo 3
SELECT * FROM users
WHERE salary > (
	SELECT AVG(salary) FROM users
    WHERE birth_location = (
		SELECT birth_location FROM users WHERE first_name = 'John' AND last_name = 'Doe'
    )
);
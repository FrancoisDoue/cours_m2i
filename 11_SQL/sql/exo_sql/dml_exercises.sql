DROP DATABASE IF EXISTS dml_test;
CREATE DATABASE IF NOT EXISTS dml_test;
USE dml_test;

-- CREATE TABLE IF NOT EXISTS students (
--     student_id INT AUTO_INCREMENT PRIMARY KEY,
--     first_name VARCHAR(50) NOT NULL,
--     last_name VARCHAR(50) NOT NULL,
--     age INT,
--     grade VARCHAR(10)
-- );

CREATE TABLE clients(
	id INT AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(50) NOT NULL,
    prenom VARCHAR(50) NOT NULL,
    ville VARCHAR(100)
);

CREATE TABLE achats(
	id INT AUTO_INCREMENT PRIMARY KEY,
	client_id INT DEFAULT NULL,
    produit VARCHAR(100) NOT NULL,
    montant DECIMAL(8,2) NOT NULL,
    FOREIGN KEY (client_id) REFERENCES clients(id)
);
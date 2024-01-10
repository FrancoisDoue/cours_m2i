USE test_bdd;

DROP TABLE IF EXISTS adresse;
DROP TABLE IF EXISTS personne;
DROP TABLE IF EXISTS compte;

CREATE TABLE compte(
	compte_id INT AUTO_INCREMENT PRIMARY KEY,
    pseudo VARCHAR(50) NOT NULL,
    psw VARCHAR(60) NOT NULL,
    email VARCHAR(150) NOT NULL,
    date_creation DATE NOT NULL DEFAULT CURRENT_TIMESTAMP(),
    derniere_connection DATE
);

CREATE TABLE personne(
	personne_id INT AUTO_INCREMENT PRIMARY KEY,
    titre VARCHAR(5) NOT NULL,
    prenom VARCHAR(50) NOT NULL,
    nom VARCHAR(50) NOT NULL,
    telephone VARCHAR(12),
    email VARCHAR(150)
);

CREATE TABLE adresse(
	adresse_id INT AUTO_INCREMENT PRIMARY KEY,
    personne_id INT,
    rue VARCHAR(100),
    code_postal VARCHAR(6),
    ville VARCHAR(100),
    FOREIGN KEY (personne_id) REFERENCES personne(personne_id)
);

SHOW TABLES;
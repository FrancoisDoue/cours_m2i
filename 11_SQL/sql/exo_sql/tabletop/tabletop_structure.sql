-- ETAPE 1

-- DROP DATABASE IF EXISTS tabletoptreasures_database;
CREATE DATABASE IF NOT EXISTS tabletoptreasures_database;

USE tabletoptreasures_database;

CREATE TABLE clients (
	id 						INT AUTO_INCREMENT PRIMARY KEY,
    nom 					VARCHAR(50) NOT NULL,
    prenom 					VARCHAR(50) NOT NULL,
    adresse_mail			VARCHAR(100) NOT NULL UNIQUE,
    adresse_de_livraison	VARCHAR(255),
    telephone				VARCHAR(11)
);

CREATE TABLE categorie (
	id 			INT AUTO_INCREMENT PRIMARY KEY,
    nom 		VARCHAR(100) NOT NULL
);

CREATE TABLE jeux (
	id 				INT AUTO_INCREMENT PRIMARY KEY,
    nom 			VARCHAR(255) NOT NULL,
    description 	LONGTEXT,
    prix 			DECIMAL(4,2) NOT NULL,
    id_categorie 	INT NOT NULL,
    FOREIGN KEY (id_categorie) REFERENCES categorie(id)
);

CREATE TABLE commande (
	id 						INT AUTO_INCREMENT PRIMARY KEY,
    id_client 				INT NOT NULL,
	date_commande 			TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    adresse_de_livraison	VARCHAR(255) NOT NULL,
    statut 					BOOLEAN NOT NULL DEFAULT FALSE
);

CREATE TABLE commande_jeux (
	id_commande 	INT NOT NULL,
    id_jeux 		INT NOT NULL,
    FOREIGN KEY (id_commande) REFERENCES commande(id),
    FOREIGN KEY (id_jeux) REFERENCES jeux(id)
);

-- ETAPE 2 - part 1

INSERT INTO clients(nom, prenom, adresse_mail, adresse_de_livraison, telephone)
VALUE
	('Dubois', 'Marie', 'marie.dubois@example.com', '123 Rue de la Libération, Ville', '+1234567890'),
	('Lefebvre', 'Thomas', 'thomas.lefebvre@example.com', '456 Avenue des Roses, Ville', '+9876543210'),
	('Martinez', 'Léa', 'lea.martinez@example.com', '789 Boulevard de la Paix, Ville', '+2345678901'),
	('Dupuis', 'Antoine', 'antoine.dupuis@example.com', '567 Avenue de la Liberté, Ville', '+3456789012'),
	('Morin', 'Camille', 'camille.morin@example.com', '890 Rue de l''Avenir, Ville', '+4567890123'),
	('Girard', 'Lucas', 'lucas.girard@example.com', '234 Avenue des Champs, Ville', '+5678901234'),
	('Petit', 'Emma', 'emma.petit@example.com', '123 Rue des Étoiles, Ville', '+6789012345'),
	('Sanchez', 'Gabriel', 'gabriel.sanchez@example.com', '345 Boulevard du Bonheur, Ville', '+7890123456'),
	('Rossi', 'Clara', 'clara.rossi@example.com', '678 Avenue de la Joie, Ville', '+8901234567'),
	('Lemoine', 'Hugo', 'hugo.lemoine@example.com', '456 Rue de la Nature, Ville', '+9012345678'),
	('Moreau', 'Eva', 'eva.moreau@example.com', '789 Avenue de la Créativité, Ville', '+1234567890'),
	('Fournier', 'Noah', 'noah.fournier@example.com', '234 Rue de la Découverte, Ville', '+2345678901'),
	('Leroy', 'Léa', 'lea.leroy@example.com', '567 Avenue de l''Imagination, Ville', '+3456789012'),
	('Robin', 'Lucas', 'lucas.robin@example.com', '890 Rue de la Création, Ville', '+4567890123'),
	('Marchand', 'Anna', 'anna.marchand@example.com', '123 Boulevard de l''Innovation, Ville', '+5678901234');

INSERT INTO categorie (nom)
VALUE
	('Stratégie'),
	('Familial'),
	('Aventure');
    
INSERT INTO jeux (nom, description, prix, id_categorie)
VALUE
	('Catan', 'Jeu de stratégie et de développement de colonies', 30, 1),
	('Dixit', 'Jeu d''association d''images', 25, 2),
	('Les Aventuriers', 'Jeu de plateau d''aventure', 40, 3),
	('Carcassonne', 'Jeu de placement de tuiles', 28, 1),
	('Codenames', 'Jeu de mots et d''indices', 20, 2),
	('Pandemic', 'Jeu de coopération pour sauver le monde', 35, 3),
	('7 Wonders', 'Jeu de cartes et de civilisations', 29, 1),
	('Splendor', 'Jeu de développement économique', 27, 2),
	('Horreur à Arkham', 'Jeu d''enquête et d''horreur', 45, 3),
	('Risk', 'Jeu de conquête mondiale', 22, 1),
	('Citadelles', 'Jeu de rôles et de bluff', 23, 2),
	('Terraforming Mars', 'Jeu de stratégie de colonisation de Mars', 55, 3),
	('Small World', 'Jeu de civilisations fantastiques', 32, 1),
	('7 Wonders Duel', 'Jeu de cartes pour 2 joueurs', 26, 2),
	('Horreur à l''Outreterre', 'Jeu d''aventure horrifique', 38, 3);


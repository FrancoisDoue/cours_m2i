-- ETAPE 2 - part 2

USE tabletoptreasures_database;

SELECT * FROM clients;
SELECT * FROM commande;
SELECT * FROM jeux;

INSERT INTO commande (id_client, adresse_de_livraison)
VALUE
	(1, (SELECT adresse_de_livraison FROM clients WHERE id = 1)),
    (4, (SELECT adresse_de_livraison FROM clients WHERE id = 4)),
    (7, (SELECT adresse_de_livraison FROM clients WHERE id = 7));

UPDATE jeux
SET prix = 35
WHERE id = 3;

DELETE FROM jeux
WHERE id = 2;

-- ETAPE 3
SELECT DISTINCT nom 
FROM categorie;

SELECT * FROM categorie
WHERE nom LIKE('A%') OR nom LIKE ('S%');

SELECT * FROM categorie
WHERE id BETWEEN 2 AND 5;

SELECT max(nom) AS longest_name 
FROM categorie;

SELECT DISTINCT COUNT(nom) AS cnt_cat 
FROM categorie;

SELECT * FROM categorie
ORDER BY nom DESC;

SELECT DISTINCT nom 
FROM jeux;

SELECT * FROM jeux
WHERE prix BETWEEN 25 AND 40;

SELECT * FROM jeux
WHERE id_categorie = 3;

SELECT COUNT(*) FROM jeux
WHERE description LIKE '%aventure%';

SELECT * FROM jeux
ORDER BY prix
LIMIT 1;

SELECT SUM(prix) AS total_prix 
FROM jeux;

SELECT * FROM jeux
ORDER BY nom
LIMIT 5;





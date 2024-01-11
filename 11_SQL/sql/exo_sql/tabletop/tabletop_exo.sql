-- ETAPE 2 - part 2
-- USE tabletoptreasures_database;

-- 2. Effectuez trois commandes en insérant une nouvelle entrée dans la table "Commandes".
-- Assurez-vous d'inclure l'ID du client (créé précédemment), la date de commande, l'adresse de livraison et le statut de la commande
-- INSERT INTO commande (id_client, adresse_de_livraison)
-- VALUE
-- 		(1, (SELECT adresse_de_livraison FROM clients WHERE id = 1)),
--  	(4, (SELECT adresse_de_livraison FROM clients WHERE id = 4)),
-- 		(7, (SELECT adresse_de_livraison FROM clients WHERE id = 7)),
-- 		(1, (SELECT adresse_de_livraison FROM clients WHERE id = 1));
    
-- 3.  Mettez à jour le prix du jeu avec l'ID 3 (Les Aventuriers) pour le fixer à 35 €
UPDATE jeux
SET prix = 35
WHERE id = 3;

-- 4.  Supprimez le jeu avec l'ID 2 (Dixit) de la table "Jeux"
DELETE FROM jeux
WHERE id = 2;

-- ETAPE 3
-- table categorie

-- 1.  Sélectionnez tous les noms de catégories distinctes
SELECT DISTINCT nom 
FROM categorie;

-- 2.  Montrez les catégories avec des noms commençant par "A" ou "S".
SELECT * FROM categorie
WHERE nom LIKE('A%') OR nom LIKE ('S%');

-- 3.  Quelles catégories ont un ID entre 2 et 5 inclus ?
SELECT * FROM categorie
WHERE id BETWEEN 2 AND 5;

-- 4.  Combien de catégories différentes existent ?
SELECT COUNT(DISTINCT nom) FROM categorie;

-- 5.  Quelle est la catégorie ayant le nom le plus long ?
SELECT * FROM categorie
ORDER BY length(nom)
LIMIT 1;

-- 6.  Montrez le nombre de jeux dans chaque catégorie.
SELECT categorie.*, COUNT(jeux.id) AS nbr_jeux
FROM categorie
LEFT JOIN jeux ON jeux.id_categorie = categorie.id
GROUP BY categorie.id;

-- 7.  Affichez les catégories triées par ordre alphabétique inversé.
SELECT * FROM categorie
ORDER BY nom DESC;

-- table jeux

-- 1.  Sélectionnez tous les noms de jeux distincts.
SELECT DISTINCT nom 
FROM jeux;

-- 2.  Montrez les jeux avec un prix entre 25 et 40.
SELECT * FROM jeux
WHERE prix BETWEEN 25 AND 40;

-- 3.  Quels jeux appartiennent à la catégorie avec l'ID 3 ?
SELECT * FROM jeux
WHERE id_categorie = 3;

-- 4.  Combien de jeux ont une description contenant le mot "aventure" ?
SELECT COUNT(*) AS nbr_jeux FROM jeux
WHERE description LIKE '%aventure%';

-- 5.  Quel est le jeu le moins cher ?
SELECT * FROM jeux
ORDER BY prix
LIMIT 1;

-- 6.  Montrez la somme totale des prix de tous les jeux.
SELECT SUM(prix) AS total_prix 
FROM jeux;

-- 7.  Affichez les jeux triés par ordre alphabétique des noms en limitant les résultats à 5
SELECT * FROM jeux
ORDER BY nom
LIMIT 5;

-- table clients

-- 1.  Sélectionnez tous les prénoms des clients distincts.
SELECT DISTINCT prenom 
FROM clients;

-- 2.  Montrez les clients dont l'adresse contient "Rue" et dont le numéro de téléphone commence par "+1".
SELECT * FROM clients
WHERE adresse_de_livraison LIKE '%Rue%'
	AND telephone LIKE '+1%';

-- 3.  Quels clients ont un nom commençant par "M" ou "R" ?
SELECT * FROM clients
WHERE nom LIKE 'R%' OR nom LIKE 'M%';

-- 4.  Combien de clients ont une adresse e-mail valide (contenant "@") ?
SELECT COUNT(*) FROM clients
WHERE adresse_mail LIKE '%@%';

-- 5.  Quel est le prénom le plus court parmi les clients ?
SELECT prenom FROM clients
ORDER BY length(prenom)
LIMIT 1;

-- 6.  Montrez le nombre total de clients enregistrés.
SELECT COUNT(*) AS total_clients
FROM clients;

-- 7.  Affichez les clients triés par ordre alphabétique des noms de famille, mais en excluant les premiers 3
SELECT * FROM clients
ORDER BY nom
LIMIT 3, 999;

# ------------------------------------------------- #
-- INSERT INTO commande_jeux(id_commande, id_jeux)
-- VALUE (1, 3), (1, 9), (2, 10), (3, 1), (3, 6), (3, 3);
-- INSERT INTO commande_jeux(id_commande, id_jeux)
-- VALUE (4, 4), (4, 2);
# ------------------------------------------------- #

-- 1.  Sélectionnez les noms des clients, noms de jeux et date de commande pour 
-- chaque commande passée.
SELECT clients.nom, clients.prenom, jeux.nom, c.date_commande
FROM commande AS c
INNER JOIN commande_jeux AS cj 	ON cj.id_commande = c.id
INNER JOIN jeux 				ON jeux.id = cj.id_jeux
INNER JOIN clients 				ON clients.id = c.id;

-- 2.  Sélectionnez les noms des clients et le montant total dépensé par chaque client. 
-- Triez les résultats par montant total décroissant.
SELECT cl.nom, cl.prenom, SUM(jeux.prix) AS total_achats
FROM clients AS cl
LEFT JOIN commande 		ON commande.id_client = cl.id
LEFT JOIN commande_jeux ON commande_jeux.id_commande = commande.id
LEFT JOIN jeux 			ON jeux.id = commande_jeux.id_jeux
GROUP BY cl.nom, cl.prenom
ORDER BY total_achats DESC;

-- 3.  Sélectionnez les noms des jeux, noms de catégories et prix de chaque jeu.
SELECT jeux.nom, cat.nom, jeux.prix
FROM jeux
RIGHT JOIN categorie AS cat ON cat.id = jeux.id_categorie;

-- 4.  Sélectionnez les noms des clients, date de commande et noms de jeux pour 
-- toutes les commandes passées.
SELECT cm.id AS ref_commande, c.nom, cm.date_commande, jeux.nom
FROM commande AS cm
LEFT JOIN clients AS c 		ON c.id = cm.id_client
LEFT JOIN commande_jeux 	ON commande_jeux.id_commande = cm.id
LEFT JOIN jeux 				ON jeux.id = commande_jeux.id_jeux;
-- cm.id pour avoir la référence de la commande, ça me semble plus logique

-- 5.  Sélectionnez les noms des clients, nombre total de commandes par client et 
-- montant total dépensé par client. Incluez uniquement les clients ayant effectué 
-- au moins une commande.
SELECT cl.nom, (
	SELECT COUNT(*) FROM commande WHERE commande.id_client = cl.id
) AS nbr_commandes, SUM(jeux.prix) AS somme_depensee
FROM clients AS cl
INNER JOIN commande 		ON commande.id_client = cl.id
INNER JOIN commande_jeux 	ON commande_jeux.id_commande = commande.id
INNER JOIN jeux 			ON jeux.id = commande_jeux.id_jeux
GROUP BY cl.id;

SELECT cl.nom, COUNT(DISTINCT commande.id) AS nbr_commandes, SUM(jeux.prix) AS somme_depensee
FROM clients AS cl
INNER JOIN commande 		ON commande.id_client = cl.id
INNER JOIN commande_jeux 	ON commande_jeux.id_commande = commande.id
INNER JOIN jeux 			ON jeux.id = commande_jeux.id_jeux
GROUP BY cl.id;


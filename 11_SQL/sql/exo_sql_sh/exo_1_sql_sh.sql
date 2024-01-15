USE exo_2_sql_sh;
SET SQL_SAFE_UPDATES = 0;

--  1   Obtenir l’utilisateur ayant le prénom “Muriel” et le mot de passe “test11”, sachant que l’encodage du mot de passe est effectué avec l’algorithme Sha1.
SELECT * FROM client
WHERE prenom = 'Muriel' AND password = sha1('test11');

--  2   Obtenir la liste de tous les produits qui sont présent sur plusieurs commandes.
SELECT * FROM commande_ligne
GROUP BY nom 
HAVING COUNT(DISTINCT commande_id) > 1;

--  3   Obtenir la liste de tous les produits qui sont présent sur plusieurs commandes et y ajouter une colonne qui liste les identifiants des commandes associées.
SELECT cl.*, GROUP_CONCAT(' ', cm.id) AS id_commandes
FROM commande_ligne AS cl
INNER JOIN commande AS cm 	ON cm.id = cl.commande_id
GROUP BY cl.nom 
HAVING COUNT(DISTINCT cl.commande_id) > 1
ORDER BY cm.id; -- optionnel, c'est pour m'y retrouver

--  4   Enregistrer le prix total à l’intérieur de chaque ligne des commandes, en fonction du prix unitaire et de la quantité
UPDATE commande_ligne
SET prix_total = prix_unitaire * quantite;

--  5   Obtenir le montant total pour chaque commande et y voir facilement la date associée à cette commande ainsi que le prénom et nom du client associé
SELECT c.nom, c.prenom, cm.date_achat, cl.prix_total FROM commande AS cm
INNER JOIN commande_ligne AS cl ON cl.commande_id = cm.id
INNER JOIN client AS c ON c.id = cm.client_id
GROUP BY cm.id;

--  6   (difficulté très haute) Enregistrer le montant total de chaque commande dans le champ intitulé “cache_prix_total”
UPDATE commande
SET cache_prix_total = (
	SELECT SUM(prix_total) 
	FROM commande_ligne
	WHERE commande.id = commande_id
);
-- SELECT * FROM commande;

--  7   Obtenir le montant global de toutes les commandes, pour chaque mois
SELECT MONTH(date_achat) AS mois, ROUND(SUM(cache_prix_total)) AS total_arr
FROM commande
GROUP BY mois;

--  8   Obtenir la liste des 10 clients qui ont effectué le plus grand montant de commandes, et obtenir ce montant total pour chaque client.
SELECT c.*, ROUND(SUM(cm.cache_prix_total)) as total_achat_arr
FROM client AS c
INNER JOIN commande AS cm ON cm.client_id = c.id
GROUP BY c.id
ORDER BY total_achat_arr DESC
LIMIT 10;

--  9   Obtenir le montant total des commandes pour chaque date
SELECT date_achat, round(SUM(cache_prix_total)) AS nbr_commandes
FROM commande
GROUP BY date_achat;

-- 10   Ajouter une colonne intitulée “category” à la table contenant les commandes. Cette colonne contiendra une valeur numérique
ALTER TABLE commande
ADD COLUMN category INT;

-- 11   Enregistrer la valeur de la catégorie, en suivant les règles suivantes :
--         “1” pour les commandes de moins de 200€
--         “2” pour les commandes entre 200€ et 500€
--         “3” pour les commandes entre 500€ et 1.000€
--         “4” pour les commandes supérieures à 1.000€
UPDATE commande AS c
SET category = (
	CASE
		WHEN cache_prix_total < 200 THEN 1
		WHEN cache_prix_total < 500 THEN 2
		WHEN cache_prix_total < 1000 THEN 3
		ELSE 4
	END
);


-- 13   Créer une table intitulée “commande_category” qui contiendra le descriptif de ces catégories
DROP TABLE IF EXISTS commande_category;
CREATE TABLE IF NOT EXISTS commande_category (
	id INT AUTO_INCREMENT PRIMARY KEY,
    descriptif VARCHAR(255)
);

-- 14   Insérer les 4 descriptifs de chaque catégorie au sein de la table précédemment créée
INSERT INTO commande_category (descriptif)
VALUE ('pas d\'argent'),
	('A de l\'argent'),
    ('Est riche'),
    ('Est peut-être Jeff Bezos');
    
SELECT * FROM commande
INNER JOIN commande_category ON commande_category.id = commande.category;

-- 15   Supprimer toutes les commandes (et les lignes des commandes) inférieur au 1er février 2019. Cela doit être effectué en 2 requêtes maximum
START TRANSACTION;
DELETE FROM commande_ligne
WHERE commande_ligne.commande_id IN ((SELECT id FROM commande WHERE date_achat < DATE('2019-02-01')));
DELETE FROM commande
WHERE date_achat < DATE('2019-02-01');
COMMIT;

DELETE CM, CL
FROM `commande` CM
INNER JOIN `commande_ligne` CL ON CM.id = CL.commande_id
WHERE CM.date_achat < DATE('2019-02-01');

SELECT * FROM commande_ligne;

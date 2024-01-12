SET SQL_SAFE_UPDATES = 0;

--  1   Obtenir l’utilisateur ayant le prénom “Muriel” et le mot de passe “test11”, sachant que l’encodage du mot de passe est effectué avec l’algorithme Sha1.
SELECT * FROM client
WHERE prenom = 'Muriel' AND password = sha1('test11');

--  2   Obtenir la liste de tous les produits qui sont présent sur plusieurs commandes.
SELECT * FROM commande_ligne
GROUP BY nom 
HAVING COUNT(DISTINCT commande_id) > 1;

--  3   Obtenir la liste de tous les produits qui sont présent sur plusieurs commandes et y ajouter une colonne qui liste les identifiants des commandes associées.
SELECT cl.*, cm.* 
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

--  7   Obtenir le montant global de toutes les commandes, pour chaque mois

--  8   Obtenir la liste des 10 clients qui ont effectué le plus grand montant de commandes, et obtenir ce montant total pour chaque client.

--  9   Obtenir le montant total des commandes pour chaque date

-- 10   Ajouter une colonne intitulée “category” à la table contenant les commandes. Cette colonne contiendra une valeur numérique

-- 11   Enregistrer la valeur de la catégorie, en suivant les règles suivantes :
--         “1” pour les commandes de moins de 200€
--         “2” pour les commandes entre 200€ et 500€
--         “3” pour les commandes entre 500€ et 1.000€
--         “4” pour les commandes supérieures à 1.000€

-- 13   Créer une table intitulée “commande_category” qui contiendra le descriptif de ces catégories

-- 14   Insérer les 4 descriptifs de chaque catégorie au sein de la table précédemment créée

-- 15   Supprimer toutes les commandes (et les lignes des commandes) inférieur au 1er février 2019. Cela doit être effectué en 2 requêtes maximum

USE exo_sql_sh;

-- 1 - Obtenir la liste des 10 villes les plus peuplées en 2012
SELECT * FROM villes_france_free
ORDER BY ville_population_2012 DESC
LIMIT 10;

-- 2 - Obtenir la liste des 50 villes ayant la plus faible superficie
SELECT * FROM villes_france_free
ORDER BY ville_surface
LIMIT 50;

-- 3 - Obtenir la liste des départements d’outres-mer, c’est-à-dire ceux dont le numéro de département commencent par “97”
SELECT * FROM departement
WHERE departement_code LIKE '97%';

-- 4 -  Obtenir le nom des 10 villes les plus peuplées en 2012, ainsi que le nom du département associé
SELECT ville_nom_reel, (
	SELECT departement_nom FROM departement WHERE departement_code = ville_departement
) AS departement 
FROM villes_france_free
ORDER BY ville_population_2012 DESC
LIMIT 10;

-- 5 - Obtenir la liste du nom de chaque département, associé à son code et du nombre de commune au sein de ces département, en triant afin d’obtenir en priorité les départements qui possèdent le plus de communes
SELECT departement_nom, departement_code, (
	SELECT COUNT(ville_id) FROM villes_france_free 
    WHERE ville_departement = departement_code
) as nbr_villes
FROM departement
ORDER BY nbr_villes DESC;

-- 6 - Obtenir la liste des 10 plus grands départements, en terme de superficie
SELECT * FROM departement
ORDER BY (
	SELECT SUM(ville_surface) FROM villes_france_free
    WHERE ville_departement = departement_code
) DESC
LIMIT 10;

-- 7 - Compter le nombre de villes dont le nom commence par “Saint”
SELECT COUNT(*) AS nbr_ville
FROM villes_france_free
WHERE ville_nom_reel LIKE 'Saint%';

-- 8 - Obtenir la liste des villes qui ont un nom existants plusieurs fois, et trier afin d’obtenir en premier celles dont le nom est le plus souvent utilisé par plusieurs communes
-- v1
SELECT ville_nom_reel, COUNT(ville_nom_reel) AS cnt_ville 
FROM villes_france_free
GROUP BY ville_nom_reel HAVING count(*) > 1
ORDER BY cnt_ville DESC;

-- 9 - Obtenir en une seule requête SQL la liste des villes dont la superficie est supérieur à la superficie moyenne
SELECT * FROM villes_france_free
WHERE ville_surface > (
	SELECT AVG(ville_surface) FROM villes_france_free
);

-- 10 - Obtenir la liste des départements qui possèdent plus de 2 millions d’habitants
SELECT d.*, SUM(DISTINCT v.ville_population_2012) AS population
FROM villes_france_free AS v
INNER JOIN departement AS d ON v.ville_departement = d.departement_code
GROUP BY d.departement_code
HAVING population > 2000000;

-- 11 - Remplacez les tirets par un espace vide, pour toutes les villes commençant par “SAINT-” (dans la colonne qui contient les noms en majuscule)
SELECT REPLACE(ville_nom_reel, '-', ' ') AS villes_nom_saint_avec_espace FROM villes_france_free
WHERE ville_nom_reel LIKE 'Saint%';

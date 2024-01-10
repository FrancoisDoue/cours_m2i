USE dml_test;

INSERT INTO clients (nom, prenom, ville)
VALUE
	('Abidbol', 'Georges', 'L\'Atole de Pom-pom Gali'),
    ('Attal', 'Gabriel', 'Paris'),
    ('Méluche', 'Jean-luc', 'Marseille'),
    ('Delafosse', 'Florian', 'Kekpart'),
    ('Alexandre', 'Messuve', 'Lens');

INSERT INTO achats (client_id, produit, montant)
VALUE
	(1, 'Colt', '200'),
    (3, 'Projecteur holographique', 35000),
    (1, 'Serviettes imprimées', 25),
    (2, 'De l\'expérience', 10000),
    (1, 'Cheval', '25000'),
    (1, 'Un bateau.', '350000'),
    (2, 'Matignon', 1),
    (3, 'La république', 1),
    (4, 'Serviettes imprimées', 25),
    (4, 'Des manches de pull', 10),
    (NULL, 'Un produit pas acheté', 30000);
    
SELECT * FROM clients;
SELECT * FROM achats;

SELECT c.nom, c.prenom, a.produit, a.montant
FROM clients AS c
INNER JOIN achats AS a ON a.client_id = c.id;

SELECT c.nom, c.prenom, a.produit, a.montant
FROM clients AS c
LEFT JOIN achats AS a ON c.id = a.client_id;

SELECT a.*, c.*
FROM achats AS a
RIGHT JOIN clients AS c ON a.client_id = c.id
ORDER BY a.id;

SELECT * FROM clients AS c
LEFT JOIN achats AS a ON c.id = a.client_id
UNION
SELECT * FROM clients AS c
RIGHT JOIN achats AS a ON  c.id = a.client_id 
WHERE a.id = NULL;



# Le NoSQL

Le terme NoSql (Not only sql) fait référence à une classe de sgbd qui diffèrent des bdd relationnelles traditionnelles.
Les BDD NoSQL sont conçues pour répondre à des besoins spécifiques, tels que la gestion de grandes quantités de données non structurées ou semi-structurées, la mise à l'échelle horizontale facile, la flexibilité de schéma, et une meilleure performance dans certains scénarios.

Les caractéristiques générales des bdd noSql incluent donc:
- **Schéma flexibles :**  
Permet de stocker des données sans avoir à définir un schéma fixe à l'avance. Cela offre une flexibilité accrue pour traiter particulièrement les données évolutives ou diverses.
- **Evolutivité horizontale:**  
Elles sont conçues pour évoluer facilement en ajoutant de nouveaux servers au lieu d'augmenter les ressources d'un server existant. Cela facilite par la gestion de volumes de données massives.
- **Gestion de données non structurées ou semi-structurées :**  
Les BDD noSql peuvent générer des types de données variés, tels que les document, des pairs clé-valeur, des graphiques ou des colonnes offrant une flexibilité accrue par rapport au BDDR qui sont bassées sur un modèle tabulaire.
- **Hautes performances dans des cas spécifiques :**  
Les BDDNR peuvent offrir des perfomances supérieures à celles des bddr, en particulier lorsqu'il s'agit de lectures et d'écritures parallèles.

## SQL ou NoSQL ?

Voici quelques critères à considérer lors du choix entre SQL et NoSQL :

- **Structures de données** :  
Utiliser SQL si les données sont tabulaires et interconnectées avec des relations complexes. Opter pour du NoSQL si vous avez besoin d'un schéma flexible.

- **Schémas**:  
SQL a un schéma fixe ou la structure doit être définie à l'avance. Les modifications de schéma d'ampleur peuvent être difficile. En NoSQL, vous pouvez ajouter de nouveaux champs sans avoir à définir un schéma rigide à l'avance.

- **Transaction ACID**:  
Si la cohérence des données et la garanties des transactions est primordiale pour l'application, SQL peut être le choix appropriée. Le NoSQL, en particulier sous sa forme Clé - Valeur va sacrifier les propriétés ACID pour améliorer les performances et l'évolutivité.

- **Complexité des requêtes**:  
SQL excelle dans les requêtes complexes qui impliques des relations entre de nombreuses tables.
Le NoSQL sera plus indiqué pour des requêtes courtes et simples sur des ensembles de données massifs.

Exemple d'utilisations:  
- 
SQL est souventutilisé dans des applications où la structure des données est stable et bien définie comme des applications bancaires/financières, les système de gestion de stock...  
NoSQL est courament utilisé dans des applications nécessitant cette fameuse mise à l'échelle horizontale, telle les réseaux sociaux, les applications de suivis etc...

 ## **INTRODUCTION A MONGODB**
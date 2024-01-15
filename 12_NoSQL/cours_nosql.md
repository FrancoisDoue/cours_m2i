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
___
SQL est souventutilisé dans des applications où la structure des données est stable et bien définie comme des applications bancaires/financières, les système de gestion de stock...  
NoSQL est courament utilisé dans des applications nécessitant cette fameuse mise à l'échelle horizontale, telle les réseaux sociaux, les applications de suivis etc...

 ## **Introduction à MongoDB**

MongoDB est une base de données NoSQL populaire, orientée document, conçue pour stocker, interroger et gérer des données de manière flexible et scalable.
- **Modèle de données**  
MongoDb stocke les données sous forme de documents au format `BSON` (Binary JSON), très similaire au JSON. Chaque document peut contenir des champs de différents types, et la structure des documents peut varier d'un enregistrement à l'autre.

- **Les collections et documents**  
Les documents MongoDB sont regroupés dans des collections, qui sont équivalentes à des tables dans les monde des BDDR. Cependant, contrairement aux tables SQL, les collections ne nécessitent pas un schema fixe.

- **Langage de requête**  
MongoDB utilise un langage de requête appelé MongoDB Query Langage (`MQL`) pour interragir avec la BDD. Les opérations lecture, écriture, mise à jour, suppression sont effectuées à l'aide de commande MongoDB.

- **Indexation**  
MongoDB prend en charge l'indexation des données, ce qui permet d'accélèrer les opérations de recherches en créant des index sur des champs fréquemment utilisés. Cela contribue à améliorer les performances de requêtes

- **Evolutivité**  
MongoDB est spécialement conçue pour l'évolutivité horizontale, ce qui signifie qu'il est facile d'ajouter de nouveaux serveurs pour gérer des charges de travail croissantes. Cela le rend adapté aux applications nécessitant une mise à l'échelle dynamique.

## JSON ou BSON ?

JSON est un format de sérialisation de données en texte lisible par l'homme.  
BSON est sa version binaire étendue, spécialement conçue pour MongoDB, offrant une capacité de stockage accrue, avec des types de données supplémentaires. MongoDB utilise BSON comme stockage de format natif.

En raison de sa représentation binaire, BSON est plus compact et offre une meilleure efficacité en terme de stockage et de traitement.

## Collections et documents

1. **Structure**
    - **Document ->** Un document MongoDB est une unité de stockage de données au format BSON. Il est similaire à un objet JSON et peut contenir des paires clés-valeur, des tableaux ainsi que d'autres documents imbriqués.

    - **Collection ->** Une collection MongoDB est un ensemble de documents. Contrairement à une table, elle n'a pas de schema fixe, chaque document peut avoir une structure différente.

2. **Propriétés**
    - **Identifiant unique (_id)  ->** Chaque document à un champ spécial `_id` qui doit être unique au sein de la collection. Il peut être généré automatiquement ou spécifié manuellement.

    -  **Collections sans schema fixe ->** Les collections ne nécessitent pas de déclarations de schémas à l'avance.

## Opération CRUD dans MongoDB Compass :
- **Insertion (Create)**  
Selectionner la base de données et la collection >> cliquer sur  `Add Data` et saisissez les valeurs du nouveau document
- **Lecture (Read)**  
    - étape 1: On ouvre la BDD et la collection
    - étape 2: 
    - étape 3: Profits!  
Utilisez l'interface graphique pour construire des requêtes de recherche avec filtres.
- **Mise à jour (Update)**  
Au sein de la collection, utiliser le bouton edit à droite de chaque document.
- **Supprimer un élément (Delete)**  
Cliquer sur le bouton delete pour supprimer un ou plusieurs documents.

## Les filtres
Les filtres de MongoDB sont utilisés pour spécifier des critères de recherche lors des opération du CRUD, les filtres permettent des restreindre les résultats en fonction de conditions spécifiques

1. **Opérateurs de comparaisons**
    - Les opérateurs de comparaisons tels que  
    `$eq` pour égal,   
    `$ne` pour différent de,  
    `$gt` pour suppérieur a,  
    `$lt` pour inférieur a,  
    `$gte` pour supérieur ou égal à,  
    `$lte` pour inférieur ou égal à

2. **Opérateurs logiques**
    - Les opérateurs logiques tels que `$and`, `$or`, `$not` sont utilisés pour combiner des conditions

3. **Opérateurs d'éléments**
    - les opérateurs d'éléments tels que `$exists` et  `$type`, permettent de filtrer les documents en fonction de leur présence ou de leur type
4. **Les opérateurs d'éléments dans un tableau**
    - Les opérateurs d'élements tels que  `$in`,  `$nin`,  `$all` sont utilisés pour effectuer des requêtes dans des tableaux  
    Exemple:  
    ```Javascript
        // récupérer les utilisateurs dont l'âge et soit 25, soit 30
        {age: {$in [25, 30]}}
    ```
5. **Les opérateurs de recherche de texte**  
    - les opérateurs de recherche textuels tels que `$text` est utilisé pour effectuer des recherches de texte dans les champs textuels indexés

6. **Opérateurs d'expression régulière**
    - `$regex` permet d'appliquer des expression régulières dans les filtres  
        ```Javascript
        // récupérer les utilisateurs dont le nom commence pas la lettre L
        {nom: {$regex: /^L/ }}
    ```
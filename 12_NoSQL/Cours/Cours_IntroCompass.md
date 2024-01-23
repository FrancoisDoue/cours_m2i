# Le NoSQL

Le terme "NoSQL" (Not Only SQL) fait référence à une classe de système de gestion de base de données qui diffèrent des BDD relationnelles traditionnelles.
Les BDD NoSQL sont conçues pour répondre à des besoins spécifiques, tels que la gestion de grandes quantités de données non structurées ou semi-structurées, la mise à l'échelle horizontale facile, la flexibilité de schéma, et une meilleure performance dans certains scénarios.

Les caractéristiques générales des BDD NoSQL incluent:

- **Schéma flexible:** Elles permettent de stocker des données sans avoir à définir un schéma fixe à l'avance. Cela offre une flexibilité accrue pour traiter particulièrement les données évolutives ou diverses.

- **Evolutivité horizontale:** Elles sont conçues pour évoluer facilement en ajoutant de nouveaux serveurs au lieu d'augmenter les ressources d'un serveur existant. Cela facilité la gestion de volumes de données massives.

- **Gestion de données non structurées ou semi-structurées:** Les BDD NoSQL peuvent gérer des types de données variés, tels que les documents, des paires clé-valeurs, des graphiques ou des colonnes offrant une flexibilité accrue par rapport aux BDDR qui sont basées sur un modèle tabulaire.

- **Haute performance dans des cas spécifiques**: Les BDDNR peuvent offrir des performances supérieures à celles des BDDR, en particulier lorsqu'il s'agit de lectures ou d'écritures parallèles.

## SQL ou NoSQL ?

Voici quelques critères à considérer lors du choix entre SQL et NoSQL:

- **Structure de données**: Utilisez SQL si vos données sont principalement tabulaires et interconnectées avec des relations complexes. Optez pour du NoSQL si vous avez plutôt besoin d'un schéma flexible.

- **Schémas**: SQL a un schéma fixe où la structure doit être définie à l'avance. Les modifications de schéma d'ampleur peuvent être difficiles. En NoSQL, vous pouvez ajouter de nouveaux champs sans avoir à définir un schéma rigide à l'avance.

- **Transactions ACID**: Si la cohérence des données et la garantie des transactions sont cruciales pour votre application, SQL peut être le choix approprié. Le NoSQL, en particulier sous la forme clé-valeur, va sacrifier les propriétés ACID pour améliorer la performance et l'évolutivité.

- **Complexité des requêtes**: SQL excelle dans les requêtes complexes qui impliquent des relations entre de nombreuses tables. Le NoSQL va être plus approprié pour des requêtes courtes et simples sur des ensembles de données massifs.

Exemples d'utilisation: SQL est souvent utilisé dans des applications où la structure des données est stable et bien définie comme les applications bancaires/financières, les systèmes de gestion de stocks...
NoSQL est couramment utilisé dans des applications nécessitant cette fameuses mise à l'échelle horizontal, telles que les réseaux sociaux, les applications de suivi en temps réel, les applications Big Data etc...

## Introduction à MongoDB

MongoDB est une base de données NoSQL populaire, orientée document, conçue pour stocker, interroger et gérer des données de manière flexible et scalable:

- **Modèle de données:** MongoDB stocke les données sous forme de documents au format BSON (Binary JSON), très similaire au JSON. Chaque document peut contenir des champs de différents types, et la structure des documents peut varier d'un enregistrement à l'autre.

- **Collections et Documents:** Les documents MongoDB sont regroupés dans des collections, qui sont équivalentes à des tables dans le monde des bases de données relationnelles. Cependant, contrairement aux tables SQL, les collections ne nécessitent pas un schéma fixe.

- **Langage de requête:** MongoDB utilise un langage de requête appelé MongoDB Query Language (MQL) pour interagir avec la BDD. Les opérations de lecture, écriture, mise à jour et suppression sont effectuées à l'aide de commandes MongoDB.

- **Indexation:** MongoDB prend en charge l'indexation de données, ce qui permet d'accélérer les opérations de recherches en créant des index sur des champs fréquemment utilisés. Cela contribue à améliorer les performances de requêtes.

- **Evolutivité:** MongoDB est conçu pour l'évolutivité horizontale, ce qui signifie qu'il est facile d'ajouter de nouveaux serveurs pour gérer des charges de travail croissantes. Cela le rend adapté aux applications nécessitant une mise à l'échelle dynamique.

## JSON ou BSON ?

JSON est un format de sérialisation de données en texte lisible par l'homme. BSON est sa version binaire étendue, spécialement conçue pour MongoDB, offrant une efficacité de stockage accrue avec des types de données supplémentaires. MongoDB utilise BSON comme stockage de format natif.

En raison de sa représentation binaire, BSON est plus compact et offre une meilleure efficacité en terme de stockage et de traitement.

## Collections et Documents

1. **Structure**  
    - **Document:** Un document MongoDB est une unité de stockage de données au format BSON (Binary JSON). Il est similaire à un objet JSON et peut contenir des paires clés-valeur, des tableaux ainsi que d'autres documents imbriqués.

    - **Collection:** Une collection MongoDB est un ensemble de documents. Contrairement à une table, elle n'a pas de schéma fixe, chaque document peut avoir une structure différente.

2. **Propriétés**
    - **Identifiant unique (_id):** Chaque document à un champ spécial appelé "_id" qui doit être unique au sein de la collection. Il peut être généré automatiquement ou spécifié manuellement.
    - **Collections sans schéma fixe:** Les collections ne nécessitent pas de déclaration de schéma à l'avance.

## Opérations CRUD dans MongoDB Compass:

  - **Insertion (Create):** Sélectionnez la base de données et la collection. Cliquez sur le bouton Add Data >> Insert Document et saisissez les valeurs du nouveau document.

  - **Lecture (Read):** Sélectionner la collection dans Compass. Utilisez l'interface graphique pour construire des requêtes de recherche avec des filtres.

  - **Mise à jour (Update):** Au sein de votre collection, utilisez le bouton "Edit" à droite de chaque document.

  - **Suppression (Delete):** Utilisez le bouton "Delete" pour supprimer un ou plusieurs documents

## Les filtres

Les filtres dans MongoDB sont utilisés pour spécifier des critères de recherche lors des opérations de lecture et des opérations de suppression et de mise à jour. Les filtres permettent de restreindre les résultats en fonction de conditions spécifiques.

**1. Opérateurs de comparaison:**  
  - Les opérateurs de comparaison, tels que `$eq` (égal), `$ne` (différent), `$gt` (supérieur à), `$lt` (inférieur à), `$gte` (supérieur ou égal à), `$lte` (inférieur ou égal à) sont utilisés pour comparer des valeurs

**2. Opérateurs logiques:**
  - Les opérateurs logiques, tels que `$and`, `$or`, `$not` sont utilisés pour combiner des conditions.

**3. Opérateurs d'éléments:**
  - Les opérateurs d'éléments, tels que `$exists` et `$type`, permettent de filtrer les documents en fonction de la présence ou du type d'un champ.

**4. Opérateurs d'éléments dans un tableau:**
  - Les opérateurs tels que `$in`, `$nin`, `$all` sont utilisés pour effectuer des requêtes dans des tableaux.
  ```javascript
  // Exemple: Récupérer les utilisateurs dont l'âge est soit 25, soit 30
  {age: {$in: [25, 30]}}
  ```

**5. Opérateurs de recherche de texte:**
  - L'opérateur `$text` est utilisé pour effectuer des recherches de texte dans les champs textuels indexés.

**6. Opérateurs d'expressions régulières**
  - L'opérateur `$regex` permet d'appliquer des expressions régulières dans les filtres.
  ```javascript
  // Exemple: Récupérer les utilisateurs dont le nom commence par la lettre "L"
  {nom: {$regex : /^L/}}
  ```


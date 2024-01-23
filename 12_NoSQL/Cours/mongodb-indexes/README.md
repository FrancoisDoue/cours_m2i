# Les index dans MongoDB

## A quoi ça sert ?

Dans l'univers de la manipulation de données, l'indexage est une methode permettant de retrouver nos information à une vitesse supérieure.  
Il est possible d'indexer les attributs d'un document pour permettre à la requête de travailler via une méthodologie différente qui a pour but d'accélerer le retour via une recherche dans une liste de champs qui sont indexés.  
Ainsi si l'ont indexe les prénoms des documents de personne, la BDD gardera dans un espace de stockage particulier les prénoms sous la forme d'une liste triée de la bonne façon pour ensuite récupérer les éléments qui y sont liés (l'ensemble des documents).

**Attention**: l'indexage à outrance n'est forcément pas une bonne solution, notamment de par la nécessité de mettre à jour la liste d'index à chaque nouvelle entrée dans la collection. Il est donc important de trouver le bon équilibre pour permettre de bonnes performances en ajout et en récupération de données.

Il est également intéressant de noter que l'utilisation d'un index peut s'avérer utile dans le cadre de la récupération de données triées. De par le fait qu'un index est de base trié, alors MongoDB n'aura pas besoin de placer toutes les données en mémoire avant le tri, ce qui pourrait être trop demander pour le paramètre par défaut dû à la limite de documents potentiels en mémoire.

---

## Ajouter un Index

Pour créer et afixer un index sur une collection, il faut choisir quel champ sera indexé (le champ du document se verra mis dans une liste ordonnée ne contenant que le champ choisi pour les documents de la collection). Une fois fait, il nous faudra le paramétrer via la commande ci-dessous

```js
db.collectionName.createIndex({nomDuChamp : 1}) 
// si la valeur est négative alors la liste générée le sera via un tri descendant
```

Dans le cas où l'on voudrait retirer l'indexage:
```js
db.collectionName.dropIndex("nomDuChamp") // par nom
db.collectionName.dropIndex("nomDuChamp": 1) // par description
```
Si on veut, il est possible de visionner les indexages disponibles sur une collection via la methode ci-dessous:
```js
db.collectionName.getIndexes()
```
---

## Index lié

Il est également possible, dans le monde de MongoDB, de créer des index composés se basant sur plusieurs champs triés d'une certaine façon. Un index de ce genre va pouvoir être utilisé pour chercher rapidement dans le premier champ demandé, soit dans les deux d'un coup, mais pas dans le deuxième uniquement. Pour pouvoir se servir d'une recherche dans le second champ, il faudré crer un autre index.

Pour créer un index lié:
```js
db.collectionName.createIndex({fieldNameA: 1, fieldNameB: -1})
```

### Unicité

Il est possible d'utiliser les index de type unique dans le but d'éviter les duplicats de données, come par exemple dans le cadre d'un email. Pour pouvoir nous servir de ce type d'index, il faut procéder par l'ajout d'un argument supplémentaire
```js
db.collectionName.createIndex({field: 1}, {unique: true})
```

En cas de duplicat lors de l'ajout de cet index, le système va nous avertir via une erreur qu'il n'est pas possible de placer car les données ne le permettent pas. De même par la suite, lors d'un ajout, le contrôle via cet index pourrait empêcher l'insertion.

### Time-to-live indexes

Dans le cadre où l'on aurait des données qui auraient pour objectif d'être auto-détruites, comme par exemple une session d'utilisation possédant un délai d'expiration, alors il est peut-être intéressant d'utiliser un autre type d'index, les index possédant dun temps de vie, ce qui n'est pas possible sur les valeurs de type date.
```js 
db.collectionName.createIndex({fieldDate: 1}, {expireAfterSeconds: 60})
```

---


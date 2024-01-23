# Express.js

## Introduction

### Qu'est-ce qu'Express.js?
Express est un framework web minimaliste, rapide et flexible, conçu pour simplifer le développement d'applications web et d'API avec Node.js. Il fournit une structure légère mais puissante pour construire des applications robustes et scalables en utilisant JavaScript côté serveur.

**Principales caractéristiques:**  

- **Minimalisme :**  
Express adopte une approche minimaliste, laissant aux développeurs la liberté de choisir et d'intégrer des modules tiers selon les besoins spécifiques.

- **Middleware :**  
Un concept clé sur lequel est bâti Express est l'utilisation de middleware. Ces fonctions interviennent dans le cycle de vie des requêtes, permettant de gérer des tâches telle que l'authentification, la gestion des sessions, la compression, etc...

- **Routage :**  
Express simplifie la définition des routes et la gersion des requêtes HTTP, facilitant la création des points d'entrée pour différentes parties de l'application.

- **Templates :**  
Express supporte divers moteurs de template pour la générations dynamique de contenu HTML, tels que EJS, HandleBars ou PUG (Jade).

- **Gestion des erreurs :**  
Fournit des mécanisme efficaces pour la gestion des erreurs, facilitant le débogage et l'amélioration de la robustesse des applications.

- **RESTful Routing :**  
Encourage la conception d'API RESTful en facilitant la création de routes pour le CRUD (Create, Read, Update, Delete).

L'architecture d'Express.js repose sur les fonctionnalités offertes par Node.js, notamment la gestion des requêtes HTTP, la manipulation des évènements et le modèle non-bloquant.  
Par conséquent, **il n'est pas possible d'utiliser Express.js en dehors de l'écosystème Node.js**.

## Express.js et Node.js
**Node.js** est un environnement permettant **d'utiliser du JavaScript côté serveur**, ce qui est traditionnelement réservé aux navigateurs. Ce système rapide et évolutif, capable de gérer les opérations asynchrones nous permettra de mettre en place notre framework Express.js.  
Le fait d'utiliser Node.js nous permet **plusieurs avantages essentiels côté serveur:**  

- **L'équivalence de Langage :**  
Node permet l'utilisation du même langage (JS) pour le développement Client et Serveur, simplifiant la synchronisation et le partage de code entre les deux.
- **Modularité :**  
Node encourage l'utilisation de modules, permettant aux développeurs de construire des applications modulaires, facile à maintenir et à étendre.
- **Asynchronisme :**  
Utilise des opérations asynchrones non-bloquantes, ce qui le rend adaptés aux applications nécessitant une manipulation simultanée de nombres connexions.
- **Scalabilité :**  
Conçu pour être évolutif horizontalement.
- **Idéal pour les applications en temps réel:**  
Excellente prise en charge des applications en temps réel, tel que les Chat en direct, les jeux en ligne et les tableaux de bord de suivi en temps réel.

Bien entendu, Express n'est pas le seul framework pour le développement web qui repose sur Node.js, on peut citer aussi **Koa.js, Hapi.js, NestJS ou encore AdonisJS**.

## Feuille de route: Commencer avec Express.js

1. **Installation :**  
Utiliser npm pour installer express sur un projet : `npm install express`
2. **Création d'une application Express :**  
Initialiser un application Express avec quelques lignes de code, par exemple:  
```javascript
const express = require('express')
const app = express()
app.get('/', (req, res) => {
    res.send('Hello!')
})

app.listen(3000, () => {
    console.log('Server is running on port 3000')
})
```
3. **Middleware et Routage :**  
Utilisez le middleware pour gérer les requêtes et définissez des routes pour structurer votre application.

4. **Template et Vues :**  
Intégrer un moteur de template pour générer du contenu dynamique.

5. **Extention avec d'autres modules :**  
Explorez et ajoutez des modules supplémentaires en fonction des besoins de votre projet.


# Le routing

L'un des aspects les plus importants d'Express.js est son système de routage. Il permet de définir comment l'application répond à une demande client particulière, en fonction de l'URL demandée, de la méthode HTTP utilisée (GET, POST, etc.)

## Les routes de base
Les routes dans Express.js sont définies en associant une URL à une fonction de gestion (handler function). Voici un exemple de route simple:

```js
app.get('/', (req, res) => {
  res.send("Bienvenue sur la page d'accueil!");
});
```
Dans cet exemple, lorsque l'utilisateur accède à la racine de votre site ("/"), la fonction de gestion spécifiée est exécutée, et le message "Bienvenue sur la page d'accueil!" est envoyé en réponse.

Une fonction de gestion (handler function) est exécutée lorsque l'application reçoit une requête HTTP correspondant à une route spécifique. Cette fonction est responsable du traitement de la requête puis de la génération de la réponse à renvoyer au client.

Dans le cadre des routes Express, la fonction de gestion prend généralement deux paramètres: `req` (request) et `res` (response). Ces paramètres représent respectivement l'objet de la requête HTTP entrante et l'objet de réponse que votre application Express utilisera pour envoyer la réponse au client.

## Construire un routeur
Un routeur dans Express est un moyen de regrouper les routes liées à une partie spécifique de votre application. Cela rend le code plus lisible et facilite la gestion des différentes fonctionnalités de votre application.

Pour cela, créez un fichier séparé pour votre routeur, par exemple `routes.js`. Dans ce fichier, importez Express et créez un routeur:

```js
// routes.js
const express = require("express");
const router = express.Router();

// Définissez vos routes
router.get('/', (req, res) => {
  res.send("Bienvenue sur la page d'accueil");
});

// Exportez le routeur pour l'utiliser dans le fichier principal (app.js)
module.exports = router;
```

Modifiez le fichier app.js pour utiliser le routeur créé.

```js
//app.js
const express = require('express');
const app = express();

// Importez le routeur
const mainRouter = require("./routes")

// Utilisez le routeur pour gérer les routes
app.use('/', mainRouter);

const port = 3000;
app.listen(port, () => {
  console.log(`Serveur en écoute sur le port ${port}`);
});
```
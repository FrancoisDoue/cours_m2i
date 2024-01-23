# Gestion des modules en Node.js

## Compréhension du système de module intégré

Node, en tant qu'environnement js côté serveur, dispose d'un système de module intégré qui permet d'organiser le code de manière modulaire. Cela favorise la réutilisation du code, la gestion des dépendances et la maintenabilité du code.

### 1 - Module... kécécé?
En Js, un module est généralement un fichier contenant du code. Ce code peut être des variables, fonctions, objet... et peut être réutilisé dans d'autres parties de l'application.

### 2 - Le système de modules de Node.js
Node utilise un système de module basé sur le système de fichiers local. Chaque fichier Js est considéré comme un module, et les fonctionnalités exposées par un module peuvent être importées dans un autre module.

### 3 - require() et module.exports
- **`require()`** :  cette fonction est utilisée pour importer des fonctionnalitées d'autres modules dans le module en cours. elle prend en paramètre le chemin du module à importer. Par exemple : 

```js
const myModule = require('./myModule.js')
```
- **`module.exports`** : Cette propriété est utilisée pour exporter des fonctionnalités depuis un module, les rendant ainsi accessible dans d'autres modules.

```js
// dans myModule.js

const myFunc = () => console.log('Module inutile (de rien.)')

module.exports = myFunc
```
```js
// config.js
const API_KEY = "an-api-key"
const API_URL = "https://useless-api.com"
module.exports = {
    API_KEY, 
    API_URL
}
```


# Variables globales

Les variables globales en Node.js sont des variables qui sont accessibles de manière globale dans tout le contexte d'exécution d'une application Node.js. Elles ne nécessitent pas d'importation spécifique et peuvent être utilisées directement dans n'importe quel fichier du projet. Parmi les variables globales les plus couramment utilisées, on trouve `__dirname`, `__filename`, `process`, et `global`.
**Attention:** Ces variables globales ne fonctionnent que dans un contexte en CommonJS.

1. **`__dirname` et `__filename`** :
    - `__dirname`: Cette variable représente le chemin du répertoire du fichier actuellement en cours d'exécution. Elle est souvent utilisée pour construire des chemins de fichiers absolus.
    - `__filename`: Cette variable représente le chemin complet du fichier en cours d'exécution, y compris le nom du fichier.
    
    Exemple d'utilisation :
    
    ```jsx
    console.log(__dirname);     // Affiche le chemin du répertoire du fichier en cours d'exécution
    console.log(__filename);    // Affiche le chemin complet du fichier en cours d'exécution
    
    ```
    
2. **`process`** :
    - L'objet `process` fournit des informations et des fonctionnalités liées au processus en cours d'exécution. Il contient des propriétés telles que `process.env` (pour les variables d'environnement), `process.argv` (pour les arguments de ligne de commande), etc.
    
    Exemple d'utilisation :
    
    ```jsx
    console.log(process.env.NODE_ENV);   // Affiche la valeur de la variable d'environnement NODE_ENV
    
    ```
    
3. **`global`** :
    - `global` est un objet qui représente l'espace global dans Node.js. Toutes les variables que vous déclarez sans utiliser `var`, `let`, ou `const` deviennent automatiquement des propriétés de l'objet `global`.
    
    Exemple d'utilisation (évitez d'utiliser cela autant que possible, car cela peut causer des problèmes de portabilité du code) :
    
    ```jsx
    global.maVariable = 'Ceci est une variable globale.';
    console.log(maVariable);   // Affiche la variable globale
    
    ```
    

Il est généralement recommandé d'éviter l'utilisation excessive de variables globales, car cela peut rendre le code moins modulaire et plus difficile à comprendre. Les modules Node.js et l'utilisation appropriée de la portée des variables sont souvent préférés pour une structure de code plus propre et plus maintenable.
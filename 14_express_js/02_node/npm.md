# Node Package Manager (NPM) dans Node.js

## 1 - Qu'est-ce que NPM?
- Npm est le gestionnaire de packet officiel pour Node.js, le moteur Js côté serveur. Il permet aux développeurs d'installer, partager et gérer les dépendances de leur projet Node de manière efficace

## 2 - Installation de Node.js et NPM
- En installant Node.js, NPM est automatiquement inclu. Node peut être téléchargé à partir du site officiel et une fois installé, NPM est pret à être utilisé.
Je peut vérifier les versions installées grâce aux commandes:
    ```cmd
    node -v
    npm -v
    ```

## 3 - Gestion des dépendances
- NPM simplifie la gestion des dépendances en permettant d'installer des bibliothèques tierces (package) nécessaires à leurs projets
- Les dépendances sont répertoriées dans le fichier `package.json`, et NPM installe de manière hiérarchique dans le repertoire `node_modules`.

## 4 - Initialisation du projet
En utilisant la commande `npm init` les développeuts peuvent créer un `package.json` où ils spécifient des détails tels que le nom du projet, la version... 

## 5 - Installation des packages
- Les packages peuvent être installés localement pour un projet spécifique, ou globalement pour une utilisation système en utilisant la commande `npm install`
    - Exemple local: `npm install <nom-du-package>` 
    - Exemple global: `npm install -g <nom-du-package>`

**Remarque :** Les package installés globalement peuvent entrainer des problèmes compatibilité entre les différentes versions d'un projet, car tous les projets utilisent la même instance du package global. Par conséquent, il est généralement recommandé de préférer une utilisation locale pour des dépendances spécifiques à un projet et l'installation globale pour les outils généraux.

## 6 - Utilisation des scripts
- NPM permet la définition de scripts dans le fichier `package.json`. Ces scripts peuvent être exécutés avec la commande `npm run <nom-du-script>`
    - exemple: 
        ```json
        "script": "node index.js"
        ```

## 7 - Gestion des versions:
- NPM facilite la gestion des versions de packets. les développeurs peuvent spécifier des versions exactes ou utiliser des modificateurs comme `^` ou `~` pour gérer les mises à jour.

## 8 - Publication de package:
- Les devs peuvent partager leurs propre package avec la communauté en les publiant sur le registre public de NPM. La commande `npm publish` est utilisée pour cela.

## 9 - Contrôle d'accès:
- NPM offre des fonctionnalités de contrôle d'accès pour les package privés, permettant aux entreprises de gérer l'accès à leurs modules

## Et le package-lock.json ?
Le fichier `package-lock.json` est un fichier généré par NPM qui enregistre l'état exact des dépendances d'un projet Node à un moment donné.

1. **Reproductibilité des installations** : Le package-lock garantit la reproductibilité des installations en enregistrant les versions exactes des dépendances installées, y compris les sous-dépendances.
Cela signifie qu'à chaque fois que quelqu'un d'autre ou vous même installez des dépendances, les versions spécifiées seront utilisées, assurant une cohérences entre les environnements de developpement.

2. **Eviter les mises à jour inattendues** : Sans le package-lock, npm pourrait installer des versions plus récentes des dépendances lors de l'installation, même si vous avez spécifié des plages de versions dans le fichier `package.json`. Le package-lock s'assure que les versions exactes sont respectées, évitant ainsi les mises à jour inattendues.

3. **Sécurité:** En enregistrant les versions exactes des dépendances et de leurs sous-dépendances, le `package-lock.json` contribue à la sécurité du projet en évitant les vulnérabilités potentielles liées à l'utilisation de versions non spécifiées.

4. **Accélération des installations:** Le `package-lock.json` permet d'accélérer les installations en évitant de rechercher les versions des dépendances à chaque installation. Les versions sont déjà répertoriées dans le fichier, ce qui accélère le processus d'installation.

Pour générer ou mettre à jour le `package-lock.json`, vous pouvez utiliser la commande `npm install`. Le `package-lock.json` doit être inclus dans le contrôle de version (Git) pour assurer une cohérence entre les membres de l'équipe.
Pour installer les modules en prenant compte le `package-lock.json`, vous devez utiliser la commande `npm ci`.
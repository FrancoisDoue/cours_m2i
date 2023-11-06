# Le CLI (Interface en ligne de Commandes)

Le CLI, ou interface en ligne de commandes, est une méthode d'interaction avec un ordinateur ou un système informatique en utilisant des commandes textuelles plutôt que des interfaces graphiques. Au lieu de cliquer sur des icônes et de naviguer à travers des menus, vous saisissez des commandes spécifiques dans une fenêtre de terminal pour effectuer des actions.

## Avantages du CLI

1. **Efficacité:** Le CLI peut être plus rapide pour accomplir des tâches spécifiques une fois que vous en maîtrisez les commandes.

2. **Automatisation:** Les scripts et les automatisations peuvent être créés plus facilement en utilisant des commandes CLI, ce qui est utile pour des tâches répétitives.

3. **Environnements distants:** Vous pouvez utiliser le CLI pour interagir avec des systèmes distants via des connexions réseau, ce qui peut être difficile avec une interface graphique.

4. **Contrôle précis:** Le CLI offre souvent un contrôle plus précis sur les paramètres et les options lors de l'exécution de commandes.

## Principaux éléments du CLI:

1. **Terminal:** C'est l'interface qui vous permet de saisir des commandes. Les systèmes d'exploitation tels que Linux, MacOs et Windows ont tous leur propre terminal. 

2. **Commandes:** Ce sont les instructions que vous saisissez dans le terminal pour effectuer différentes actions. Les commandes peuvent être simples (comme `ls` pour lister les fichiers) ou complexes (comme `git pull origin main` pour mettre à jour un dépôt git).

3. **Options et arguments:** Les commandes peuvent être suivies d'options et d'arguments pour personnaliser leur comportement. Les options sont généralement précédées d'un tiret court (comme `-l` pour une liste détaillée) et les arguments sont les valeurs spécifiques que vous fournissez à la commande.

## Exemples de commandes CLI:

- `pwd` permet de savoir le chemin du répertoire courant où l'on se trouve au cas où notre bash ne l'indique pas.
- `ls` (Linux/Mac) ou `dir` (Windows) : Liste les fichiers et dossiers dans le répertoire courant.
- `cd`: Changer le répertoire courant.
    - On utilise `cd ..` pour revenir dans le dossier parent.
    - On utilise la touche TAB pour auto-compléter mes noms de fichiers/dossiers.
- `mkdir`: Crée un nouveau dossier. (par exemple : `mkdir MonDossier`)
- `rm` (Linux/macOS), `rmdir` ou `del` (Windows): Supprime des fichiers ou dossiers
    - L'option `-r` (recursive) ajoutée à la commande `rm` permet de supprimer non seulement le répertoire spécifié, mais aussi tous les fichiers et sous-répertoires qu'il contient, ainsi que les fichiers et sous-répertoires des sous-répertoire etc...
- `cp` (Linux/macOS) ou `copy` (Windows): Copie des fichiers ou des dossiers.
    - Cette commande nécessite deux arguments: 1er: nom du fichier, 2ème: destination.
- `mv` (Linux/macOs) ou `move` (Windows): Déplace des fichiers ou dossiers. Nécessite deux arguments.
    - Elle peut également servir à renommer un dossier ou un fichier si mon deuxième argument est un nom de fichier à la place d'une destination.
- `touch` (Linux/macOs) suivi du nom du fichier pour créer un fichier (attention, on n'oublie pas l'extension). On peut créer facilement plusieurs fichiers de cette façon:
    ```bash
    # Pour créer un ou plusieurs fichiers
    touch fichier1.txt fichier2.txt
    ```
- Pour Windows (mais cela marche également sur macOS et Linux), on utilise `echo . > nomdufichier.extension` car il n'existe pas de commande pour créer un fichier sans lui préciser du contenu (mais ce contenu peut être vide). Le point vient juste insérer un caractère, il peut être remplacé par n'importe quel texte
    ```bash
    # Pour créer un fichier
    echo . > fichier1.txt
    # Pour ajouter du texte à un fichier existant
    echo "texte" >> fichier1.txt 
    ```
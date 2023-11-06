```bash
git config --global user.name "MyName"
git config --global user.email "my.mail@mail.com"

# Pour obtenir de l'aide sur les commandes:
git help "nom de la commande"
git "commande" --help # ou -h
```

## initialiser une dépot git

Pour commencer un suivre les modifications d'un projet, vous devez créer un dépot Git. Vous pouvez le faire en executant la commande suivante **dans le repertoire du projet**
```bash
git init
```
pour supprimer un dépot git, supprimer le `.git`
```bash
rm -rf .\.git
```

## le staging (indexage)
Le staging est une etape intermediaire essentielle  lors de l'utilisation de git.  
C'est le mecanisme qui nous permet de prépare soigneusement le modifications que l'on souhaite inclure au commit.

Je peux ajouter les fichiers que je souhaite à mon commit via la commande
```bash
git add "nom du fichier"
# ou faire "git add ." comme un bourrin
```
Pour afficher la liste des fichiers qui sont actuellement en staging, donc prêts à être inclus au prochain commit, on peut utiliser la commande
```bash
git status
```
pour retirer un fichier du staging area (zone d'indexage) sans annuler les modifications apportées au fichier, on peut usiliser `git rm`


## Créer un instantané
lorsque mes fichiers surveillés sont prêts pour la staging area, je peux prendre à tout moment un instantané (commit) de leur état. Ce commit agira comme une sauvegarde à laquelle je pourrais réaccéder quand je le souhaite. La commande est simplement `git commit`

---
L'éditeur de texte utilisé de base par Git est Vim.
Par défaut, nous ne sommes pas en mode insertion de caractère. Il faudra appuyer sur la touche "**A**" ou la touche "**I**"  
Pour quitter le mode insertion: "**Echap**"  
En dehors du mode insertion, je peux écrire des ligne de commandes si je les commence par " **:** "  
- `:q `(quit) - cette commande quite vim mais uniquement si aucun changement n'a été apporté au document. Si c'est le cas, vim indiquera un message d'erreur
- `:q!` (force quit) - Quitte l'éditeur même si des changements ont été apportés, ceux-là seront perdus.
- `:wq` (write & quit) ou `:x` - Changements sauvegardés, on quitte l'éditeur et le commit est envoyé

Pour de très longs noms, cela pourra servir, mais de manière générale, on préfèrera l'option `-m` (pour message) à la commande commit pour indiquer directement son nom en argument
```bash
git commit -m "Ceci est un message"
```

L'option `-a` (pour add): ajoute toutes les modifications des fichiers déjà suivis par le staging area sans avoir besoin de répéter le `git add`, mais il n'ajoutera pas les nouveaux fichiers créés par le commit (que je devrais intégrer classiquement avec `git add`) ni ceux qui ont été supprimés. En gros, cela ne concerne que les modifications!  
Les options sont cumulables dans git (ex: `-a -m` ou `-am`)
```bash
git commit -a
git commit -am 'message'
```
## Logs
```bash
git log

git log -n 
#+ nbr de notre choix: affiche nbr de commits
# affiche à partir des plus récents

git log --oneline # offre une version condensée en une ligne
```

## Show:
Pour voir les détails spécifiques d'un commande, on utilise la commande `git show`.
```bash
git show [id-du-commit]
```
Si je souhaite comparer deux commit: `git diff`
```bash
git diff [id-commit-1] [id-commit-2]
```

## Revenir à une version antérieur:

une fois que je dispose de plusieurs commit: je peux revenir à des versions antérieures.  
Pour revenir à un commit précédents dans git, on peut utiliser la commande `git checkout` ou `git revert`. Le choix entre ces deux commandes dépend de ce que qu'on souhaite accomplir.

- `git checkout` pour revenir à une version précédente:  
Examiner simplement le contenu d'un commit précédent sans affecter sa position actuelle.
Cependant tout nouveau commit créé à partir de cet état ne sera pas sur une branche et pourrait être perdu.
```bash
git checkout [id-du-commit-cible]
```
- pour revenir au commit actuelle, on utilise `git switch -` (le - sert de raccourci qui nous ramène à la précédente version de la branche)

- utiliser le `git reset` pour revenir à un commit précédent:  
Si on veut revenir à un commit précédent tout en ***annulant les commits ultérieurs***, on peut utiliser le `git reset`.  
Il existe 3 options:
    - `--soft` : réinitialise le HEAD au commit précédent tout en conservant les modifications en staging (faire un add avant le reset). On peut donc faire un commit avec les modifications actuelles nécessaires.
    - `--mixed` [default] : Réinitialise le HEAD au commit précédent et annule les modifications en staging.
    - `--hard` : réinitialise totalement le HEAD et l'index au commit précédent et supprime toutes les modifications locales.

```bash
git reset --hard [id-du-commit]
```

Il est important de noter que les commits ne sont pas immédiatements supprimés après un `git reset`, ils sont simplement déréférencés de la branche et deviennent des commits orphelins et seront **automatiquement supprimés par git et sa collecte de déchets au bout d'un mois**.

## Création d'étiquettes (tag)
La commande `git tag` est utilisé pour créer des tags dans git. Les tags sont des références immuables qui pointent généralement vers des commits spécifiques dans l'historique d'un projet. Les tags sont souvent utilisés pour marquer des versions stables ou des points de repères importants dans le développement d'un projet.  
**Un tag ne peut pas contenir d'espacement**.

1. **Créer un tag léger**
```bash
git tag nom_du_tag [id-du-commit]
```
Cette commande crée un tag léger qui est simplement une référence à un commit spécifique. Si on ne précise pas de commit, il viendra se placer sur le commit actuel.

2. **Créer un tag complexe**
```bash
git tag -a nom_du_tag -m "Message de description optionnel" [id-du-commit]
```
Cette commande crée un tab annoté avec sa description optionnelle.

3. **Liste des tags**
```bash
git tag
```
Liste tous les tags présent dans le dépot git.

4. **Afficher les informations d'un tag**
```bash
git show nom_du_tag
```
Cette commande affiche les information sur un tag spécifique, y compris le commit sur lequel il pointe et le message de description s'il est annoté.

5. **Supprimer un tag**
```bash
git tag -d nom_du_tag
```

## Créations des branches!

Créer des branches dans git est un concept fondamental pour la gestion du code source et la collaboration au sein d'un projet. Les branches permettent aux devs de travailler sur des fonctionnalités, des correctifs ou des améliorations sans impacter le code principal.

- créer une nouvelle branche : Utiliser la commande `git branch` suivie de la branche. ex:
```bash
git branch nom-de-la-branche
```
- se déplacer vers une branche:
```bash
git checkout nom-de-la-branche
```
- créer et se déplacer sur une nouvelle branche:
```bash
git checkout -b nouvelle-branche
#Depuis git 2.23 on peut créer et se déplacer vers une nouvelle branche en une seule commande.
```
C'est une pratique déconseillée: `git switch` est une commande dédiée.  
En effet, `git checkout` est trop généraliste et peut se déplacer entre commits, et peut donc être source d'erreurs et peut faire des dégâts.
```bash
git switch <branche-cible>

git switch -c <nouvelle-branche-cible>
```

- si on souhaite modifier le nom d'une branche:
```bash
#!!! il faut au préalable se trouver sur la branche dont on souhaite modifier le nom
git branch -m <nouveau-nom>
```

- supprimer une branche:
```bash
git branch -d <nom-branche>
```
si la branche contient des commits, git demandera de remplacer `-d` par `-D` par sécurité.

- lister les branches:
```bash
git branch 
#hé oui!
```
- comparer les branches:
```bash
git diff branche1 branche2
```

## le gitignore

Le fichier .gitignore est utilisé pour spécifier des règles qui servent à ignorer certains fichiers ou répertoires lors des opérations Git, comme lors d'un git add ou git status par exemple. Il possède une syntaxe particulière.

**Pour ignorer un fichier ou un dossier spécifique** Pour ajouter un fichier ou un dossier particulier, il suffit d'y inscrire son chemin relatif au répertoire racine du projet git.

```pl
# Commenter une ligne de gitignore
monfichier.ext
mondossier/
mondossier/monfichier.txt
```
**Utiliser des paterns**
```pl
# tous les fichiers .txt :
*.txt
# tous les fichiers nommés "file1" :
file1.*

```
**\*** match n'importe quelle suite de caractère  
**\*\*** match n'importe quel nombre de répertoires  
**!** négation: inverse une règle précédemment établie du gitignore  
**?** matche un caractère unique.

```pl
# ignore tous les fichiers .txt
*.txt

# sauf my_file.txt
!my_file.txt

#ignore tout les jpg quelques soient leurs dossiers
**/*.jpg

# ignore un gif qui dont le nom est 4 caractères
????.gif
```

## Utiliser git en remote

Pour connecter un référentiel Git local à Github, vous devez suivre ces quelques étapes:

1. **Créer un compte github** (Duh!)

2. **Installer git** (Duh*2!)

3. **Configurer Git**  
```bash
    git config --global user.email "mail@mail.ml"
    git config --global user.name "MyName"
```
4. **Créer un nouveau référentiel sur GitHub**: se connecter sur github, cliquer sur le bouton + pour créer un nouveau repo (référentiel). Suivre les étapes pour le configurer selon les besoins du projet

5. **Cloner le référentiel github en local** : Pour cloner le référentiel, utiliser la commande
```bash
git clone <url_repo>
```

6. **Travailler sur le repo localement**

7. **valider et publier vos modifications** une fois que vous avez effectué les modifications que vous souhaitez envoyer.
```bash
git add .
git commit -m 'description'
git push origin main
```

8. consulter son referentiel sur githb.....

## **Envoyer son projet sur github sans gitclone**  
pour rattacher un referentiel distant à un dossier local sans utiliser `git clone`, on peut utiliser la commande `git remote` pour ajouter un repo distant et `git fetch` pour récupérer **les références** du dépot distant

1. créer un nouveau référentiel distant sur github si ce n'est déjà fait
2. dans un dossier local, initialiser un repo git
3. ajouter le référentiel distant en utilisant le `git remote add`
    ```bash
    git remote add [nom_perso_distant] [url_referentiel]
    ```
    remplacer `[nom_perso_disant]` par le nom que vous souhaitez (par exemple "origin") et récupérez l'url sur github.
    Si on fait une erreur, on peut supprimer un remote:
    ```bash
    git remote remove nom_du_remote
    ```
4. vérifier que le référentiel disant a ajouté avec succès
    ```bash
    git remote -v
    ```
    cela affichera les urls des référentiels distants que vous avez configurés
5. ** récupérer les référentiels du déput distant avec `git fetch`
    ```bash
    git fetch nom_distant
    ```
    cela récupèrera les informations sur les branches et les tags(?) du référentiel distant, mais ne fusionnera pas automatiquement les modifications dans votre branche locale.

6. Ensuite, pour travailler avec les modifications du référentiel distant, on peut créer une branche locale qui suit une branche distante avec `git checkout`
    ```bash
    git checkout -b nom_de_la branche_locale/branche_distante
    ``` 
    vous avez mantenant connecté un référentiel distant  a votre dossier local sans utiliser git clone

## git pull

```bash
git pull branche_distante branche_locale
#exemple
git pull origin main
#main ou branche locale
```
Lorsque l'on execute un git pull, ces étapes se succèdent:
1. git commence par executer une opération `git fetch` pour récupérer les modification depuis la branche distante spécifiée. Cela met a jour les références distantes dans le dépot local pour refletter l'état actuel du dépot distant, mais sans pour autant modifier la branche locale.

2. Fusion automatique:  après avoir récupéré les informations distantes, Git exécute automatiquement une opération de fusion (ou de `rebase` si on lui spécifie) pour intégrer les modifications dans la branche locale. Si git détecte des conflits entre les modifications distantes et locales, il vous demandera de résoudre manuellement avant de terminer la fusion.

3. Finalisation: Une fois que la fusion (ou le rebase) est réussie, votre branche locale est mise à jour avec les dernières modifications de la branche distante. Votre arborescence de travail reflète désormais l'état actuel de la branche distante.

## La fusion

Lorsque j'ai fini de travailler sur ma branche, je voudrais appliquer mon travail à la branche principale (main).  
Cette étape est possible grâce à la fusion de branche.
### Le merge
Le merge crée un nouveau commit de fusion (merge commit) qui combine les modifications de la branche source dans la branche de destination. Ce cillut de fusion a deux parents: la source et la destination.

Le merge préserve l'historique des commits de manière linéaire et montre clairement de quand et d'où proviennent les modifications

il est recommandé pour les collaborations où plusieurs contributeurs travaillent sur la même branche.

**Pour réaliser un merge, je me place dans la branche de destination**

```bash
git switch main

git merge feature1
```
le merge peut rencontrer deux cas de figure: avec ou sans fast-forward.

### le fast-forward (avance rapide)
Il s'agit d'une méthode de fusion particulière qui se produit lorsque git peut intégrer les modification d'une branche dans une autre sans créer de commit de fusion supplémentaire. Le fast forward est possible sous les conditions suivante:
- Il faut une branche de destination et une branche source
- la branche source contient des commits que la branche de destination n'a pas encore incorporé
- les commits de la branche source sont linéaire par rapport à la branche de destination, c'est à dire qu'ils s'ajoutent les uns après les autres dans l'ordre chronologique.

Cela donne l'apparence d'une fusion propre et linéaire dans l'historique des commits. Le fast-forward est souvent préféré lorsqu'il est possible, car il maintient la clarté sans créer des commits de merge supplémentaires. Cependant il n'est pas toujours applicable, en particulier lorsque des divergences importantes existent entre les branches à fusionner.  
Je peux forcer la non utilisation d'un ff (par exemple si je veux volontairement un merge commit) en ajoutant l'option `git merge <branche> --no-ff`

### Sans le fast-forward
Lorsque des divergeances existent entre les deux branches, je ne peux pas simplement 'coller' la branches sources à la branche de destination. Un commit de fusion ("merge commit") est donc créé. Ce commit de fusion héritera des deux branches et n'existera qu'au sein de la branche de destination.  
C'est dans cette configuration qu'un **conflit** peut apparaitre. En effet, si une même ligne est modifiée entre les deux parents, git devra faire un choix dans ce qu'il récupère. L'utilisateur devra résoudre le conflit.

VSCode utilise un outil graphique pour réparer les conflits, mais on peut aussi utiliser le `git mergetool` pour régler les conflits en CLI.  
Si ces conflits ne sont pas voulus,, je peux annuler le merge grâce à l'option
```bash
git merge --abort
```

## Le rebase

il existe une autre méthode pour fusionner : Le `rebase`.

Le rebase réapplique séquenciellement chaque commit de la branche source sur le dessus de la branche de destination. Il rejoue l'historique des commits, ce qui donne l'apparence de l'apparence d'une ligne de temps linéaire.

**Le rebase ne crée pas de commit de fusion supplémentaire**. Les commits originaux de la branche source sont réécris avec de nouvelles valeurs de hashage.
 - le rebase peut être utilisé pour garder l'historique des commits plus propre et linéaire, mais il peut réécrire l'historique des commits, ce qui peut causer des conflits si plusieurs contributeurs travaillent sur la même branche.
 - C'est une stratégie généralement recommandée pour les branches locales où l'on veut garder un historique propre et pour intégrer régulièrement des mises a jour sur la branche principale

**Attention:** Si je souhaite rebase une branche "feature" sur ma branche principale, je viendra me placer sur ma branche feature et j'utiliserai la commande :
```bash
git rebase main
```
S'il y a conflit, git vous demandera de les résoudre à mesure que chaque commit est réappliqué.

Par exemple, pour fusionner une branche de fonctionnalité (feature) sur une branche principale (main) :

1. S'assurer que l'on est sur la branch feature en utilisant un `git switch` ou `git checkout`:
    ```bash
    git switch feature
    ```

2. Effectuer le rebase de la branche feature sur la branche main en utilisant la commande git rebase :
    ```bash
    git rebase main
    ```
    Cela réappliquera séquentiellement les commits de la branche feature sur la branche main.

3. Après avoir résolu les conflits et terminé le rebase, on peut maintenant mettre à jour la branche main avec les modifications de la branche feature en utilisant une fusion rapide fast-forward
    ```bash
    git switch main
    git merge feature
    ```
    étant donné que l'on a déjà réappliqué les commits de la branche feature sur main lors du rebase, cette fusion devrait être un fast forward, ce qui signifie qu'aucun commit de fusion supplémentaire ne sera créé, et la branche main sera simplement mise à jour pour pointer le commits le plus récent de la branche feature.

## Conclusion: Quelle stratégie choisir?
Le choix entre un merge et un rebase dépend de la manière dont on souhaite gérer l'historique des commits et des besoins spécifiques du flux de travail.  
**Le merge** est généralement recommandé pour les collaborations, tandis que le **rebase** est utile pour maintenir un historique linéaire propre dans des branches locales.
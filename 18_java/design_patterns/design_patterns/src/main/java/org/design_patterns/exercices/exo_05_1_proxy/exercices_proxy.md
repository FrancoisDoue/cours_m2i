### Exercice 1 : Proxy de Contrôle d'Accès

Imaginez que vous développez un système pour une bibliothèque en ligne où certains livres sont accessibles uniquement aux utilisateurs qui ont un abonnement premium.
Vous allez utiliser le pattern Proxy pour contrôler l'accès à ces livres.

1. **Créez l'Interface `Book`** :
    - Méthode `readBook()` : affiche le contenu du livre.

2. **Implémentez `RealBook`** :
    - Classe qui implémente `Book`.
    - A un titre et un contenu (chaîne de caractères) passés au constructeur.
    - La méthode `readBook()` affiche simplement le contenu du livre.

3. **Implémentez `SecuredBookProxy`** :
    - Classe qui implémente également `Book`.
    - Contient une instance de `RealBook`.
    - Contrôle l'accès à la méthode `readBook()` de `RealBook` en fonction du statut d'abonnement de l'utilisateur (par exemple, un booléen `isUserPremium`).

4. **Créez une classe `Client` pour tester votre Proxy** :
    - Instanciez `SecuredBookProxy` avec différents états d'abonnement.
    - Essayez de lire le livre via le proxy pour voir si l'accès est contrôlé correctement.



### Exercice 2 : Proxy de journalisation
**Contexte :**
Vous êtes en charge de développer un système qui enregistre toutes les opérations effectuées sur les objets de type `Document`. Chaque fois qu'un document est lu ou modifié, le système doit enregistrer cette activité.

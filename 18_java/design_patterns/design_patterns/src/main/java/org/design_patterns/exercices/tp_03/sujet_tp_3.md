**Sujet de TP : Simulateur de Bourse en Temps Réel**

**Objectif :**
Concevoir une application qui simule le suivi en temps réel des fluctuations des cours de plusieurs actions en bourse, en permettant aux utilisateurs de s'abonner aux notifications de changements pour certaines actions spécifiques.

**Description :**
1. **Définition des classes** :
    - **Action** : Classe observable. Chaque action possède un nom, un prix actuel, et une liste d'observateurs. Elle peut modifier son prix de manière aléatoire et notifier ses observateurs lors de chaque changement.
    - **Investisseur** : Classe observateur. Peut s'abonner à des actions pour recevoir des mises à jour sur les changements de prix.

2. **Fonctionnement de l'application** :
    - Créez une liste d'actions avec des noms et des prix initiaux.
    - Permettez aux utilisateurs de créer des investisseurs et de les abonner à des actions spécifiques.
    - Implémentez un simulateur de marché qui ajuste périodiquement les prix des actions de manière aléatoire. Chaque fois qu'un prix est ajusté, les investisseurs abonnés reçoivent une notification.

3. **Interface utilisateur** :
    - Une interface simple affichant la liste des actions disponibles et leur prix actuel.
    - Une fonctionnalité pour ajouter des investisseurs et gérer leurs abonnements.
    - Des notifications en temps réel affichant les mises à jour des prix auxquels l'investisseur est abonné.
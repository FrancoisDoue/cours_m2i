### Sujet de TP : Développement d'une application de configuration de produits personnalisés

#### Contexte
Vous êtes chargé de développer une application pour une entreprise qui vend des produits personnalisables, comme des ordinateurs, des vélos, ou des smartphones. Chaque produit peut être hautement personnalisé avec différentes options et composants. L'objectif est de permettre aux clients de configurer facilement leur produit idéal via une interface utilisateur intuitive.

#### Objectif du TP
Développer une partie du système de l'application qui permet aux utilisateurs de construire et de personnaliser leur produit. Ce système doit être flexible pour permettre l'ajout futur de nouveaux types de produits et d'options de personnalisation.

#### Fonctionnalités à Implémenter

1. **Construction de Produits :**
    - Les utilisateurs doivent pouvoir choisir parmi différents types de produits (ordinateurs, vélos, smartphones).
    - Chaque produit a des options de personnalisation comme les composants (processeur, mémoire, type de roue, etc.) et les couleurs.

2. **Utilisation du Pattern Builder :**
    - Implémenter des builders spécifiques pour chaque type de produit afin de gérer la complexité de la création des produits personnalisés.

3. **Utilisation de l'Abstract Factory :**
    - Développer des factories pour chaque catégorie de produit qui utilisent les builders pour créer des instances de produits.

4. **Interface Utilisateur pour la Configuration :**
    - Créer une interface utilisateur simple permettant aux utilisateurs de sélectionner les options désirées et de voir le produit final se construire étape par étape.
### Exercice : Gestion Optimisée de Véhicules pour une Compagnie de Location

**Contexte :**
Une compagnie de location de véhicules dispose d'une flotte comprenant plusieurs types de véhicules (voitures, camions, vélos, etc.), chacun disponible en différentes variantes (modèles, couleurs, etc.).
La compagnie souhaite optimiser la gestion de cette flotte en réduisant la quantité de mémoire utilisée pour gérer les informations sur les véhicules.

**Problème :**
Actuellement, chaque véhicule est représenté par une instance séparée, même lorsque plusieurs véhicules partagent des caractéristiques communes, telles que le modèle, la marque, ou la couleur.
Cela conduit à une utilisation excessive de la mémoire.

**Objectif :**
Implémenter le pattern Flyweight pour partager les données communes des véhicules afin de minimiser l'utilisation de la mémoire.


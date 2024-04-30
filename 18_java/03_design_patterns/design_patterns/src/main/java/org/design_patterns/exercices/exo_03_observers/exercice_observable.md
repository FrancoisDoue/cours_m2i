### Exercice

#### Sujet : Système de Suivi de Stock

Vous êtes chargé de créer un système de suivi de stock pour une entreprise. L'entreprise souhaite être notifiée chaque fois que le niveau de stock d'un produit change.

**Objectifs :**
1. **Implémenter le Pattern Observer :**
    - Créer une classe `Product` avec une propriété `stockLevel`.
    - Lorsque `stockLevel` change, tous les observateurs enregistrés doivent être notifiés.

2. **Créer des Observateurs :**
    - Implémenter des observateurs comme `StockManager` et `Supplier` qui seront notifiés des changements de stock.

3. **Test :**
    - Créer une instance de `Product` et plusieurs observateurs.
    - Modifier le `stockLevel` et observer la notification des changements.
### Exercice : Système de Gestion de Commandes de Restauration

**Contexte :**
Vous êtes chargé de développer un système pour une chaîne de restauration qui sert différentes cuisines, telles que la cuisine italienne, japonaise et mexicaine. Chaque type de cuisine nécessite un ensemble spécifique de processus et d'ingrédients pour préparer ses plats emblématiques.

**Objectif :**
Implémenter un design pattern Abstract Factory pour gérer la création de divers ensembles d'objets relatifs à la préparation de différents types de cuisines.

**Instructions :**

1. **Interfaces de Produit Abstrait :**
    - Créez des classes abstraites pour différents types d'objets, tels que `Ingredient`, `CookingUtensil`, et `Dish`.
    - Chaque classe abstraite doit définir des méthodes pertinentes pour son type. Par exemple, `prepare()` pour `Ingredient`, `use()` pour `CookingUtensil`, et `serve()` pour `Dish`.

2. **Produits Concrets :**
    - Implémentez des classes concrètes pour chaque type d'objet et chaque cuisine. Par exemple, `ItalianIngredient`, `JapaneseIngredient`, `MexicanIngredient`, `ItalianUtensil`, etc.

3. **Abstract Factory :**
    - Créez une abstract class `CuisineFactory` avec des méthodes pour créer chaque type d'objet (`createIngredient()`, `createUtensil()`, et `createDish()`).

4. **Factories Concrètes :**
    - Créez des classes concrètes `ItalianCuisineFactory`, `JapaneseCuisineFactory`, et `MexicanCuisineFactory` qui implémentent `CuisineFactory`.

5. **Client :**
    - Écrivez une classe `Restaurant` qui utilise une `CuisineFactory` pour préparer un ensemble de plats. Cette classe doit pouvoir changer de factory selon le type de cuisine demandée par le client.

6. **Test :**
    - Dans votre méthode `main`, testez votre code en préparant un ensemble de plats pour chaque type de cuisine en utilisant les factories correspondantes.

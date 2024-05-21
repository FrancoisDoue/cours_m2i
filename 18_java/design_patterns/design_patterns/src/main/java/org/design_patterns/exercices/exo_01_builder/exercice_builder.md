### Exercice : Construire un Système de Configuration de Commande de Pizza

**Objectif :** Utiliser le pattern Builder pour créer un système flexible de configuration de commandes de pizza.

**Contexte :**
- Vous gérez une pizzeria et souhaitez offrir à vos clients la possibilité de personnaliser leurs pizzas.
- Les options de personnalisation incluent : taille, type de pâte, fromage, garnitures (viandes, légumes), et sauce.

**Tâches :**

1. **Définir la Classe Pizza**
    - Créez une classe `Pizza` avec les attributs suivants :
        - Taille (petite, moyenne, grande)
        - Type de pâte (classique, fine, épaisse)
        - Fromage (mozzarella, cheddar, sans fromage)
        - Liste de garnitures (jambon, pepperoni, champignons, poivrons, etc.)
        - Type de sauce (tomate, crème, barbecue)
    - Ajoutez un constructeur privé qui accepte un objet `Builder`.

2. **Créer la Classe Builder Interne**
    - Dans la classe `Pizza`, créez une classe statique `Builder`.
    - Ajoutez des méthodes pour configurer chaque attribut (par exemple, `taille`, `typeDePate`, `ajouterGarniture`, etc.).
    - Ajoutez une méthode `build()` qui retourne un nouvel objet `Pizza`.

3. **Implémenter la Logique de Construction**
    - Dans la méthode `build()`, implémentez la logique pour construire l'objet `Pizza` en utilisant les valeurs configurées dans le `Builder`.

4. **Tester votre Code**
    - Écrivez un exemple de code qui crée une pizza en utilisant le `Builder`, par exemple, une pizza moyenne avec une pâte fine, du fromage mozzarella, du jambon, des champignons et une sauce tomate.

5. **Bonus : Validation**
    - Ajoutez de la logique dans le `Builder` ou dans le constructeur de `Pizza` pour valider les combinaisons d'ingrédients (par exemple, empêcher la sélection de plusieurs types de fromage).
package org.tp_recipes.IHM.impl;

import org.tp_recipes.DAO.impl.IngredientDAO;
import org.tp_recipes.DAO.impl.IngredientRecipeDAO;
import org.tp_recipes.DAO.impl.RecipeDAO;
import org.tp_recipes.IHM.AbstractIHM;
import org.tp_recipes.entity.Category;
import org.tp_recipes.entity.Ingredient;
import org.tp_recipes.entity.Recipe;
import org.tp_recipes.entity.Step;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class RecipeIHM extends AbstractIHM {
    private static RecipeIHM INSTANCE;
    private final RecipeDAO recipeDAO;
    private final IngredientDAO ingredientDAO;

    private RecipeIHM() throws SQLException {
        recipeDAO = new RecipeDAO();
        ingredientDAO = new IngredientDAO();
    }

    public static synchronized RecipeIHM getInstance() throws SQLException {
        if (INSTANCE == null) INSTANCE = new RecipeIHM();
        return INSTANCE;
    }

    public void start() throws SQLException {
        while (true) {
            System.out.println("""
                    - - - Recettes - - -
                    1. Afficher Toutes les recettes
                    2. Afficher les recettes par Catégorie
                    3. Ajouter une recette
                    """
            );
            switch (intInput(3)) {
                case 1 -> showRecipes();
                case 3 -> createRecipe();
                default -> {
                    return;
                }
            }
        }
    }

    public void showRecipes() throws SQLException {
        StringBuilder recipesString = new StringBuilder();
        recipeDAO.getAll().forEach(r -> recipesString.append(r).append('\n'));
        System.out.println(recipesString);
    }

    public void createRecipe() throws SQLException {
        CategoryIHM categoryIHM = CategoryIHM.getInstance();
        do {
            categoryIHM.showCategories();
            System.out.println("Sélectionnez une catégorie");
            try {
                Category category = categoryIHM.getCategoryDAO().get(intInput());
                System.out.println("Catégorie sélectionnée : " + category);
                System.out.println("Nom de la recette");
                String title = stringInputNotEmpty();
                System.out.println("Temps de préparation (en minutes)");
                int preparationTime = intInput();
                System.out.println("Temps de cuisson (en minutes)");
                int cookingTime = intInput();
                System.out.println("""
                        Sélecionnez la difficulté :
                        [1] Facile | [2] Moyen | [3] Difficile"""
                );
                int difficulty = intInput(3);
                List<Ingredient> ingredients = new ArrayList<>();
                List<Step> steps = new ArrayList<>();
                while (true) {
                    IngredientIHM.getInstance().showIngredients();
                    System.out.println("Sélectionnez un ingrédient");
                    int ingredientId = intInput();
                    try {
                        Ingredient ingredient = ingredientDAO.get(ingredientId);
                        if (ingredient == null) throw new RuntimeException("Ingredient introuvable");
                        System.out.println(ingredient);
                        System.out.println("Quelle quantité ?");
                        ingredient.setQuantity(intInput());
                        ingredients.add(ingredient);
                        System.out.println("Ajouter un autre ingrédient? [y]|[n]");
                        if (stringInput().equalsIgnoreCase("n")) break;
                    } catch (RuntimeException e) {
                        System.out.println(e.getMessage());
                    }
                }
                int i = 1;
                while (true) {
                    System.out.println("Etape n°"+i + " : ");
                    steps.add(Step.builder().description(stringInputNotEmpty()).build());
                    System.out.println("Ajouter une autre étape ? [y]|[n]");
                    if(stringInput().equalsIgnoreCase("n")) break;
                    i++;
                }
                Recipe recipe = recipeDAO.save(
                        Recipe.builder()
                                .title(title)
                                .preparationTime(preparationTime)
                                .cookingTime(cookingTime)
                                .difficulty(difficulty)
                                .category(category)
                                .ingredients(ingredients)
                                .steps(steps)
                                .build()
                );
                System.out.println("Recette créée => " + recipe);
                return;
            } catch (InputMismatchException e) {
                System.out.println("Saisie invalide");
            }
        } while (true);
    }
}

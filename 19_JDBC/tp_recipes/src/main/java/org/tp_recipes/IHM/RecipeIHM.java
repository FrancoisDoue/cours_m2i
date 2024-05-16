package org.tp_recipes.IHM;

import org.tp_recipes.DAO.impl.RecipeDAO;
import org.tp_recipes.entity.Category;
import org.tp_recipes.entity.Recipe;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class RecipeIHM {
    private static RecipeIHM INSTANCE;
    private final RecipeDAO recipeDAO;
    private final Scanner sc;

    private RecipeIHM() throws SQLException {
        recipeDAO = new RecipeDAO();
        sc = new Scanner(System.in);
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
            int entry = sc.nextInt();
            sc.nextLine();
            switch (entry) {
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
                Category category = categoryIHM.getCategoryDAO().get(sc.nextInt());
                sc.nextLine();
                System.out.println("Catégorie sélectionnée : " + category);
                System.out.println("Nom de la recette");
                String title = sc.nextLine();
                System.out.println("Temps de préparation (en minutes)");
                int preparationTime = sc.nextInt();
                sc.nextLine();
                System.out.println("Temps de cuisson (en minutes)");
                int cookingTime = sc.nextInt();
                sc.nextLine();
                System.out.println("""
                        Sélecionnez la difficulté :
                        [1] Facile | [2] Moyen | [3] Difficile"""
                );
                int difficulty = sc.nextInt();
                sc.nextLine();
                Recipe recipe = recipeDAO.save(
                        Recipe.builder()
                                .title(title)
                                .preparationTime(preparationTime)
                                .cookingTime(cookingTime)
                                .difficulty(difficulty)
                                .category(category)
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

package org.tp_recipes.IHM;

import org.tp_recipes.DAO.impl.IngredientDAO;
import org.tp_recipes.entity.Ingredient;

import java.sql.SQLException;
import java.util.Scanner;

public class IngredientIHM {
    private static IngredientIHM INSTANCE;
    private final IngredientDAO ingredientDAO;
    private final Scanner sc;

    private IngredientIHM() throws SQLException {
        ingredientDAO = new IngredientDAO();
        sc = new Scanner(System.in);
    }

    public static synchronized IngredientIHM getInstance() throws SQLException {
        if (INSTANCE == null) INSTANCE = new IngredientIHM();
        return INSTANCE;
    }

    public void start() throws SQLException {
        while (true) {
            System.out.println("""
                    - - - INGREDIENTS - - -
                    1. Afficher les ingrédients
                    2. Ajouter un ingredient
                    """
            );
            int entry = sc.nextInt();
            sc.nextLine();
            switch (entry) {
                case 1 -> showIngredients();
                case 2 -> addIngredient();
                default -> {
                    return;
                }
            }
        }
    }

    public void showIngredients() throws SQLException {
        StringBuilder ingredientsString = new StringBuilder();
        ingredientDAO.getAll().forEach(i -> ingredientsString.append(i).append('\n'));
        System.out.println(ingredientsString);
    }

    public void addIngredient() throws SQLException {
        do {
            System.out.println("""
                    - - - Ajouter un ingredient - - -
                    Nom de l'ingrédient :"""
            );
            String ingredientName = sc.nextLine();
            Ingredient i = ingredientDAO.save(
                    Ingredient.builder().name(ingredientName).build()
            );
            System.out.println("Ingrédient ajouté => " + i);
            System.out.println("Ajouter un autre ingrédient? [y] | [n]");
        } while (sc.nextLine().equalsIgnoreCase("y"));
    }

}

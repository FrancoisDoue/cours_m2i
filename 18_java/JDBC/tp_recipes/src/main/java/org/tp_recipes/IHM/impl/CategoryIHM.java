package org.tp_recipes.IHM.impl;

import lombok.Getter;
import org.tp_recipes.DAO.impl.CategoryDAO;
import org.tp_recipes.IHM.AbstractIHM;
import org.tp_recipes.entity.Category;

import java.sql.SQLException;

@Getter
public class CategoryIHM extends AbstractIHM {
    private static CategoryIHM INSTANCE;
    private final CategoryDAO categoryDAO;

    private CategoryIHM() throws SQLException {
        categoryDAO = new CategoryDAO();
    }

    public static synchronized CategoryIHM getInstance() throws SQLException {
        if (INSTANCE == null) INSTANCE = new CategoryIHM();
        return INSTANCE;
    }

    public void start() throws SQLException {
        while (true) {
            System.out.println("""
                    - - - CATEGORIES - - -
                    1. Afficher les catégories
                    2. Ajouter une catégorie
                    """
            );
            switch (this.intInput(2)) {
                case 1 -> showCategories();
                case 2 -> addCategory();
                default -> {
                    return;
                }
            }
        }
    }

    public void showCategories() throws SQLException {
        StringBuilder ingredientsString = new StringBuilder();
        categoryDAO.getAll().forEach(i -> ingredientsString
                .append('[').append(i.getId()).append(']').append(i).append('\n')
        );
        System.out.println(ingredientsString);
    }


    public void addCategory() throws SQLException {
        do {
            System.out.println("""
                    - - - Ajouter une catégorie - - -
                    Intitulé de la catégorie :"""
            );
            Category i = categoryDAO.save(
                    Category.builder().title(stringInputNotEmpty()).build()
            );
            System.out.println("Ingrédient ajouté => " + i);
            System.out.println("Ajouter un autre ingrédient? [y] | [n]");
        } while (stringInputNotEmpty().equalsIgnoreCase("y"));
    }
}

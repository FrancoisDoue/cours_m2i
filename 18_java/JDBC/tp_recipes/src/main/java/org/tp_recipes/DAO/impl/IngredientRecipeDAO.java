package org.tp_recipes.DAO.impl;

import org.tp_recipes.DAO.AbstractDAO;
import org.tp_recipes.entity.Ingredient;
import org.tp_recipes.entity.IngredientRecipe;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class IngredientRecipeDAO extends AbstractDAO<IngredientRecipe> {

    public IngredientRecipeDAO() throws SQLException {
    }

    @Override
    public IngredientRecipe save(IngredientRecipe element) throws SQLException {
        try {
            connect();
            statement = connection.prepareStatement("""
                    INSERT INTO ingredients_recipe (id_ingredient, id_recipe, quantity)
                    VALUES (?, ?, ?)""",
                    Statement.RETURN_GENERATED_KEYS
            );
            statement.setInt(1, element.getIdIngredient());
            statement.setInt(2, element.getIdRecipe());
            statement.setInt(3, element.getQuantity());
            if (statement.executeUpdate() != 1) {
                throw new SQLException();
            }
            resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
               element.setId(resultSet.getInt(1));
            }
            connection.commit();
            return element;
        } catch (SQLException e) {
            connection.rollback();
            return null;
        } finally {
            close();
        }
    }

    public void saveMultiple(List<IngredientRecipe> ingredientRecipe) throws SQLException {
        try {
            connect();
            statement = connection.prepareStatement("""
                    INSERT INTO ingredients_recipe (id_ingredient, id_recipes, quantity)
                    VALUES (?, ?, ?)"""
            );
            ingredientRecipe.forEach(ir -> {
                try {
                    statement.setInt(1, ir.getIdIngredient());
                    statement.setInt(2, ir.getIdRecipe());
                    statement.setInt(3, ir.getQuantity());
                    statement.addBatch();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            });
            statement.executeBatch();
            connection.commit();
        } catch (SQLException | RuntimeException e) {
            connection.rollback();
        } finally {
            close();
        }
    }

    @Override
    public IngredientRecipe update(IngredientRecipe element) throws SQLException {
        return null;
    }

    @Override
    public boolean delete(IngredientRecipe element) throws SQLException {
        return false;
    }

    @Override
    public IngredientRecipe get(int id) throws SQLException {
        return null;
    }

    public List<Ingredient> getAllIngredientByIdRecipe(int id) throws SQLException {
        List<Ingredient> ingredients = new ArrayList<>();
        connect();
        statement = connection.prepareStatement("""
                SELECT *, ir.quantity FROM ingredient
                INNER JOIN ingredients_recipe AS ir
                ON ir.id_ingredient = ingredient.id
                WHERE ir.id_recipes = ?"""
        );
        statement.setInt(1, id);
        resultSet = statement.executeQuery();
        while (resultSet.next()) {
            ingredients.add(
                    Ingredient.builder()
                            .id(resultSet.getInt("id"))
                            .name(resultSet.getString("name"))
                            .quantity(resultSet.getInt("quantity"))
                            .build()
            );
        }
        close();
        return ingredients;
    }

    @Override
    public List<IngredientRecipe> getAll() throws SQLException {
        return List.of();
    }
}

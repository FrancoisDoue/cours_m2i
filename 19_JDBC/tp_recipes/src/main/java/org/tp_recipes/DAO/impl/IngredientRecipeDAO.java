package org.tp_recipes.DAO.impl;

import org.tp_recipes.DAO.AbstractDAO;
import org.tp_recipes.entity.IngredientRecipe;

import java.sql.SQLException;
import java.sql.Statement;
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

    public List<IngredientRecipe> saveMultiple(List<IngredientRecipe> ingredientRecipe) throws SQLException {
        try {
            connect();
            statement = connection.prepareStatement("""
                    INSERT INTO ingredients_recipe (id_ingredient, id_recipe, quantity)
                    VALUES (?, ?, ?)""",
                    Statement.RETURN_GENERATED_KEYS
            );
            ingredientRecipe.forEach(er -> {
                try {
                    statement.setInt(1, er.getIdIngredient());
                    statement.setInt(2, er.getIdRecipe());
                    statement.setInt(3, er.getQuantity());
                    statement.addBatch();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            });
            statement.executeBatch();
            resultSet = statement.getGeneratedKeys();
            ingredientRecipe.forEach(ir -> {

            });

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return List.of();
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

    @Override
    public List<IngredientRecipe> getAll() throws SQLException {
        return List.of();
    }
}

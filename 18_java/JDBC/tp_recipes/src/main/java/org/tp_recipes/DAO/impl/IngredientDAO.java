package org.tp_recipes.DAO.impl;

import org.tp_recipes.DAO.AbstractDAO;
import org.tp_recipes.entity.Ingredient;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class IngredientDAO extends AbstractDAO<Ingredient> {

    public IngredientDAO() throws SQLException {}

    @Override
    public Ingredient save(Ingredient element) throws SQLException {
        try {
            connect();
            statement = connection.prepareStatement("""
                    INSERT INTO ingredient (name)
                    VALUES (?);
                    """,
                    Statement.RETURN_GENERATED_KEYS
            );
            statement.setString(1, element.getName());
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

    @Override
    public Ingredient update(Ingredient element) throws SQLException {
        return null;
    }

    @Override
    public boolean delete(Ingredient element) throws SQLException {
        return false;
    }

    @Override
    public Ingredient get(int id) throws SQLException {
        connect();
        statement = connection.prepareStatement(" SELECT * FROM ingredient WHERE id=?;");
        statement.setInt(1, id);
        resultSet = statement.executeQuery();
        if (resultSet.next()) {
            return Ingredient.builder()
                    .id(resultSet.getInt("id"))
                    .name(resultSet.getString("name"))
                    .build();
        }
        return null;
    }

    @Override
    public List<Ingredient> getAll() throws SQLException {
        List<Ingredient> ingredients = new ArrayList<>();
        connect();
        statement = connection.prepareStatement("SELECT * FROM ingredient");
        resultSet = statement.executeQuery();
        while (resultSet.next()) {
            ingredients.add(
                    Ingredient.builder()
                            .id(resultSet.getInt("id"))
                            .name(resultSet.getString("name"))
                            .build()
            );
        }
        close();
        return ingredients;
    }

}

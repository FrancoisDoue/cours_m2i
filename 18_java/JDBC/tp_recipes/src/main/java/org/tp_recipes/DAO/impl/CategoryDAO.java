package org.tp_recipes.DAO.impl;

import org.tp_recipes.DAO.AbstractDAO;
import org.tp_recipes.entity.Category;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO extends AbstractDAO<Category> {

    public CategoryDAO() throws SQLException {
    }

    @Override
    public Category save(Category element) throws SQLException {
        try {
            connect();
            statement = connection.prepareStatement("""
                    INSERT INTO category (title)
                    VALUES (?);
                    """,
                    Statement.RETURN_GENERATED_KEYS
            );
            statement.setString(1, element.getTitle());
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
    public Category update(Category element) throws SQLException {
        return null;
    }

    @Override
    public boolean delete(Category element) throws SQLException {
        return false;
    }

    @Override
    public Category get(int id) throws SQLException {
        connect();
        statement = connection.prepareStatement("SELECT * FROM category WHERE id = ?");
        statement.setInt(1, id);
        resultSet = statement.executeQuery();
        if (resultSet.next()) {
            return Category.builder()
                    .id(resultSet.getInt("id"))
                    .title(resultSet.getString("title"))
                    .build();
        }
        return null;
    }

    @Override
    public List<Category> getAll() throws SQLException {
        List<Category> categories = new ArrayList<>();
        connect();
        statement = connection.prepareStatement("SELECT * FROM category");
        resultSet = statement.executeQuery();
        while (resultSet.next()) {
            categories.add(
                    Category.builder()
                            .id(resultSet.getInt("id"))
                            .title(resultSet.getString("title"))
                            .build()
            );
        }
        return categories;
    }
}

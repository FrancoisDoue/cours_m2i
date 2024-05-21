package org.tp_recipes.DAO.impl;

import org.tp_recipes.DAO.AbstractDAO;
import org.tp_recipes.entity.Step;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StepDAO extends AbstractDAO<Step> {

    public StepDAO() throws SQLException {
    }

    @Override
    public Step save(Step element) throws SQLException {
        try {
            connect();
            statement = connection.prepareStatement("""
                    INSERT INTO step (description, id_recipe)
                    VALUES (?, ?)""",
                    Statement.RETURN_GENERATED_KEYS
            );
            statement.setString(1, element.getDescription());
            statement.setInt(2, element.getIdRecipe());
            if (statement.executeUpdate() != 0) throw new SQLException();
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

    public void saveMultiple(List<Step> steps) throws SQLException {
        try {
            connect();
            statement = connection.prepareStatement("""
                    INSERT INTO step (description, id_recipe)
                    VALUES (?, ?)"""
            );
            for (Step step : steps) {
                statement.setString(1, step.getDescription());
                statement.setInt(2, step.getIdRecipe());
                statement.addBatch();
            }
            statement.executeBatch();
            connection.commit();
        } catch (SQLException e) {
            connection.rollback();
        } finally {
            close();
        }
    }

    @Override
    public Step update(Step element) throws SQLException {
        return null;
    }

    @Override
    public boolean delete(Step element) throws SQLException {
        return false;
    }

    @Override
    public Step get(int id) throws SQLException {
        return null;
    }

    public List<Step> getAllByIdRecipe(int id) throws SQLException {
        List<Step> steps = new ArrayList<Step>();
        connect();
        statement = connection.prepareStatement("SELECT * FROM step WHERE id_recipe = ?");
        statement.setInt(1, id);
        resultSet = statement.executeQuery();
        while (resultSet.next()) {
            steps.add(
                    Step.builder()
                            .id(resultSet.getInt("id"))
                            .description(resultSet.getString("description"))
                            .idRecipe(resultSet.getInt("id_recipe"))
                            .build()
            );
        }
        return steps;
    }

    @Override
    public List<Step> getAll() throws SQLException {
        return List.of();
    }
}

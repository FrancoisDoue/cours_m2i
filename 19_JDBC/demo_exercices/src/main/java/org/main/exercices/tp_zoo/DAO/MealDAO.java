package org.main.exercices.tp_zoo.DAO;

import org.main.exercices.tp_zoo.entity.Meal;
import org.main.exercices.tp_zoo.utils.DataBaseManager;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class MealDAO extends AbstractDAO<Meal>{

    public MealDAO(Connection connection) {
        super(connection);
    }

    @Override
    public Meal save(Meal meal) throws SQLException {
        try {
            connection = DataBaseManager.getConnection();
            statement = connection.prepareStatement("""
                    INSERT INTO MEAL (description, idAnimal)
                    VALUES (?, ?);
                    """,
                    Statement.RETURN_GENERATED_KEYS
            );
            statement.setString(1, meal.getDescription());
            statement.setInt(2, meal.getAnimal().getIdAnimal());
            statement.executeUpdate();
            resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                meal.setIdMeal(resultSet.getInt(1));
            }
            connection.commit();
            return meal;
        } catch (SQLException e) {
            connection.rollback();
            throw e;
        } finally {
            close();
        }
    }

    @Override
    public Meal update(Meal meal) throws SQLException {
        return null;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return false;
    }

    @Override
    public Meal get(int id) throws SQLException {
        return null;
    }

    @Override
    public List<Meal> getAll() throws SQLException {
        return List.of();
    }
}

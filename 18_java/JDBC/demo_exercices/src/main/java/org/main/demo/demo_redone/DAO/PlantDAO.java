package org.main.demo.demo_redone.DAO;

import org.main.demo.demo_redone.entity.Plant;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class PlantDAO extends AbstractDAO<Plant> {

    public PlantDAO(Connection connection) {
        super(connection);
    }

    @Override
    public Plant save(Plant plant) throws SQLException {
        try {
            statement = connection.prepareStatement("""
                    INSERT INTO plant (name, color, age)
                    VALUES (?, ?, ?)
                """, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, plant.getName());
            statement.setString(2, plant.getColor());
            statement.setInt(3, plant.getAge());
            statement.executeUpdate();
            resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                plant.setIdPlant(resultSet.getInt("id"));
                connection.commit();
            }
        } catch (SQLException e) {
            connection.rollback();
            return null;
        } finally {
            close();
        }
        return plant;
    }

    @Override
    public Plant update(Plant plant) throws SQLException {
        return null;
    }

    @Override
    public boolean delete(Plant plant) throws SQLException {
        return false;
    }

    @Override
    public List<Plant> getAll() throws SQLException {
        return List.of();
    }

    @Override
    public Plant getById(int id) throws SQLException {
        statement = connection.prepareStatement("""
            SELECT * FROM plant
            WHERE id = ?
            """);
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        close();
        if (resultSet.next()) {
            return Plant.builder()
                    .idPlant(resultSet.getInt("id"))
                    .name(resultSet.getString("name"))
                    .color(resultSet.getString("color"))
                    .age(resultSet.getInt("age"))
                    .build();
        }
        return null;
    }
}

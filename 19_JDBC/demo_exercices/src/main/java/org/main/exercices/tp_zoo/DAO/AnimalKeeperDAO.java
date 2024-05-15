package org.main.exercices.tp_zoo.DAO;

import org.main.exercices.tp_zoo.entity.Animal;
import org.main.exercices.tp_zoo.entity.AnimalKeeper;
import org.main.exercices.tp_zoo.utils.DataBaseManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class AnimalKeeperDAO extends AbstractManyToManyDAO<AnimalKeeper, Animal> {

    protected AnimalKeeperDAO(Connection connection) {
        super(connection);
    }

    @Override
    public AnimalKeeper save(AnimalKeeper animalKeeper) throws SQLException {
        try {
            connection = DataBaseManager.getConnection();
            statement = connection.prepareStatement(
                    "INSERT INTO animal_keeper (name) VALUES (?)",
                    Statement.RETURN_GENERATED_KEYS
            );
            statement.setString(1, animalKeeper.getName());
            if (statement.executeUpdate() != 1) {
                throw new SQLException();
            }
            resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                animalKeeper.setId(resultSet.getInt(1));
            }
            connection.commit();
            return animalKeeper;
        } catch (SQLException e) {
            connection.rollback();
            return null;
        } finally {
            close();
        }
    }

    @Override
    public AnimalKeeper update(AnimalKeeper animalKeeper) throws SQLException {
        return null;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return false;
    }

    @Override
    public AnimalKeeper get(int id) throws SQLException {
        statement = connection.prepareStatement("SELECT * FROM animal_keeper WHERE id = ?");
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            return AnimalKeeper.builder()
                    .id(resultSet.getInt("id"))
                    .name(resultSet.getString("name"))
                    .build();
        }
        return null;
    }

    @Override
    public List<AnimalKeeper> getAll() throws SQLException {
        return List.of();
    }

    @Override
    protected Animal add(Animal animal) throws SQLException {
        return null;
    }

    @Override
    protected boolean remove(int id) throws SQLException {
        return false;
    }

    @Override
    protected Animal select(int id) throws SQLException {
        return null;
    }

    @Override
    protected List<Animal> selectAll() throws SQLException {
        return List.of();
    }

}

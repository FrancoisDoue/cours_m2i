package org.main.exercices.tp_zoo.DAO;

import org.main.exercices.tp_zoo.entity.AnimalKeeper;
import org.main.exercices.tp_zoo.utils.DataBaseManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class AnimalKeeperDAO extends AbstractDAO<AnimalKeeper> {

    private final AnimalAnimalKeeperDAO animalAnimalKeeperDAO;

    protected AnimalKeeperDAO(Connection connection) {
        super(connection);
        this.animalAnimalKeeperDAO = new AnimalAnimalKeeperDAO(connection);
    }

    public AnimalKeeper setAnimalsList(AnimalKeeper animalKeeper) throws SQLException {
        animalKeeper.setAnimals(
                animalAnimalKeeperDAO.getAnimalByKeeper(animalKeeper.getId())
        );
        return animalKeeper;
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
        connection = DataBaseManager.getConnection();
        statement = connection.prepareStatement("SELECT * FROM animal_keeper WHERE id = ?");
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            AnimalKeeper keeper = AnimalKeeper.builder()
                    .id(resultSet.getInt("id"))
                    .name(resultSet.getString("name"))
                    .build();
            this.setAnimalsList(keeper);
            return keeper;
        }
        return null;
    }

    @Override
    public List<AnimalKeeper> getAll() throws SQLException {
        return List.of();
    }

}

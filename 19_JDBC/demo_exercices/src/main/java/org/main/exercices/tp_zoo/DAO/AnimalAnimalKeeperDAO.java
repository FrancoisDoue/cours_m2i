package org.main.exercices.tp_zoo.DAO;

import org.main.exercices.tp_zoo.entity.Animal;
import org.main.exercices.tp_zoo.entity.AnimalAnimalKeeper;
import org.main.exercices.tp_zoo.entity.AnimalKeeper;
import org.main.exercices.tp_zoo.utils.DataBaseManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AnimalAnimalKeeperDAO extends AbstractDAO<AnimalAnimalKeeper> {

    protected AnimalAnimalKeeperDAO(Connection connection) {
        super(connection);
    }

    @Override
    public AnimalAnimalKeeper save(AnimalAnimalKeeper animalAnimalKeeper) throws SQLException {
        try {
            connection = DataBaseManager.getConnection();
            statement = connection.prepareStatement("""
                    INSERT INTO animal__animal_keeper (idAnimal, idAnimalKeeper)
                    VALUES (?, ?)""",
                    Statement.RETURN_GENERATED_KEYS
            );
            statement.setInt(1, animalAnimalKeeper.getIdAnimal());
            statement.setInt(2, animalAnimalKeeper.getIdAnimalKeeper());
            if (statement.executeUpdate() !=1 ) {
                throw new SQLException();
            }
            resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                animalAnimalKeeper.setId(resultSet.getInt(1));
            }
            connection.commit();
            return animalAnimalKeeper;
        } catch (SQLException e) {
            connection.rollback();
            return null;
        } finally {
            close();
        }
    }

    public List<Animal> getAnimalByKeeper(int idKeeper) throws SQLException {
        List<Animal> animals = new ArrayList<>();
        connection = DataBaseManager.getConnection();
        statement = connection.prepareStatement("""
            SELECT * FROM Animal as a
            INNER JOIN animal_animal_keeper as aak
            WHERE aak.idAnimalKeeper = ?"""
        );
        statement.setInt(1, idKeeper);
        resultSet = statement.executeQuery();
        while (resultSet.next()) {
            animals.add(
                Animal.builder()
                    .idAnimal(resultSet.getInt("id"))
                    .age(resultSet.getInt("age"))
                    .name(resultSet.getString("name"))
                    .specie(resultSet.getString("specie"))
                    .location(resultSet.getString("location"))
                    .description(resultSet.getString("description"))
                    .build()
            );
        }
        close();
        return animals;
    }

    public List<AnimalKeeper> getKeeperByAnimal(int idAnimal) throws SQLException {
        List<AnimalKeeper> animalKeepers = new ArrayList<>();
        connection = DataBaseManager.getConnection();
        statement = connection.prepareStatement("""
            SELECT * FROM animal_keeper as ak
            INNER JOIN animal_animal_keeper as aak
            WHERE aak.idAnimal = ?"""
        );
        statement.setInt(1, idAnimal);
        resultSet = statement.executeQuery();
        while (resultSet.next()) {
            animalKeepers.add(
                AnimalKeeper.builder()
                    .id(resultSet.getInt("id"))
                    .name(resultSet.getString("name"))
                    .build()
            );
        }
        close();
        return animalKeepers;
    }

    @Override
    public AnimalAnimalKeeper update(AnimalAnimalKeeper animalAnimalKeeper) throws SQLException {
        return null;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return false;
    }

    @Override
    public AnimalAnimalKeeper get(int id) throws SQLException {
        return null;
    }

    @Override
    public List<AnimalAnimalKeeper> getAll() throws SQLException {
        return List.of();
    }
}

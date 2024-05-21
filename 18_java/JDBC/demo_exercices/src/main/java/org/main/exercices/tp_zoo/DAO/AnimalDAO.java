package org.main.exercices.tp_zoo.DAO;

import org.main.exercices.tp_zoo.entity.Animal;
import org.main.exercices.tp_zoo.utils.DataBaseManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class AnimalDAO extends AbstractDAO<Animal> {
    public enum SearchValue {
        NAME, LOCATION, SPECIE
    }

    private final MealDAO mealDAO;

    public AnimalDAO(Connection connection, MealDAO mealDAO) {
        super(connection);
        this.mealDAO = mealDAO;
    }

    @Override
    public Animal save(Animal animal) throws SQLException {
        try {
            connection = DataBaseManager.getConnection();
            statement = connection.prepareStatement("""
                    INSERT INTO animal(age, name, specie, description, location)
                    VALUES (?, ?, ?, ?, ?);
                    """,
                    Statement.RETURN_GENERATED_KEYS
            );
            statement.setInt(1, animal.getAge());
            statement.setString(2, animal.getName());
            statement.setString(3, animal.getSpecie());
            statement.setString(4, animal.getDescription());
            statement.setString(5, animal.getLocation());

            statement.executeUpdate();
            resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                animal.setIdAnimal(resultSet.getInt(1));
            }
            connection.commit();
            return animal;
        } catch (SQLException e) {
            connection.rollback();
            throw e;
        } finally {
            close();
        }
    }

    @Override
    public Animal update(Animal animal) throws SQLException {
        return null;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return false;
    }

    @Override
    public Animal get(int id) throws SQLException {
        Animal animal = null;
        connection = DataBaseManager.getConnection();
        statement = connection.prepareStatement("SELECT * FROM animal WHERE id = ?;");
        statement.setInt(1, id);
        resultSet = statement.executeQuery();
        if (resultSet.next()) {
            animal = Animal.builder()
                    .idAnimal(resultSet.getInt("id"))
                    .age(resultSet.getInt("age"))
                    .name(resultSet.getString("name"))
                    .specie(resultSet.getString("specie"))
                    .description(resultSet.getString("description"))
                    .location(resultSet.getString("location"))
                    .build();
        }
        close();
        return animal;
    }

    public List<Animal> find(String value, SearchValue searchValue) throws SQLException {
        String column = switch (searchValue) {
            case NAME -> "name";
            case LOCATION -> "location";
            case SPECIE -> "specie";
        };
        String req = "SELECT * FROM animal WHERE " + column + " LIKE ?;";
        connection = DataBaseManager.getConnection();
        statement = connection.prepareStatement(req);
        statement.setString(1, "%" + value + "%");
        resultSet = statement.executeQuery();
        List<Animal> animals = this.buildAnimalList(resultSet);
        close();
        return animals;
    }

    @Override
    public List<Animal> getAll() throws SQLException {
        connection = DataBaseManager.getConnection();
        statement = connection.prepareStatement("""
            SELECT * FROM ANIMAL
            """
        );
        resultSet = statement.executeQuery();
        List<Animal> animals = this.buildAnimalList(resultSet);
        close();
        return animals;
    }

    private List<Animal> buildAnimalList (ResultSet resultSet) throws SQLException {
        List<Animal> list = new ArrayList<>();
        while (resultSet.next()) {
            Animal animal = Animal.builder()
                    .idAnimal(resultSet.getInt("id"))
                    .age(resultSet.getInt("age"))
                    .name(resultSet.getString("name"))
                    .specie(resultSet.getString("specie"))
                    .description(resultSet.getString("description"))
                    .location(resultSet.getString("location"))
                    .build();
            animal.setMeals(mealDAO.getAllByAnimal(animal));
            list.add(animal);
        }
        return list;
    }
}

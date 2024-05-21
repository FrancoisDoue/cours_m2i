package org.main.demo.demo_2.DAO;

import org.main.demo.demo_2.entity.Plante;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PlanteDAO extends BaseDAO {

    private List<Plante> plantes;

    public PlanteDAO(Connection connection) {
        super(connection);
    }


    public Plante createPlante(String name, int age, String color) throws SQLException {
        request = """
                INSERT INTO plante (name, age, color)
                VALUES (?, ?, ?)""";
        preparedStatement = _connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);

        preparedStatement.setString(1, name);
        preparedStatement.setInt(2, age);
        preparedStatement.setString(3, color);
        preparedStatement.executeUpdate();
        resultSet = preparedStatement.getGeneratedKeys();
        if (resultSet.next()) {
            int id = resultSet.getInt(1);
            return Plante.builder()
                    .id_plante(id)
                    .name(name).age(age)
                    .color(color)
                    .build();
        }
        return null;
    }

    public List<Plante> getAllPlantes() throws SQLException {
        List<Plante> plantes = new ArrayList<>();
        request = "SELECT * FROM plante";
        preparedStatement = _connection.prepareStatement(request);
        resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            plantes.add(Plante.builder()
                    .id_plante(resultSet.getInt("id"))
                    .name(resultSet.getString("name"))
                    .age(resultSet.getInt("age"))
                    .color(resultSet.getString("color"))
                    .build()
            );
        }
        return plantes;
    }


    @Override
    public Object save(Object object) throws SQLException {
        return null;
    }

    @Override
    public Object update(Object object) throws SQLException {
        return null;
    }

    @Override
    public boolean delete(Object object) throws SQLException {
        return false;
    }

    @Override
    public Object get(int id) throws SQLException {
        return null;
    }

    @Override
    public List getAll() throws SQLException {
        List<Plante> plantes = new ArrayList<>();
        request = "SELECT * FROM plante";
        preparedStatement = _connection.prepareStatement(request);
        resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            plantes.add(Plante.builder()
                    .id_plante(resultSet.getInt("id"))
                    .name(resultSet.getString("name"))
                    .age(resultSet.getInt("age"))
                    .color(resultSet.getString("color"))
                    .build()
            );
        }
        return plantes;
    }
}

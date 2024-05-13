package org.main.demo.demo_2.DAO;

import org.main.demo.demo_2.entity.Plante;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PlanteDAO {

    private Connection connection;
    private PreparedStatement preparedStatement;
    private String request;
    private ResultSet resultSet;
    private List<Plante> plantes;

    public PlanteDAO(Connection connection) {
        this.connection = connection;

    }

    public Plante createPlante(String name, int age, String color) throws SQLException {
        request = """
                INSERT INTO plante (name, age, color)
                VALUES (?, ?, ?)""";
        preparedStatement = connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);

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
        preparedStatement = connection.prepareStatement(request);
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

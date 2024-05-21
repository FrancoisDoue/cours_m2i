package org.main.demo.demo_1;

import java.sql.*;

public class Main {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/test_java";
        String user = "root";
        String password = "root";
        Connection connection;
        try {
            connection = DriverManager.getConnection(url, user, password);
            if (connection != null) {
                System.out.println("Connection successful");

                Statement statement = connection.createStatement();
                String request = """
                    INSERT INTO person (firstname, lastname)
                    VALUES ('toto', 'tata')""";
                statement.execute(request);

                PreparedStatement preparedStatement = connection.prepareStatement("""
                    INSERT INTO person (firstname, lastname) 
                    VALUES (?, ?)""",
                    Statement.RETURN_GENERATED_KEYS
                );
                preparedStatement.setString(1, "John");
                preparedStatement.setString(2, "Doe");
                int row = preparedStatement.executeUpdate();
                if (row > 0) {
                    System.out.println("Row Inserted");
                    ResultSet resultSet = preparedStatement.getGeneratedKeys();
                    if (resultSet.next()) {
                        System.out.println("id: " + resultSet.getInt(1));
                    }
                }

                ResultSet resultSet = statement.executeQuery("SELECT * FROM PERSON");
                while (resultSet.next()) {
                    System.out.println(resultSet.getString("firstname") + " " + resultSet.getString("lastname"));
                }

            } else {
                System.out.println("Connection failed");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
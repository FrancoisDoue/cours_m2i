package org.main.exercices.tp_zoo.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseManager {
    private static final String URL = "jdbc:mysql://localhost:3306/java_tp_zoo";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public static Connection getConnection() throws SQLException {
        Connection c = DriverManager.getConnection(URL, USER, PASSWORD);
        c.setAutoCommit(false);
        return c;
    }



}

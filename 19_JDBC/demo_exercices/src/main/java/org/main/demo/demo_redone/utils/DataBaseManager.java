package org.main.demo.demo_redone.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseManager {
    private static final String URL = "jdbc:mysql://localhost:3306/demo_redone";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public static Connection getConnection() throws SQLException {
        Connection c = DriverManager.getConnection(URL, USER, PASSWORD);
        c.setAutoCommit(false);
        return c;
    }



}

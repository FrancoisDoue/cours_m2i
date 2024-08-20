package com.example.service;

import com.example.qualifier.MySQL;
import com.example.qualifier.Postgres;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.jboss.logging.Logger;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

@ApplicationScoped
public class ProductService {

    @Inject
    Logger logger;

    @Inject
    @MySQL
    DataSource mysqlDataSource;

    @Inject
    @Postgres
    DataSource postgresDataSource;

    public void printMySQLProducts() {
        String query = "select id, name, price from products";
        try {
            Connection connection = mysqlDataSource.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            logger.info("MySQL product list:");
            while (resultSet.next()) {
                logger.info(
                        resultSet.getString("id") + " " +
                        resultSet.getString("name") + " " +
                        resultSet.getString("price")
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

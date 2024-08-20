package com.example.datasource;

import com.example.qualifier.MySQL;
import com.example.qualifier.Postgres;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.Produces;
import org.apache.commons.dbcp2.BasicDataSource;
import org.jboss.logging.Logger;

import javax.sql.DataSource;
import java.sql.SQLException;

@ApplicationScoped
public class DataSourceProducer {

    @Inject
    Logger log;

    @Produces
    @MySQL
    @ApplicationScoped
    public DataSource getMySQLDataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3307/mydb_mysql");
        dataSource.setUsername("mysqluser");
        dataSource.setPassword("mysqlpass");

        try {
            dataSource.getConnection().isValid(2);
            log.info("MySQL connection established");
        } catch (SQLException e) {
            log.error("MySQL connection failed");
            throw new RuntimeException(e);
        }

        return dataSource;
    }

    @Produces
    @Postgres
    @ApplicationScoped
    public DataSource getPostgresDataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/mydb_postges");
        dataSource.setUsername("postgresuser");
        dataSource.setPassword("postgrespass");

        try {
            dataSource.getConnection().isValid(2);
            log.info("Postgres connection established");
        } catch (SQLException e) {
            log.error("Postgres connection failed");
            throw new RuntimeException(e);
        }

        return dataSource;
    }
}

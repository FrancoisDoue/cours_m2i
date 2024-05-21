package org.main.exercices.tp_zoo.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public abstract class AbstractDAO<T> {
    protected Connection connection;
    protected PreparedStatement statement;
    protected ResultSet resultSet;

    protected AbstractDAO(Connection connection) {
        this.connection = connection;
    }

    public abstract T save(T t) throws SQLException;
    public abstract T update(T t) throws SQLException;
    public abstract boolean delete(int id) throws SQLException;
    public abstract T get(int id) throws SQLException;
    public abstract List<T> getAll() throws SQLException;

    protected void close() throws SQLException {
        if (!connection.isClosed()) connection.close();
        if (!statement.isClosed()) statement.close();
        if (!resultSet.isClosed()) resultSet.close();
    };
}

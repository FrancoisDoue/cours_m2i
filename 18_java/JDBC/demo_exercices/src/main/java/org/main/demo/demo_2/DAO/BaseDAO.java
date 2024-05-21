package org.main.demo.demo_2.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public abstract class BaseDAO<T> {
    protected Connection _connection;
    protected PreparedStatement preparedStatement;
    protected String request;
    protected ResultSet resultSet;

    public BaseDAO(Connection connection) {
        this._connection = connection;
    }

    public abstract T save(T object) throws SQLException;
    public abstract T update(T object) throws SQLException;
    public abstract boolean delete(T object) throws SQLException;
    public abstract T get(int id) throws SQLException;
    public abstract List<T> getAll() throws SQLException;
}

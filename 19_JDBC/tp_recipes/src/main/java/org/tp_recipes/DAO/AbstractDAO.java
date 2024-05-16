package org.tp_recipes.DAO;

import org.tp_recipes.utils.DataBaseManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public abstract class AbstractDAO<T> {
    protected Connection connection;
    protected PreparedStatement statement;
    protected ResultSet resultSet;

    public AbstractDAO() throws SQLException {
        connection = DataBaseManager.getConnection();
    }

    public abstract T save (T element)throws SQLException;
    public abstract T update (T element)throws  SQLException;
    public abstract boolean delete(T element)throws SQLException;
    public abstract T get(int id) throws SQLException;
    public abstract List<T> getAll() throws SQLException;

    protected void connect() throws SQLException {
        if (connection.isClosed() || connection == null ) connection = DataBaseManager.getConnection();
    }

    protected void close() throws SQLException {
        if (!connection.isClosed()) connection.close();
        if (!statement.isClosed()) statement.close();
        if (!resultSet.isClosed()) resultSet.close();
    }
}

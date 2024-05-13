package org.main.exercices.exercice_1_2.DAO;

import lombok.Getter;
import org.main.exercices.exercice_1_2.Entity.Film;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public abstract class BaseDAO<T> {
    protected Connection connection;
    protected PreparedStatement preparedStatement;
    protected String request;
    protected ResultSet resultSet;
    @Getter
    protected List<T> list;

    public BaseDAO(Connection connection) {
        this.connection = connection;
    }

    public abstract T create(T t) throws SQLException;
    public abstract boolean update(T t) throws SQLException;
    public abstract boolean delete(int id) throws SQLException;
    public abstract List<T> getAll() throws SQLException;
    public abstract T getById(int id) throws SQLException;

}

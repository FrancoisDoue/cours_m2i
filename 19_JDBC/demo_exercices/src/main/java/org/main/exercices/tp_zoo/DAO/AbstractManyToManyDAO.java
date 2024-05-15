package org.main.exercices.tp_zoo.DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public abstract class AbstractManyToManyDAO<T, D> extends AbstractDAO<T> {

    protected AbstractManyToManyDAO(Connection connection) {
        super(connection);
    }

    protected abstract D add(D d) throws SQLException;
    protected abstract boolean remove(int id) throws SQLException;
    protected abstract D select(int id) throws SQLException;
    protected abstract List<D> selectAll() throws SQLException;

}

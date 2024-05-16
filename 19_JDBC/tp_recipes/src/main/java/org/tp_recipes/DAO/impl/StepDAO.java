package org.tp_recipes.DAO.impl;

import org.tp_recipes.DAO.AbstractDAO;
import org.tp_recipes.entity.Step;

import java.sql.SQLException;
import java.util.List;

public class StepDAO extends AbstractDAO<Step> {

    public StepDAO() throws SQLException {
    }

    @Override
    public Step save(Step element) throws SQLException {
        return null;
    }

    @Override
    public Step update(Step element) throws SQLException {
        return null;
    }

    @Override
    public boolean delete(Step element) throws SQLException {
        return false;
    }

    @Override
    public Step get(int id) throws SQLException {
        return null;
    }

    @Override
    public List<Step> getAll() throws SQLException {
        return List.of();
    }
}

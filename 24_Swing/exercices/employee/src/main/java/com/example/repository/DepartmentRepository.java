package com.example.repository;

import com.example.model.Department;

import java.util.List;

public class DepartmentRepository extends BaseRepository<Department> {
    @Override
    public Department get(int id) {
        _session = _factory.openSession();
        Department department = _session.get(Department.class, id);
        _session.close();
        return department;
    }

    @Override
    public List<Department> getAll() {
        _session = _factory.openSession();
        List<Department> departments = _session.createQuery("from Department", Department.class).list();
        _session.close();
        return departments;
    }
}

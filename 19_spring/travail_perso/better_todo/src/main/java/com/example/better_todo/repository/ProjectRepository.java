package com.example.better_todo.repository;

import com.example.better_todo.entity.Project;
import com.example.better_todo.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Integer> {
    List<Project> findByOwner(User user);
}

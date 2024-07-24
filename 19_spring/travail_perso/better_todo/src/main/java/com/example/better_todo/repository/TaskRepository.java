package com.example.better_todo.repository;

import com.example.better_todo.entity.Project;
import com.example.better_todo.entity.Task;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends CrudRepository<Task, Integer> {
    List<Task> findByProject(Project project);
}

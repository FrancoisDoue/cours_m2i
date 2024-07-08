package com.example.ex7_todolist.repository;

import com.example.ex7_todolist.entity.Task;
import org.springframework.data.repository.CrudRepository;

public interface TaskRepository extends CrudRepository<Task, Integer> {
    Iterable<Task> findByCompleted(boolean isCompleted);

}

package com.example.test_spring_data;

import com.example.test_spring_data.model.Task;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface TaskRepository extends CrudRepository<Task, UUID> {
    List<Task> findByIsCompleted(boolean isCompleted);

}

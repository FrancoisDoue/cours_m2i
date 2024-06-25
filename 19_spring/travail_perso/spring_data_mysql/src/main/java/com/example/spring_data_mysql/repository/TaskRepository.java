package com.example.spring_data_mysql.repository;

import com.example.spring_data_mysql.model.Task;
import org.springframework.data.repository.CrudRepository;

public interface TaskRepository extends CrudRepository<Task, Long> {

}

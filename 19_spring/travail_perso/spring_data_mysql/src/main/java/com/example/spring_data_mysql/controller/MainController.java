package com.example.spring_data_mysql.controller;

import com.example.spring_data_mysql.model.Task;
import com.example.spring_data_mysql.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

    private TaskRepository taskRepository;

    @Autowired
    public MainController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @PostMapping(path = "/new")
    @ResponseBody
    public Task newTask(@RequestBody Task task) {
        return taskRepository.save(task);
    }
}

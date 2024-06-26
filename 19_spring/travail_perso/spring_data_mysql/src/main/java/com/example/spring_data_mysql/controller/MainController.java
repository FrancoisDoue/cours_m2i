package com.example.spring_data_mysql.controller;

import com.example.spring_data_mysql.model.Task;
import com.example.spring_data_mysql.repository.TaskRepository;
import org.hibernate.annotations.ParamDef;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/tasks")
public class MainController {

    private final TaskRepository taskRepository;

    @Autowired
    public MainController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @PostMapping(path = "/new")
    @ResponseBody
    public Task newTask(@RequestBody Task task) {
        return taskRepository.save(task);
    }

    @GetMapping(path = "/all")
    @ResponseBody
    public List<Task> getAllTasks() {
        return (List<Task>) taskRepository.findAll();
    }
}

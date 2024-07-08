package com.example.ex7_todolist.controller;

import com.example.ex7_todolist.dto.TaskDTOPost;
import com.example.ex7_todolist.entity.Task;
import com.example.ex7_todolist.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MainController {

    private final TaskService taskService;

    @Autowired
    public MainController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public ResponseEntity<List<Task>> allTasks(@RequestParam(name = "status", required = false) Boolean isCompleted) {
        if (isCompleted == null) return ResponseEntity.ok().body(taskService.getAllTasks());
        return ResponseEntity.ok().body(taskService.getTasksByStatus(isCompleted));
    }

    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody TaskDTOPost taskDTO) {
        Task task = taskDTO.toEntity();
        return new ResponseEntity<>(taskService.saveTask(task), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> getTask(@PathVariable int id) {
        return ResponseEntity.ok().body(taskService.getTaskById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable int id) {
        taskService.deleteTaskById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable int id, @RequestBody TaskDTOPost taskDTO) {
        return ResponseEntity.ok().body(taskService.updateTask(id, taskDTO.toEntity()));
    }

    @PutMapping("/toggle-status/{id}")
    public ResponseEntity<Task> toggleStatus(@PathVariable int id) {
        return ResponseEntity.ok().body(taskService.updateTaskStatus(id));
    }
}

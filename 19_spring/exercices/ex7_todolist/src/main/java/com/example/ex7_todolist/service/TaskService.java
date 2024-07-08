package com.example.ex7_todolist.service;

import com.example.ex7_todolist.entity.Task;
import com.example.ex7_todolist.exception.NotFoundException;
import com.example.ex7_todolist.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getAllTasks() {
        return (List<Task>) taskRepository.findAll();
    }

    public List<Task> getTasksByStatus(boolean status) {
        return (List<Task>) taskRepository.findByCompleted(status);
    }

    public Task getTaskById(int id) {
        return taskRepository.findById(id).orElseThrow(() -> new NotFoundException("Task not found"));
    }

    public Task saveTask(Task task) {
        return taskRepository.save(task);
    }

    public Task updateTask(int id, Task task) {
        task.setId(id);
        return taskRepository.save(task);
    }

    public Task updateTaskStatus(int id) {
        Task task = getTaskById(id);
        task.setCompleted(!task.isCompleted());
        return taskRepository.save(task);
    }

    public void deleteTaskById(int id) {
        Task task = taskRepository.findById(id).orElse(null);
        if (task == null) throw new NotFoundException("Task not found");
        taskRepository.delete(task);
    }
}

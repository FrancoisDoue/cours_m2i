package com.example.ex7_todolist.dto;

import com.example.ex7_todolist.entity.Task;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TaskDTOPost {
    private int id;
    private String title;
    private String description;
    private String dueDate;
    private boolean completed;

    public Task toEntity() {
        Task task = new Task();
        task.setId(id);
        task.setTitle(title);
        task.setDescription(description);
        task.setDueDate(LocalDate.parse(dueDate, DateTimeFormatter.ofPattern("dd-MM-yyyy")));
        task.setCompleted(completed);
        return task;
    }
}

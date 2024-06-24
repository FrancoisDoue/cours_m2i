package com.exercices.ex1_todo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Todo {
    private int id;
    private String name;
    private String description;
    private boolean isDone;
}

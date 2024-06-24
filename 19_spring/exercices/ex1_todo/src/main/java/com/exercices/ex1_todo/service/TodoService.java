package com.exercices.ex1_todo.service;

import com.exercices.ex1_todo.model.Todo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService {
    private static int cntTodo = 0;
    private static List<Todo> todos = new ArrayList<>( List.of(
            new Todo(++cntTodo, "name "+cntTodo, "description "+cntTodo, false),
            new Todo(++cntTodo, "name "+cntTodo, "description "+cntTodo, true),
            new Todo(++cntTodo, "name "+cntTodo, "description "+cntTodo, false),
            new Todo(++cntTodo, "name "+cntTodo, "description "+cntTodo, true)
    ));

    public void createTodo(String name, String description) {
        Todo todo = new Todo(++cntTodo, name, description, false);
        todos.add(todo);
    }

    public Todo getTodo(int id) {
        return todos.stream().filter(todo -> todo.getId() == id).findFirst().orElse(null);
    }

    public List<Todo> getAll() {
        return todos;
    }

}

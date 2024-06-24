package com.exercices.ex1_todo.controller;

import com.exercices.ex1_todo.model.Todo;
import com.exercices.ex1_todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class TodoController {

    private final TodoService todoService;

    @Autowired
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @RequestMapping("/")
    public String home() {
        return "home";
    }

    @RequestMapping("/todos")
    @ResponseBody
    public List<Todo> getAllTodos() {
        return todoService.getAll();
    }

    @RequestMapping("/todos/{todoId}")
    public String getOneTodo(@PathVariable int todoId, Model model) {
        model.addAttribute("todoItem", todoService.getTodo(todoId));
        return "todo";
    }
}

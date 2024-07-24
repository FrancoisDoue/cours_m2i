package com.example.better_todo.controller;

import com.example.better_todo.entity.Project;
import io.jsonwebtoken.Header;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/project")
public class ProjectController {

    @GetMapping("/{userId}")
    public Project getProjectsByUserId(@PathVariable("userId") Integer userId, @RequestHeader HttpHeaders headers) {
        System.out.println("id "+userId);
        System.out.println("auth " +headers.get("Authorization"));
        return null;
    }
}

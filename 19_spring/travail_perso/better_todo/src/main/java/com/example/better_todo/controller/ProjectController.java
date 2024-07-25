package com.example.better_todo.controller;

import com.example.better_todo.config.jwt.JwtProvider;
import com.example.better_todo.entity.Project;
import com.example.better_todo.service.ProjectService;
import io.jsonwebtoken.Header;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/project")
public class ProjectController {

    private final ProjectService projectService;
    private final JwtProvider jwtProvider;

    public ProjectController(ProjectService projectService, JwtProvider jwtProvider) {
        this.projectService = projectService;
        this.jwtProvider = jwtProvider;
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<Project>> getProjectsByUserId(@PathVariable("userId") Integer userId, @RequestHeader HttpHeaders headers) {
        int tokenId = (int) jwtProvider.getClaimsFromToken(jwtProvider.extractToken(headers)).get("id");
        List<Project> projectList = projectService.getAllProjectsByOwnerId(userId, tokenId);
        return ResponseEntity.ok(projectList);
    }

}

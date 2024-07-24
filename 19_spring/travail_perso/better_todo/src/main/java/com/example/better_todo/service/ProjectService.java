package com.example.better_todo.service;

import com.example.better_todo.entity.Project;
import com.example.better_todo.repository.ProjectRepository;
import com.example.better_todo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    private final ProjectRepository projectRepository;
    private final UserRepository userRepository;

    public ProjectService(final ProjectRepository projectRepository, final UserRepository userRepository) {
        this.projectRepository = projectRepository;
        this.userRepository = userRepository;
    }

    public List<Project> getAllProjectsByOwnerId(int ownerId) {

        return projectRepository.findByOwner(
                userRepository.findById(ownerId)
                        .orElseThrow(() -> new RuntimeException("No project found"))
        );
    }

}

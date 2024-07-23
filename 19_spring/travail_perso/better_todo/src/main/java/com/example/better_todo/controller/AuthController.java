package com.example.better_todo.controller;

import com.example.better_todo.dto.UserDTO;
import com.example.better_todo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;
//
//    @PostMapping
//    public ResponseEntity<Map<String, UserDTO>> registerUser(UserDTO userDTO) {
//        UserDTO registerdUser = UserDTO.fromEntity(userService.createUser(userDTO.toEntity()));
//        return ResponseEntity
//    }
}

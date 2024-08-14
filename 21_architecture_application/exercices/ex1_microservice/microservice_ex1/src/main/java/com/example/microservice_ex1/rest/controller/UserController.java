package com.example.microservice_ex1.rest.controller;

import com.example.microservice_ex1.domain.service.UserService;
import com.example.microservice_ex1.shared.dto.UserDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserDTO> create(@RequestBody UserDTO user) {
        return new ResponseEntity<>(userService.createUser(user), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUser(@PathVariable int id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

}

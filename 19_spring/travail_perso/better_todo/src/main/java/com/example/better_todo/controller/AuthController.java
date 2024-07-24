package com.example.better_todo.controller;

import com.example.better_todo.dto.UserDTO;
import com.example.better_todo.entity.User;
import com.example.better_todo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserDTO> registerUser(@RequestBody UserDTO userDTO) {
        UserDTO registeredUser = UserDTO.fromEntity(
                userService.createUser(userDTO.toEntity())
        );
        System.out.println(registeredUser);
        return new ResponseEntity<>(registeredUser, HttpStatus.CREATED);
    }

//    @PostMapping("/enterprise/register")
//    public ResponseEntity<UserDTO> registerEnterpriseUser(@RequestBody UserDTO userDTO) {
//        UserDTO registeredUser = UserDTO.fromEntity(
//                userService.createEnterprise(userDTO.toEntity())
//        );
//        return new ResponseEntity<>(registeredUser, HttpStatus.CREATED);
//    }

    @PostMapping("/admin/register")
    public ResponseEntity<UserDTO> registerAdminUser(@RequestBody UserDTO userDTO) {
        UserDTO registeredUser = UserDTO.fromEntity(
                userService.createAdmin(userDTO.toEntity())
        );
        return new ResponseEntity<>(registeredUser, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> loginUser(@RequestBody UserDTO userDTO) {
        Map<String, String> response = new HashMap<>();
        User user = userDTO.toEntity();
        String token = userService.generateToken(user);
        response.put("token", token);
        return ResponseEntity.ok(response);
    }
}

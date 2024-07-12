package com.example.ex9_employee_back.controller;

import com.example.ex9_employee_back.dto.auth.AuthPostDTO;
import com.example.ex9_employee_back.dto.employee.EmployeeGetDTO;
import com.example.ex9_employee_back.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;
    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping
    public ResponseEntity<EmployeeGetDTO> login(@RequestBody AuthPostDTO authPostDTO) {
        return ResponseEntity.ok(authService.login(authPostDTO));
    }
}

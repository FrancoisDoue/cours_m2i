package com.m2ibank.controller;

import com.m2ibank.model.Customer;
import com.m2ibank.service.UserService;
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
@RequestMapping("/auth")
public class AuthenticationController {

    private final UserService userService;

    @Autowired
    public AuthenticationController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<Map<String, String>> register(@RequestBody Customer customer) {
        System.out.println(customer.getPwd());
        Map<String, String> response = new HashMap<>();
        if (userService.createCustomer(customer).getId() != 0) {
            response.put("message", "register successful");
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } else {
            response.put("message", "register failed");
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody Customer customer) {
        Map<String, String> response = new HashMap<>();
        if (userService.userNameExists(customer.getEmail()) && userService.verifyCustomer(customer.getEmail(), customer.getPwd())) {
            response.put("message", "login successful");
            response.put("token", userService.generateJwt(customer.getEmail(), customer.getPwd()));
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        response.put("message", "login failed");
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
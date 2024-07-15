package com.example.springsecurityjwt.controller;

import com.example.springsecurityjwt.dto.BaseResponseDTO;
import com.example.springsecurityjwt.dto.UserLoginDTO;
import com.example.springsecurityjwt.model.User;
import com.example.springsecurityjwt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public BaseResponseDTO register(@RequestBody User user) {
        if (userService.createUser(user)) {
            return new BaseResponseDTO("success");
        } else {
            return new BaseResponseDTO("fail");
        }
    }

    @PostMapping("/login")
    public BaseResponseDTO login(@RequestBody UserLoginDTO user) {
        if (userService.checkUserNameExists(user.getEmail())) {
            if (userService.verifyUser(user.getEmail(), user.getPassword())) {
                Map<String, String> data = new HashMap<>();
                data.put("token", userService.generateToken(user.getEmail(), user.getPassword()));
                return new BaseResponseDTO("login ok", data);
            }
        }
        return new BaseResponseDTO("fail");
    }


}

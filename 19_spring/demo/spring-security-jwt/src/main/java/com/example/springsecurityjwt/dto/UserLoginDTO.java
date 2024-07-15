package com.example.springsecurityjwt.dto;

import lombok.Data;

@Data
public class UserLoginDTO {

    private String email;
    private String password;
}

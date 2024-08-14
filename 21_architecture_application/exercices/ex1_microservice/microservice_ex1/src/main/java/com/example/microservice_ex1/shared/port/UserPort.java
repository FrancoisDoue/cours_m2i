package com.example.microservice_ex1.shared.port;

import com.example.microservice_ex1.shared.dto.UserDTO;

public interface UserPort {
    UserDTO getById(int id);
    UserDTO save(UserDTO user);
}

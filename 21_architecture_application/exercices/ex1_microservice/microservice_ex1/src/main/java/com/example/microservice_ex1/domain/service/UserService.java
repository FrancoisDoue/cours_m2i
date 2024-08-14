package com.example.microservice_ex1.domain.service;

import com.example.microservice_ex1.shared.dto.UserDTO;
import com.example.microservice_ex1.shared.port.UserPort;

public class UserService {

    private final UserPort userPort;
    public UserService(UserPort userPort) {
        this.userPort = userPort;
    }

    public UserDTO getUserById(int id) {
        return userPort.getById(id);
    }

    public UserDTO createUser(UserDTO userDTO) {
        return userPort.save(userDTO);
    }

}

package com.example.microservice_ex1.infra.springdata.portimpl;

import com.example.microservice_ex1.infra.springdata.entity.UserEntity;
import com.example.microservice_ex1.infra.springdata.repository.UserRepository;
import com.example.microservice_ex1.shared.dto.UserDTO;
import com.example.microservice_ex1.shared.port.UserPort;

public class UserPortImpl implements UserPort {

    private final UserRepository userRepository;

    public UserPortImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDTO getById(int id) {
        UserEntity entity = userRepository.findById(id).orElse(null);
        if (entity == null) return null;
        return new UserDTO(entity.getId(), entity.getName(), entity.getEmail());
    }

    @Override
    public UserDTO save(UserDTO user) {
        UserEntity entity = new UserEntity(user.getId(), user.getName(), user.getEmail());
        entity = userRepository.save(entity);
        return new UserDTO(entity.getId(), entity.getName(), entity.getEmail());

    }
}

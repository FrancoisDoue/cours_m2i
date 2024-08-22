package com.example.service;

import com.example.entity.User;
import com.example.repository.UserRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class UserService {

    @Inject
    UserRepository userRepository;

    public List<User> getUsers() {
        return userRepository.listAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id);
    }

    public User createUser(User user) {
        userRepository.persist(user);
        return user;
    }

    public User updateUser(Long id, User user) {
        User updatedUser = userRepository.findById(id);
        updatedUser.setName(user.getName());
        updatedUser.setUsername(user.getUsername());
        updatedUser.setPassword(user.getPassword());
        userRepository.persist(updatedUser);
        return updatedUser;
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}

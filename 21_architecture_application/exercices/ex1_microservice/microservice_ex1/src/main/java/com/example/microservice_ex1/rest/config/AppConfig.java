package com.example.microservice_ex1.rest.config;

import com.example.microservice_ex1.domain.service.UserService;
import com.example.microservice_ex1.infra.springdata.portimpl.UserPortImpl;
import com.example.microservice_ex1.infra.springdata.repository.UserRepository;
import com.example.microservice_ex1.shared.port.UserPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    private final UserRepository userRepository;
    public AppConfig(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Bean
    public UserPort userPort() {
        return new UserPortImpl(userRepository);
    }

    @Bean
    public UserService userService() {
        return new UserService(userPort());
    }
}

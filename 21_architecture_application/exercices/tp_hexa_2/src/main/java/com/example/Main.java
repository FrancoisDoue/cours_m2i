package com.example;


import com.example.config.InfrastructureConfig;
import com.example.config.RestAppInitializer;
import com.example.rest.RestApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        SpringApplication infrastructure = new SpringApplication(InfrastructureConfig.class);
        infrastructure.setDefaultProperties(Collections.singletonMap("server.port", "8081"));
        ConfigurableApplicationContext infraContext = infrastructure.run(args);

        SpringApplication restApplication = new SpringApplication(RestApplication.class);
        restApplication.setDefaultProperties(Collections.singletonMap("server.port", "8080"));
        restApplication.addInitializers(new RestAppInitializer(infraContext));

        ConfigurableApplicationContext restApplicationContext = restApplication.run();
    }
}
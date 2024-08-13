package com.example.config;

import com.example.domain.service.EventService;
import com.example.infrastructure_spring_data.portimpl.EventPortImpl;
import com.example.infrastructure_spring_data.repository.EventEntityRepository;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

public class RestAppInitializer implements ApplicationContextInitializer {


    private final ConfigurableApplicationContext infraContext;

    public RestAppInitializer(ConfigurableApplicationContext infraContext) {
        this.infraContext = infraContext;
    }

    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        ConfigurableBeanFactory beanFactory = applicationContext.getBeanFactory();
        beanFactory.registerSingleton("EventService", new EventService(
                new EventPortImpl(infraContext.getBean(EventEntityRepository.class))
        ));
    }
}

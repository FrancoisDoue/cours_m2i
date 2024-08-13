package com.example.tp_hexa_1.adapter.rest.config;

import com.example.tp_hexa_1.domain.service.EventService;
import com.example.tp_hexa_1.infrastructure.springdata.portimpl.EventPortImpl;
import com.example.tp_hexa_1.infrastructure.springdata.repository.EventEntityRepository;
import com.example.tp_hexa_1.shared.port.EventPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    private final EventEntityRepository eventEntityRepository;

    public AppConfig(EventEntityRepository eventEntityRepository) {
        this.eventEntityRepository = eventEntityRepository;
    }

    @Bean
    public EventPort eventPort() {
        return new EventPortImpl(eventEntityRepository);
    }

    @Bean
    public EventService eventService() {
        return new EventService(eventPort());
    }
    
}

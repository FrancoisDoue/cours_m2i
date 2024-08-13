package com.example.infrastructure_spring_data.portimpl;

import com.example.infrastructure_spring_data.entity.EventEntity;
import com.example.infrastructure_spring_data.repository.EventEntityRepository;
import com.example.shared.dto.EventDTO;
import com.example.shared.port.EventPort;

import java.util.List;

public class EventPortImpl implements EventPort {

    private final EventEntityRepository eventEntityRepository;

    public EventPortImpl(EventEntityRepository eventEntityRepository) {
        this.eventEntityRepository = eventEntityRepository;
    }

    @Override
    public EventDTO save(EventDTO eventDTO) {
        EventEntity event = eventEntityRepository.save(EventEntity.builder()
                .id(eventDTO.getId())
                .type(eventDTO.getType())
                .title(eventDTO.getTitle())
                .availablePlaces(eventDTO.getAvailablePlaces())
                .maxPlaces(eventDTO.getMaxPlaces()).build());
        return new EventDTO(event.getId(), event.getType(), event.getTitle(), event.getAvailablePlaces(), event.getMaxPlaces());
    }

    @Override
    public EventDTO getById(int id) {
        EventEntity event = eventEntityRepository.findById(id).orElse(null);
        if (event == null) return null;
        return new EventDTO(event.getId(), event.getType(), event.getTitle(), event.getAvailablePlaces(), event.getMaxPlaces());
    }

    @Override
    public List<EventDTO> getAll() {
        return eventEntityRepository.findAll().stream()
                .map(e -> new EventDTO(e.getId(), e.getType(), e.getTitle(), e.getAvailablePlaces(), e.getMaxPlaces()))
                .toList();
    }

    @Override
    public EventDTO update(EventDTO eventDTO) {
        return this.save(eventDTO);
    }
}

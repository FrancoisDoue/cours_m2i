package com.example.shared.port;

import com.example.shared.dto.EventDTO;

import java.util.List;

public interface EventPort {
    EventDTO save(EventDTO eventDTO);
    EventDTO getById(int id);
    List<EventDTO> getAll();
    EventDTO update(EventDTO eventDTO);
}

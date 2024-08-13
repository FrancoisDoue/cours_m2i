package com.example.tp_hexa_1.shared.port;

import com.example.tp_hexa_1.shared.dto.EventDTO;

import java.util.List;

public interface EventPort {
    EventDTO save(EventDTO eventDTO);
    EventDTO getById(int id);
    List<EventDTO> getAll();
    EventDTO update(EventDTO eventDTO);
}

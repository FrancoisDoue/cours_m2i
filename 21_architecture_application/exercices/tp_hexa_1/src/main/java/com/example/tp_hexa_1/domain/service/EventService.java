package com.example.tp_hexa_1.domain.service;

import com.example.tp_hexa_1.domain.entity.Event;
import com.example.tp_hexa_1.shared.dto.EventDTO;
import com.example.tp_hexa_1.shared.port.EventPort;

import java.util.List;

public class EventService {

    private final EventPort eventPort;

    public EventService(EventPort eventPort) {
        this.eventPort = eventPort;
    }

    public Event save(String type, String title, int availablePlaces, int maxPlaces) {
        EventDTO dto = eventPort.save(new EventDTO(type, title, availablePlaces, maxPlaces));
        return dto.toEntity();
    }

    public Event getById(int id) {
        EventDTO eventDTO = eventPort.getById(id);
        return eventDTO.toEntity();
    }

    public List<Event> getAll() {
        return eventPort.getAll().stream()
                .map(EventDTO::toEntity)
                .toList();
    }

    public Event bookTickets(int id, int amount) {
        Event event = getById(id);
        if (amount > event.getAvailablePlaces()) return event;
        event.setAvailablePlaces(event.getAvailablePlaces() - amount);
        return eventPort.save(EventDTO.fromEntity(event)).toEntity();
    }

    public Event cancelTickets(int id, int amount) {
        Event event = getById(id);
        if ((amount + event.getAvailablePlaces()) > event.getMaxPlaces()) return event;
        event.setAvailablePlaces(event.getAvailablePlaces() + amount);
        return eventPort.save(EventDTO.fromEntity(event)).toEntity();
    }

}

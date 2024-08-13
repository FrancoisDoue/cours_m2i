package com.example.tp_hexa_1.adapter.rest.controller;

import com.example.tp_hexa_1.domain.service.EventService;
import com.example.tp_hexa_1.shared.dto.EventDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/events")
public class EventController {

    private final EventService eventService;
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping
    public ResponseEntity<List<EventDTO>> getEvents() {
        return ResponseEntity.ok(eventService.getAll().stream().map(EventDTO::fromEntity).toList());
    }

    @PostMapping
    public ResponseEntity<EventDTO> createEvent(@RequestBody EventDTO eventDTO) {
        EventDTO response = EventDTO.fromEntity(
                eventService.save(eventDTO.getType(), eventDTO.getTitle(), eventDTO.getAvailablePlaces(), eventDTO.getMaxPlaces())
        );
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping("/book")
    public ResponseEntity<EventDTO> updateEvent(@RequestParam int id, @RequestParam int amount) {
        EventDTO response = EventDTO.fromEntity(eventService.bookTickets(id, amount));
        return ResponseEntity.ok(response);
    }

    @PostMapping("/cancel")
    public ResponseEntity<EventDTO> deleteEvent(@RequestParam int id, @RequestParam int amount) {
        EventDTO response = EventDTO.fromEntity(eventService.cancelTickets(id, amount));
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EventDTO> getEventById(@PathVariable int id) {
        return ResponseEntity.ok(EventDTO.fromEntity(eventService.getById(id)));
    }

}

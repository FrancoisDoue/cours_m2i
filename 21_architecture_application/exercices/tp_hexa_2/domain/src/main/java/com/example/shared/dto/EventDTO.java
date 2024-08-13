package com.example.shared.dto;


import com.example.domain.entity.Event;

public class EventDTO {
    private int id;
    private String type;
    private String title;
    private int availablePlaces;
    private int maxPlaces;

    public EventDTO() {};

    public EventDTO(String type, String title, int availablePlaces, int maxPlaces) {
        this.type = type;
        this.title = title;
        this.availablePlaces = availablePlaces;
        this.maxPlaces = maxPlaces;
    }

    public EventDTO(int id, String type, String title, int availablePlaces, int maxPlaces) {
        this(type, title, availablePlaces, maxPlaces);
        this.id = id;
    }

    public static EventDTO fromEntity(Event event) {
        return new EventDTO(event.getId(), event.getType(), event.getTitle(), event.getAvailablePlaces(), event.getMaxPlaces());
    }

    public Event toEntity() {
        return new Event(id, type, title, availablePlaces, maxPlaces);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getAvailablePlaces() {
        return availablePlaces;
    }

    public void setAvailablePlaces(int availablePlaces) {
        this.availablePlaces = availablePlaces;
    }

    public int getMaxPlaces() {
        return maxPlaces;
    }

    public void setMaxPlaces(int maxPlaces) {
        this.maxPlaces = maxPlaces;
    }
}

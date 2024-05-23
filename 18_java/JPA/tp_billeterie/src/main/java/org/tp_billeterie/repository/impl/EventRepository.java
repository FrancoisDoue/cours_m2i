package org.tp_billeterie.repository.impl;

import org.tp_billeterie.entity.Event;
import org.tp_billeterie.repository.AbstractRepository;

import java.util.List;

public class EventRepository extends AbstractRepository<Event> {
    @Override
    public Event getById(int id) {
        return null;
    }

    @Override
    public List<Event> getAll() {
        return List.of();
    }
}

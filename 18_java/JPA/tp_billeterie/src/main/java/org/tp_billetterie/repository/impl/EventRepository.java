package org.tp_billetterie.repository.impl;

import org.tp_billetterie.entity.Event;
import org.tp_billetterie.repository.AbstractRepository;

import java.util.List;

public class EventRepository extends AbstractRepository<Event> {
    @Override
    public Event getById(int id) {
        return em.find(Event.class, id);
    }

    @Override
    public List<Event> getAll() {
        return em.createQuery("select e from Event e", Event.class).getResultList();
    }
}

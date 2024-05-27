package org.tp_billetterie.repository.impl;

import org.tp_billetterie.entity.Ticket;
import org.tp_billetterie.repository.AbstractRepository;

import java.util.List;

public class TicketRepository extends AbstractRepository<Ticket> {

    public void saveMany(List<Ticket> tickets) {
        tickets.forEach(this::save);
    }

    @Override
    public Ticket getById(int id) {
        return em.find(Ticket.class, id);
    }

    @Override
    public List<Ticket> getAll() {
        return em.createQuery("select t from Ticket t", Ticket.class).getResultList();
    }
}

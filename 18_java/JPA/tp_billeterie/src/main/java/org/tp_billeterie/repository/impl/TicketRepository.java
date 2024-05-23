package org.tp_billeterie.repository.impl;

import org.tp_billeterie.entity.Ticket;
import org.tp_billeterie.repository.AbstractRepository;

import java.util.List;

public class TicketRepository extends AbstractRepository<Ticket> {
    @Override
    public Ticket getById(int id) {
        return null;
    }

    @Override
    public List<Ticket> getAll() {
        return List.of();
    }
}

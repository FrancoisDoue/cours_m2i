package org.tp_billeterie.repository.impl;

import org.tp_billeterie.entity.Client;
import org.tp_billeterie.repository.AbstractRepository;

import java.util.List;

public class ClientRepository extends AbstractRepository<Client> {

    private final TicketRepository ticketRepository = new TicketRepository();

//    @Override
//    public boolean delete(Client client) {
//        client.getTickets().forEach(ticket -> {
//            ticket.setClient(null);
//            ticketRepository.update(ticket);
//        });
//        return super.delete(client);
//    }

    @Override
    public Client getById(int id) {
        return em.find(Client.class, id);
    }

    @Override
    public List<Client> getAll() {
        return em.createQuery("select c from Client c", Client.class).getResultList();
    }
}

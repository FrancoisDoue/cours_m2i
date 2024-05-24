package org.tp_billeterie.repository.impl;

import org.tp_billeterie.entity.Client;
import org.tp_billeterie.repository.AbstractRepository;

import java.util.List;

public class ClientRepository extends AbstractRepository<Client> {
    @Override
    public Client getById(int id) {
        return em.find(Client.class, id);
    }

    @Override
    public List<Client> getAll() {
        return em.createQuery("select c from Client c", Client.class).getResultList();
    }
}

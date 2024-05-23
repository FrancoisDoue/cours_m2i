package org.tp_billeterie.repository.impl;

import org.tp_billeterie.entity.Client;
import org.tp_billeterie.repository.AbstractRepository;

import java.util.List;

public class ClientRepository extends AbstractRepository<Client> {
    @Override
    public Client getById(int id) {
        return null;
    }

    @Override
    public List<Client> getAll() {
        return List.of();
    }
}

package org.tp_billeterie.repository.impl;

import org.tp_billeterie.entity.Address;
import org.tp_billeterie.repository.AbstractRepository;

import java.util.List;

public class AddressRepository extends AbstractRepository<Address> {
    @Override
    public Address getById(int id) {
        return null;
    }

    @Override
    public List<Address> getAll() {
        return List.of();
    }
}

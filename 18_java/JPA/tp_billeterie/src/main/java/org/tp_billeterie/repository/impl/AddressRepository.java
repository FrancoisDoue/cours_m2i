package org.tp_billeterie.repository.impl;

import org.tp_billeterie.entity.Address;
import org.tp_billeterie.entity.Location;
import org.tp_billeterie.repository.AbstractRepository;

import java.util.List;

public class AddressRepository extends AbstractRepository<Address> {
    @Override
    public Address getById(int id) {
        return em.find(Address.class, id);
    }

    public Location getLocationById(int id) {
        return em.find(Location.class, id);
    }

    @Override
    public List<Address> getAll() {
        return em.createQuery("select a from Address a", Address.class).getResultList();
    }

    public List<Location> getAllLocations() {
        return em.createQuery("select l from Location l", Location.class).getResultList();
    }
}

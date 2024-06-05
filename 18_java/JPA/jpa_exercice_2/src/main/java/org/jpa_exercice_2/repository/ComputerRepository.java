package org.jpa_exercice_2.repository;

import org.jpa_exercice_2.entity.Computer;
import org.jpa_exercice_2.entity.Device;

import java.util.List;

public class ComputerRepository extends AbstractEntityRepository<Computer> {

//    public Computer addDevice(int id, Device device) {
//        Computer computer = getById(id);
//        computer.add(device);
//        device.add(computer);
//        refresh(computer);
//        return getById(computer.getId());
//    }

    @Override
    public Computer getById(int id) {
        return em.find(Computer.class, id);
    }

    @Override
    public List<Computer> getAll() {
        return em.createQuery("select c from Computer c", Computer.class).getResultList();
    }
}

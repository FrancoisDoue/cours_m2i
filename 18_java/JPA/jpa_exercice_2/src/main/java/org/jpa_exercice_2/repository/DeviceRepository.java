package org.jpa_exercice_2.repository;

import org.jpa_exercice_2.entity.Computer;
import org.jpa_exercice_2.entity.Device;

import java.util.List;

public class DeviceRepository extends AbstractEntityRepository<Device> {
    @Override
    public Device getById(int id) {
        return em.find(Device.class, id);
    }

    @Override
    public List<Device> getAll() {
        return em.createQuery("select d from Device d", Device.class).getResultList();
    }

    public Device addComputerToDevice(Device device, Computer computer) {
        device.add(computer);
        return update(device);
    }
}

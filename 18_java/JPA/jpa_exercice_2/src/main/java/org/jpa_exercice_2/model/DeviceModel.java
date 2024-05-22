package org.jpa_exercice_2.model;

import org.jpa_exercice_2.entity.Computer;
import org.jpa_exercice_2.entity.Device;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class DeviceModel {
    private static DeviceModel INSTANCE;
    private final EntityManager em;

    private DeviceModel() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa_exercice_2");
        em = emf.createEntityManager();
    }
    public static synchronized DeviceModel getInstance() {
        if (INSTANCE == null) INSTANCE = new DeviceModel();
        return INSTANCE;
    }

    public Device getDevice(int id) {
        return em.find(Device.class, id);
    }

    public List<Device> getAllDevices() {
        return em.createQuery("select d from Device d", Device.class).getResultList();
    }

    public Device saveDevice(Device device) {
        em.getTransaction().begin();
        em.persist(device);
        em.getTransaction().commit();
        return device;
    }

    public Device updateDevice(Device device) {
        em.getTransaction().begin();
        em.merge(device);
        em.getTransaction().commit();
        return device;
    }

    public boolean deleteDevice(Device device) {
        em.getTransaction().begin();
        em.remove(device);
        em.getTransaction().commit();
        return !em.contains(device);
    }

    public Device addComputerToDevice(Device device, Computer computer) {
        device.add(computer);
        return updateDevice(device);
    }
}

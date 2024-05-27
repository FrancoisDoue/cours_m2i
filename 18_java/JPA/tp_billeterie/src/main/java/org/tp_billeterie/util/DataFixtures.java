package org.tp_billeterie.util;

import org.tp_billeterie.entity.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public final class DataFixtures {

    public void run() {
//        truncateAll();

        Random rand = new Random();

        List<Address> addresses = new ArrayList<>();
        List<Location> locations = new ArrayList<>();
        List<Event> events = new ArrayList<>();
        List<Client> clients = new ArrayList<>();
        List<Ticket> tickets = new ArrayList<>();

        for (int i = 0; i < 15; i++) {
            addresses.add(Address.builder().address("address " + i).city("City " + i).build());
        }
        for (int i = 0; i < 5; i++) {
            locations.add(
                    Location.builder()
                            .address("location " + i)
                            .city("City " + i)
                            .capacity(rand.nextInt(20, 51))
                            .build()
            );
        }
        for (int i = 0; i < 3; i++) {
            Location location = locations.get(rand.nextInt(locations.size()));
            int maxCapacity = location.getCapacity() - rand.nextInt(location.getCapacity());
            Event event = Event.builder()
                    .name("Event " + i)
                    .eventDate(LocalDate.of(2024, 6, rand.nextInt(1, 31)))
                    .eventTime(LocalTime.of(20, 0))
                    .location(location)
                    .maxCapacity(maxCapacity)
                    .build();
            for (int j = 0; j < maxCapacity; j++) {
                Ticket ticket = Ticket.builder().ticketType(rand.nextInt(1,4)).event(event).build();
                tickets.add(ticket);
            }
            events.add(event);
        }
        for (int i = 0; i < 10; i++) {
            clients.add(Client.builder()
                    .firstname("fname" + i)
                    .lastname("lname" + i)
                    .age(rand.nextInt(18, 80))
                    .address(addresses.get(rand.nextInt(0, addresses.size())))
                    .build());
        }

        DatabaseManager.getInstance().getEm().getTransaction().begin();

        addresses.forEach(DatabaseManager.getInstance().getEm()::persist);
        locations.forEach(DatabaseManager.getInstance().getEm()::persist);
        tickets.forEach(DatabaseManager.getInstance().getEm()::persist);
        events.forEach(DatabaseManager.getInstance().getEm()::persist);
        clients.forEach(DatabaseManager.getInstance().getEm()::persist);

        DatabaseManager.getInstance().getEm().getTransaction().commit();
        DatabaseManager.close();
    }

//    private void truncateAll() {
//        EntityManager em = DatabaseManager.getInstance().getEm();
//        em.createQuery("delete from Event").executeUpdate();
//        em.createQuery("delete from Client").executeUpdate();
//        em.createQuery("delete from Location").executeUpdate();
//        em.createQuery("delete from Ticket").executeUpdate();
//        em.createQuery("delete from Address").executeUpdate();
//
//        DatabaseManager.close();
//    }
}

package org.tp_billeterie.ihm;

import org.tp_billeterie.entity.Address;
import org.tp_billeterie.entity.Location;
import org.tp_billeterie.repository.impl.AddressRepository;

import java.util.Scanner;

public class AddressIHM {

    AddressRepository aRepository = new AddressRepository();

    public Address createAddress() {
        Scanner sc = new Scanner(System.in);
        System.out.println("- - - Nouvelle addresse - - -");
        Address address = new Address();
        System.out.println("Adresse : ");
        address.setAddress(sc.nextLine());
        System.out.println("Ville :");
        address.setCity(sc.nextLine());
        aRepository.save(address);
        return address;
    }

    public Address updateAddress(Address address) {
        Scanner sc = new Scanner(System.in);
        System.out.println("- - - Modifier addresse - - -");
        System.out.println(address);
        System.out.println("Adresse : ");
        address.setAddress(sc.nextLine());
        System.out.println("Ville :");
        address.setCity(sc.nextLine());
        aRepository.save(address);
        return address;
    }

    public String showLocations() {
        StringBuilder locationString = new StringBuilder();
        aRepository.getAllLocations().forEach(l -> locationString.append(l).append('\n'));
        return locationString.toString();
    }

    public Location selectLocation() {
        Scanner sc = new Scanner(System.in);
        showLocations();
        System.out.println("Sélectionnez une adresse : ");
        return aRepository.getLocationById(sc.nextInt());
    }

}

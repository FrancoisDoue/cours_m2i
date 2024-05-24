package org.tp_billeterie.ihm;

import org.tp_billeterie.entity.Address;
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
}

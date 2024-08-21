package com.example.service;

import com.example.entity.Client;
import com.example.repository.ClientRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class ClientService {

    @Inject
    ClientRepository clientRepository;

    public List<Client> getClients() {
        return clientRepository.listAll();
    }

    public Optional<Client> getClientById (Long id) {
        return clientRepository.findByIdOptional(id);
    }

    public Client createClient(Client client) {
        clientRepository.persist(client);
        return client;
    }

    public Client updateClient(Long id, Client client) {
        client.setId(id);
        clientRepository.persist(client);
        return client;
    }

    public void deleteClient (Long id) {
        clientRepository.deleteById(id);
    }
}

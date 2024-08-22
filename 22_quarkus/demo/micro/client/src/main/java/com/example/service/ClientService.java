package com.example.service;

import com.example.entity.Client;
import com.example.repository.ClientRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

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

    @Transactional
    public Client createClient(Client client) {
        clientRepository.persist(client);
        return client;
    }

    @Transactional
    public Client updateClient(Long id, Client client) {
        Client updatedClient = getClientById(id).orElseThrow();
        updatedClient.setName(client.getName());
        updatedClient.setEmail(client.getEmail());
        updatedClient.setPhone(client.getPhone());
        clientRepository.persist(updatedClient);
        return updatedClient;
    }

    @Transactional
    public void deleteClient (Long id) {
        clientRepository.deleteById(id);
    }
}

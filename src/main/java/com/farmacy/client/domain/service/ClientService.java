package com.farmacy.client.domain.service;

import com.farmacy.client.domain.entity.Client;

import java.util.List;
import java.util.Optional;

public interface ClientService {
    void createClient(Client client);
    void deleteClient(int id);
    void editClient(int id, String field, String newValue);
    Optional<Client> findClient(int id);
    List<Client> findAllClients();
}

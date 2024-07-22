package com.farmacy.client.aplication;

import com.farmacy.client.domain.entity.Client;
import com.farmacy.client.domain.service.ClientService;

import java.util.Optional;

public class FindClientUC {
    private ClientService clientService;

    public FindClientUC(ClientService clientService) {
        this.clientService = clientService;
    }

    public Optional<Client> execute(int id) {
        return clientService.findClient(id);
    }
}

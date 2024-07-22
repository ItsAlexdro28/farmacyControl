package com.farmacy.client.aplication;

import com.farmacy.client.domain.entity.Client;
import com.farmacy.client.domain.service.ClientService;

import java.util.List;

public class FindAllClientsUC {
    private ClientService clientService;

    public FindAllClientsUC(ClientService clientService) {
        this.clientService = clientService;
    }

    public List<Client> execute() {
        return clientService.findAllClients();
    }
}

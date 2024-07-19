package com.farmacy.clients.aplication;

import com.farmacy.clients.domain.entity.Client;
import com.farmacy.clients.domain.service.ClientService;

public class CreateClient {
    public final ClientService clientService;

    public CreateClient(ClientService clientService) {
        this.clientService = clientService;
    }

    public void execute(Client client) {
        clientService.createClient(client);
    }
}
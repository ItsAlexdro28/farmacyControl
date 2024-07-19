package com.farmacy.client.aplication;

import com.farmacy.client.domain.entity.Client;
import com.farmacy.client.domain.service.ClientService;

public class CreateClient {
    public final ClientService clientService;

    public CreateClient(ClientService clientService) {
        this.clientService = clientService;
    }

    public void execute(Client client) {
        clientService.createClient(client);
    }
}
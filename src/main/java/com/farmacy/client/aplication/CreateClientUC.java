package com.farmacy.client.aplication;

import com.farmacy.client.domain.entity.Client;
import com.farmacy.client.domain.service.ClientService;

public class CreateClientUC {
    private ClientService clientService;

    public CreateClientUC(ClientService clientService) {
        this.clientService = clientService;
    }

    public void execute(Client client) {
        clientService.createClient(client);
    }
}

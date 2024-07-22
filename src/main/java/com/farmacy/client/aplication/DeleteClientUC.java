package com.farmacy.client.aplication;

import com.farmacy.client.domain.service.ClientService;

public class DeleteClientUC {
    private ClientService clientService;

    public DeleteClientUC(ClientService clientService) {
        this.clientService = clientService;
    }

    public void execute(int id) {
        clientService.deleteClient(id);
    }
}
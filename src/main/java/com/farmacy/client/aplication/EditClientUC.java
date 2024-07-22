package com.farmacy.client.aplication;

import com.farmacy.client.domain.service.ClientService;

public class EditClientUC {
    private ClientService clientService;

    public EditClientUC(ClientService clientService) {
        this.clientService = clientService;
    }

    public void execute(int id, String field, String newValue) {
        clientService.editClient(id, field, newValue);
    }
}

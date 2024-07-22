package com.farmacy.typeid.aplication;

import com.farmacy.typeid.domain.service.TypeIdService;

public class DeleteTypeIdUC {
    private TypeIdService typeIdService;

    public DeleteTypeIdUC(TypeIdService typeIdService) {
        this.typeIdService = typeIdService;
    }

    public void execute(String document) {
        typeIdService.deleteTypeId(document);
    }
}

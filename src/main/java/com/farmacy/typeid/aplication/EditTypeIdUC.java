package com.farmacy.typeid.aplication;

import com.farmacy.typeid.domain.service.TypeIdService;

public class EditTypeIdUC {
    private TypeIdService typeIdService;

    public EditTypeIdUC(TypeIdService typeIdService) {
        this.typeIdService = typeIdService;
    }

    public void execute(String document, String field, String newValue) {
        typeIdService.editTypeId(document, field, newValue);
    }
}

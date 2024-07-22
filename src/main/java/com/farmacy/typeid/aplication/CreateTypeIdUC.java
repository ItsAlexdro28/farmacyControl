package com.farmacy.typeid.aplication;

import com.farmacy.typeid.domain.entity.TypeId;
import com.farmacy.typeid.domain.service.TypeIdService;

public class CreateTypeIdUC {
    private TypeIdService typeIdService;

    public CreateTypeIdUC(TypeIdService typeIdService) {
        this.typeIdService = typeIdService;
    }

    public void execute(TypeId typeId) {
        typeIdService.createTypeId(typeId);
    }
}

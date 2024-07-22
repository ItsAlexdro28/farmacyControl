package com.farmacy.typeid.aplication;

import com.farmacy.typeid.domain.entity.TypeId;
import com.farmacy.typeid.domain.service.TypeIdService;

import java.util.Optional;

public class FindTypeIdUC {
    private TypeIdService typeIdService;

    public FindTypeIdUC(TypeIdService typeIdService) {
        this.typeIdService = typeIdService;
    }

    public Optional<TypeId> execute(String document) {
        return typeIdService.findTypeId(document);
    }
}

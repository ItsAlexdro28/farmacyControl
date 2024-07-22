package com.farmacy.typeid.aplication;

import com.farmacy.typeid.domain.entity.TypeId;
import com.farmacy.typeid.domain.service.TypeIdService;
import java.util.List;

public class GetAllTypeIdsUC {
    private TypeIdService typeIdService;

    public GetAllTypeIdsUC(TypeIdService typeIdService) {
        this.typeIdService = typeIdService;
    }

    public List<TypeId> execute() {
        return typeIdService.getAllTypeIds();
    }
}
package com.farmacy.typeid.domain.service;

import com.farmacy.typeid.domain.entity.TypeId;

import java.util.List;
import java.util.Optional;

public interface TypeIdService {
    void createTypeId(TypeId typeId);
    void deleteTypeId(String document);
    void editTypeId(String document, String field, String newValue);
    Optional<TypeId> findTypeId(String document);
    List<TypeId> findAllTypeIds();
    List<TypeId> getAllTypeIds();
}

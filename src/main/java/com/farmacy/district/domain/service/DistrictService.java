package com.farmacy.district.domain.service;

import com.farmacy.district.domain.entity.District;
import java.util.List;
import java.util.Optional;

public interface DistrictService {
    void createDistrict(District district);
    void deleteDistrict(String name);
    void editDistrict(String name, String field, String newValue);
    Optional<District> findDistrict(String name);
    List<District> findAllDistricts();
}

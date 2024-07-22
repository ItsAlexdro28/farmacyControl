package com.farmacy.district.aplication;

import com.farmacy.district.domain.entity.District;
import com.farmacy.district.domain.service.DistrictService;

import java.util.Optional;

public class FindDistrictUC {
    private DistrictService districtService;

    public FindDistrictUC(DistrictService districtService) {
        this.districtService = districtService;
    }

    public Optional<District> execute(String name) {
        return districtService.findDistrict(name);
    }
}

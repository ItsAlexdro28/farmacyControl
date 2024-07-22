package com.farmacy.district.aplication;

import com.farmacy.district.domain.entity.District;
import com.farmacy.district.domain.service.DistrictService;

import java.util.List;

public class FindAllDistrictsUC {
    private DistrictService districtService;

    public FindAllDistrictsUC(DistrictService districtService) {
        this.districtService = districtService;
    }

    public List<District> execute() {
        return districtService.findAllDistricts();
    }
}

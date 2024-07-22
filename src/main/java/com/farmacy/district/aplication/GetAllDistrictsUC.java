package com.farmacy.district.aplication;

import com.farmacy.district.domain.entity.District;
import com.farmacy.district.domain.service.DistrictService;
import java.util.List;

public class GetAllDistrictsUC {
    private DistrictService districtService;

    public GetAllDistrictsUC(DistrictService districtService) {
        this.districtService = districtService;
    }

    public List<District> execute() {
        return districtService.getAllDistricts();
    }
}
package com.farmacy.district.aplication;

import com.farmacy.district.domain.entity.District;
import com.farmacy.district.domain.service.DistrictService;

public class CreateDistrictUC {
    private DistrictService districtService;

    public CreateDistrictUC(DistrictService districtService) {
        this.districtService = districtService;
    }

    public void execute(District district) {
        districtService.createDistrict(district);
    }
}

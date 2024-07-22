package com.farmacy.district.aplication;

import com.farmacy.district.domain.service.DistrictService;

public class DeleteDistrictUC {
    private DistrictService districtService;

    public DeleteDistrictUC(DistrictService districtService) {
        this.districtService = districtService;
    }

    public void execute(String name) {
        districtService.deleteDistrict(name);
    }
}

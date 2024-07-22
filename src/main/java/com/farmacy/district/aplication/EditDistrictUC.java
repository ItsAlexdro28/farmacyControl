package com.farmacy.district.aplication;

import com.farmacy.district.domain.service.DistrictService;

public class EditDistrictUC {
    private DistrictService districtService;

    public EditDistrictUC(DistrictService districtService) {
        this.districtService = districtService;
    }

    public void execute(String name, String field, String newValue) {
        districtService.editDistrict(name, field, newValue);
    }
}

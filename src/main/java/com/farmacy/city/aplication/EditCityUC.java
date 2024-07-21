package com.farmacy.city.aplication;

import com.farmacy.city.domain.entity.City;
import com.farmacy.city.domain.service.CityService;

public class EditCityUC {
    private final CityService cityService;

    public EditCityUC(CityService cityService) {
        this.cityService = cityService;
    }

    public void execute(String cityId, String field, String newValue) {
        cityService.editCity(cityId, field, newValue);
    }
}



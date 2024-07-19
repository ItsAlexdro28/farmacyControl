package com.farmacy.city.aplication;

import com.farmacy.city.domain.entity.City;
import com.farmacy.city.domain.service.CityService;

public class EditCity {
    public final CityService cityService;

    public EditCity(CityService cityService) {
        this.cityService = cityService;
    }

    public void execute (City city) {
        cityService.editCity(city);
    }
}



package com.farmacy.city.aplication;

import com.farmacy.city.domain.entity.City;
import com.farmacy.city.domain.service.CityService;

public class CreateCity {
    public final CityService cityService;

    public CreateCity(CityService cityService) {
        this.cityService = cityService;
    }

    public void execute (City city) {
        cityService.createCity(city);
    }
}

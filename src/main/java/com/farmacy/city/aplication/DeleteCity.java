package com.farmacy.city.aplication;

import com.farmacy.city.domain.entity.City;
import com.farmacy.city.domain.service.CityService;

public class DeleteCity {
    public final CityService cityService;

    public DeleteCity(CityService cityService) {
        this.cityService = cityService;
    }

    public void execute (City city) {
        cityService.deleteCity(city);
    }
}


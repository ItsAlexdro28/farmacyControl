package com.farmacy.city.aplication;

import com.farmacy.city.domain.entity.City;
import com.farmacy.city.domain.service.CityService;

public class DeleteCityUC {
    public final CityService cityService;

    public DeleteCityUC(CityService cityService) {
        this.cityService = cityService;
    }

    public void execute (String city) {
        cityService.deleteCity(city);
    }
}


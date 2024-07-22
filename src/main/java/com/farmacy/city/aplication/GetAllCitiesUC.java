package com.farmacy.city.aplication;

import com.farmacy.city.domain.entity.City;
import com.farmacy.city.domain.service.CityService;

import java.util.List;

public class GetAllCitiesUC {
    private CityService cityService;

    public GetAllCitiesUC(CityService cityService) {
        this.cityService = cityService;
    }

    public List<City> execute() {
        return cityService.getAllCities();
    }
}
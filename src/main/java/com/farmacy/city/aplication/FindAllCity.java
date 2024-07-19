package com.farmacy.city.aplication;

import java.util.List;

import com.farmacy.city.domain.entity.City;
import com.farmacy.city.domain.service.CityService;

public class FindAllCity {
    public final CityService cityService;

    public FindAllCity(CityService cityService) {
        this.cityService = cityService;
    }

    public List<City> execute (City city) {
        return cityService.findAllCity();
    }
}
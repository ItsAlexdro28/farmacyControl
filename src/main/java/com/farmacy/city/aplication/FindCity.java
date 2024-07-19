package com.farmacy.city.aplication;

import java.util.Optional;

import com.farmacy.city.domain.entity.City;
import com.farmacy.city.domain.service.CityService;

public class FindCity {
    public final CityService cityService;

    public FindCity(CityService cityService) {
        this.cityService = cityService;
    }

    public Optional<City> execute (City city) {
        return cityService.findCity(city);
    }
}
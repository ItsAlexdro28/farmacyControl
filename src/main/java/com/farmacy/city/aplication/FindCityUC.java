package com.farmacy.city.aplication;

import java.util.Optional;

import com.farmacy.city.domain.entity.City;
import com.farmacy.city.domain.service.CityService;

public class FindCityUC {
    public final CityService cityService;

    public FindCityUC(CityService cityService) {
        this.cityService = cityService;
    }

    public Optional<City> execute (String city) {
        return cityService.findCity(city);
    }
}
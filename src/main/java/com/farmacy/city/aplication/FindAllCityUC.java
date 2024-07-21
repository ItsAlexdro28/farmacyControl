package com.farmacy.city.aplication;

import java.util.List;

import com.farmacy.city.domain.entity.City;
import com.farmacy.city.domain.service.CityService;

public class FindAllCityUC {
    public final CityService cityService;

    public FindAllCityUC(CityService cityService) {
        this.cityService = cityService;
    }

    public List<City> execute () {
        return cityService.findAllCity();
    }
}
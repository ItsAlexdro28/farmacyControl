package com.farmacy.city.domain.service;

import java.util.List;
import java.util.Optional;

import com.farmacy.city.domain.entity.City;

public interface CityService {
    public void createCity(City city);
    public void deleteCity(City city);
    public void editCity(City city);
    public Optional<City> findCity(City city);
    public List<City> findAllCity();
}

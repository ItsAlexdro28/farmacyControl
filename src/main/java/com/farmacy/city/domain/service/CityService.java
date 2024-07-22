package com.farmacy.city.domain.service;

import java.util.List;
import java.util.Optional;

import com.farmacy.city.domain.entity.City;

public interface CityService {
    public void createCity(City city);
    public void deleteCity(String city);
    public void editCity(String cityId, String field, String newValue);
    public Optional<City> findCity(String city);
    public List<City> findAllCity();
    public List<City> getAllCities();
}

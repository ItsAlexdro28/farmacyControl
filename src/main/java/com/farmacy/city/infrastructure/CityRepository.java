package com.farmacy.city.infrastructure;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

import javax.print.DocFlavor.STRING;

import com.farmacy.city.domain.entity.City;
import com.farmacy.city.domain.service.CityService;
import com.mysql.cj.xdevapi.PreparableStatement;

public class CityRepository implements CityService {
    private Connection connection;

    public CityRepository() {
        try {
            Properties props = new Properties();
            props.load(getClass().getClassLoader().getResourceAsStream("configdb.properties"));
            String url = props.getProperty("url");
            String user = props.getProperty("user");
            String password = props.getProperty("password");
            connection = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void createCity(City city) {
        try {
            String query = "INSERT INTO cities (id, name) VALUES (?, ?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, city.getId());
            ps.setString(2, city.getName());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteCity(String city) {
        String query = "DELETE FROM cities WHERE id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, city);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void editCity(String cityId, String field, String newValue) {
        String query = "UPDATE cities SET " + field + " = ? WHERE id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, newValue);
            ps.setString(2, cityId);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<City> findAllCity() {
        List<City> cities = new ArrayList<>();
        String query = "SELECT id, name FROM cities";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    City city = new City(rs.getString("id"), rs.getString("name"));
                    cities.add(city);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    return cities;
    }

    @Override
    public Optional<City> findCity(String city) {
        String query = "SELECT id, name FROM cities WHERE id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, city);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    City cityFound = new City(rs.getString("id"), rs.getString("name"));
                    return Optional.of(cityFound);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public List<City> getAllCities() {
        List<City> cities = new ArrayList<>();
        String query = "SELECT id, name FROM cities";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                City city = new City(rs.getString("id"), rs.getString("name"));
                cities.add(city);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cities;
    }
}

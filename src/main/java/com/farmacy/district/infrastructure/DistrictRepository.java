package com.farmacy.district.infrastructure;

import com.farmacy.district.domain.entity.District;
import com.farmacy.district.domain.service.DistrictService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

public class DistrictRepository implements DistrictService {
    private Connection connection;

    public DistrictRepository() {
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
    public void createDistrict(District district) {
        try {
            String query = "INSERT INTO districts (name, city) VALUES (?, ?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, district.getName());
            ps.setString(2, district.getCity());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteDistrict(String name) {
        try {
            String query = "DELETE FROM districts WHERE name = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, name);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void editDistrict(String name, String field, String newValue) {
        try {
            String query = "UPDATE districts SET " + field + " = ? WHERE name = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, newValue);
            ps.setString(2, name);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<District> findDistrict(String name) {
        try {
            String query = "SELECT id, name, city FROM districts WHERE name = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                District district = new District(rs.getInt("id"), rs.getString("name"), rs.getString("city"));
                return Optional.of(district);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public List<District> findAllDistricts() {
        List<District> districts = new ArrayList<>();
        try {
            String query = "SELECT id, name, city FROM districts";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                District district = new District(rs.getInt("id"), rs.getString("name"), rs.getString("city"));
                districts.add(district);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return districts;
    }

    @Override
    public List<District> getAllDistricts() {
        List<District> districts = new ArrayList<>();
        try {
            String query = "SELECT id, name, city FROM districts";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                District district = new District(rs.getInt("id"), rs.getString("name"), rs.getString("city"));
                districts.add(district);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return districts;
    }
}

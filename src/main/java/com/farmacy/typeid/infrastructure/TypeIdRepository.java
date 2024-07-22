package com.farmacy.typeid.infrastructure;

import com.farmacy.typeid.domain.entity.TypeId;
import com.farmacy.typeid.domain.service.TypeIdService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

public class TypeIdRepository implements TypeIdService {
    private Connection connection;

    public TypeIdRepository() {
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
    public void createTypeId(TypeId typeId) {
        try {
            String query = "INSERT INTO type_id (document) VALUES (?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, typeId.getDocument());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteTypeId(String document) {
        try {
            String query = "DELETE FROM type_id WHERE document = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, document);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void editTypeId(String document, String field, String newValue) {
        try {
            String query = "UPDATE type_id SET " + field + " = ? WHERE document = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, newValue);
            ps.setString(2, document);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<TypeId> findTypeId(String document) {
        try {
            String query = "SELECT id, document FROM type_id WHERE document = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, document);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                TypeId typeId = new TypeId(rs.getInt("id"), rs.getString("document"));
                return Optional.of(typeId);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public List<TypeId> findAllTypeIds() {
        List<TypeId> typeIds = new ArrayList<>();
        try {
            String query = "SELECT id, document FROM type_id";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                TypeId typeId = new TypeId(rs.getInt("id"), rs.getString("document"));
                typeIds.add(typeId);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return typeIds;
    }
}

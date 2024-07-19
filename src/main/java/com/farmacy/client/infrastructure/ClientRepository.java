package com.farmacy.client.infrastructure;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
//import java.sql.ResultSet;
import java.sql.SQLException;
//import java.util.List;
//import java.util.Optional;
import java.util.Properties;

import com.farmacy.client.domain.entity.Client;
import com.farmacy.client.domain.service.ClientService;

public class ClientRepository implements ClientService {
    private Connection connection;

    public ClientRepository() {
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
    public void createClient(Client client){
        try {
            String query = "INSERT INTO clients (id,type_id,names,last_names,age,birth_date,regist_date,district) VALUES (?,?,?,?,?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, client.getId());
            ps.setInt(2, client.getTypeId());
            ps.setString(3, client.getNames());
            ps.setString(4, client.getLastNames());
            ps.setInt(5, client.getAge());
            ps.setString(6, client.getBirthDate());
            ps.setString(7, client.getRegistDate());
            ps.setInt(8, client.getDistrict());
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
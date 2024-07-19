package com.farmacy;

import javax.swing.SwingUtilities;

import com.farmacy.city.aplication.CreateCity;
import com.farmacy.city.aplication.DeleteCity;
import com.farmacy.city.aplication.EditCity;
import com.farmacy.city.aplication.FindAllCity;
import com.farmacy.city.aplication.FindCity;
import com.farmacy.city.domain.service.CityService;
import com.farmacy.city.infrastructure.CityRepository;
import com.farmacy.city.infrastructure.CityUI;
import com.farmacy.menu.infrastructure.MenuUI;
import com.mysql.cj.x.protobuf.MysqlxCrud.Delete;

public class Main {
    public static void main(String[] args) {
        CityService cityService = new CityRepository();
        CreateCity createCity = new CreateCity(cityService);
        DeleteCity deleteCity = new DeleteCity(cityService);
        EditCity editCity = new EditCity(cityService);
        FindCity findCity = new FindCity(cityService);
        FindAllCity findAllCity = new FindAllCity(cityService);
        CityUI cityUI = new CityUI(createCity, deleteCity, findCity);
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MenuUI(cityUI);
            }
        });  
    }
}
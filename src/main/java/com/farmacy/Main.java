package com.farmacy;

import javax.swing.SwingUtilities;

import com.farmacy.city.aplication.CreateCityUC;
import com.farmacy.city.aplication.DeleteCityUC;
import com.farmacy.city.aplication.EditCityUC;
import com.farmacy.city.aplication.FindAllCityUC;
import com.farmacy.city.aplication.FindCityUC;
import com.farmacy.city.domain.service.CityService;
import com.farmacy.city.infrastructure.CityRepository;
import com.farmacy.city.infrastructure.CityUI;
import com.farmacy.menu.infrastructure.MenuUI;
import com.mysql.cj.x.protobuf.MysqlxCrud.Delete;

public class Main {
    public static void main(String[] args) {
        CityService cityService = new CityRepository();
        CreateCityUC createCity = new CreateCityUC(cityService);
        DeleteCityUC deleteCity = new DeleteCityUC(cityService);
        EditCityUC editCity = new EditCityUC(cityService);
        FindCityUC findCity = new FindCityUC(cityService);
        FindAllCityUC findAllCity = new FindAllCityUC(cityService);
        CityUI cityUI = new CityUI(createCity, deleteCity, findCity, editCity, findAllCity);


        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MenuUI(cityUI);
            }
        });  
    }
}
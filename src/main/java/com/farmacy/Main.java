package com.farmacy;

import javax.swing.SwingUtilities;

import com.farmacy.city.aplication.CreateCityUC;
import com.farmacy.city.aplication.DeleteCityUC;
import com.farmacy.city.aplication.EditCityUC;
import com.farmacy.city.aplication.FindAllCityUC;
import com.farmacy.city.aplication.FindCityUC;
import com.farmacy.city.aplication.GetAllCitiesUC;
import com.farmacy.city.domain.service.CityService;
import com.farmacy.city.infrastructure.CityRepository;
import com.farmacy.city.infrastructure.CityUI;
import com.farmacy.district.aplication.CreateDistrictUC;
import com.farmacy.district.aplication.DeleteDistrictUC;
import com.farmacy.district.aplication.EditDistrictUC;
import com.farmacy.district.aplication.FindAllDistrictsUC;
import com.farmacy.district.aplication.FindDistrictUC;
import com.farmacy.district.domain.entity.District;
import com.farmacy.district.domain.service.DistrictService;
import com.farmacy.district.infrastructure.DistrictRepository;
import com.farmacy.district.infrastructure.DistrictUI;
import com.farmacy.menu.infrastructure.MenuUI;
import com.farmacy.typeid.aplication.CreateTypeIdUC;
import com.farmacy.typeid.domain.service.TypeIdService;
import com.farmacy.typeid.infrastructure.TypeIdRepository;
import com.mysql.cj.x.protobuf.MysqlxCrud.Delete;

public class Main {
    public static void main(String[] args) {
        CityService cityService = new CityRepository();
        CreateCityUC createCity = new CreateCityUC(cityService);
        DeleteCityUC deleteCity = new DeleteCityUC(cityService);
        EditCityUC editCity = new EditCityUC(cityService);
        FindCityUC findCity = new FindCityUC(cityService);
        FindAllCityUC findAllCity = new FindAllCityUC(cityService);
        GetAllCitiesUC getAllCities = new GetAllCitiesUC(cityService);
        CityUI cityUI = new CityUI(createCity, deleteCity, findCity, editCity, findAllCity);

        DistrictService districtService = new DistrictRepository();
        CreateDistrictUC createDistrict = new CreateDistrictUC(districtService);
        DeleteDistrictUC deleteDistrict = new DeleteDistrictUC(districtService);
        EditDistrictUC editDistrict = new EditDistrictUC(districtService);
        FindDistrictUC findDistrict = new FindDistrictUC(districtService);
        FindAllDistrictsUC findAllDistricts = new FindAllDistrictsUC(districtService);
        DistrictUI districtUI = new DistrictUI(createDistrict, deleteDistrict, findDistrict, editDistrict, findAllDistricts, getAllCities);

        TypeIdService typeIdService = new TypeIdRepository();
        CreateTypeIdUC createTypeIdUC = new CreateTypeIdUC(typeIdService);


        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MenuUI(cityUI, districtUI);
            }
        });  
    }
}
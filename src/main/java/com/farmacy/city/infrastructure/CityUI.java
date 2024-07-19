package com.farmacy.city.infrastructure;

import javax.swing.JOptionPane;

import com.farmacy.city.aplication.CreateCityUC;
import com.farmacy.city.aplication.DeleteCity;
import com.farmacy.city.aplication.FindCity;
import com.farmacy.city.domain.entity.City;

public class CityUI {
    private CreateCityUC createCityUC;
    private DeleteCity deleteCity;
    private FindCity findCity;
    private int option;
    Object[] options = {"Crear Ciudad", "Eliminar Ciudad", "Buscar ciudad"};

    public CityUI(CreateCityUC createCityUC, DeleteCity deleteCity, FindCity findCity) {
        this.createCityUC = createCityUC;
        this.deleteCity = deleteCity;
        this.findCity = findCity;
    }

    public void run() {
        int option = JOptionPane.showOptionDialog(null, "Mensaje", "Titulo", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        //int option = JOptionPane.sho
        switch (option) {
            case 0:
                City city = new City(null, null);
                city.setId(JOptionPane.showInputDialog(null, "Acronimo Ciudad", "Titulo"));
                city.setName(JOptionPane.showInputDialog(null, "Nommbre Ciudad", "Titulo"));
                createCityUC.execute(city);
                break;
            case 1:
                JOptionPane.showMessageDialog(null, "2", "Title", 1); 
                break;
            case 2:
                JOptionPane.showMessageDialog(null, "3", "Title", 1); 
                break;
            // case 3:
            //    JOptionPane.showMessageDialog(null, "4", "Title", 1); 
            //     break;
        
            default:
                break;
        }
    }
    
}

package com.farmacy.city.infrastructure;

import javax.swing.JOptionPane;

import com.farmacy.city.aplication.CreateCity;
import com.farmacy.city.aplication.DeleteCity;
import com.farmacy.city.aplication.FindCity;

public class CityUI {
    private CreateCity createCity;
    private DeleteCity deleteCity;
    private FindCity findCity;

    public CityUI(CreateCity createCity, DeleteCity deleteCity, FindCity findCity) {
        this.createCity = createCity;
        this.deleteCity = deleteCity;
        this.findCity = findCity;
    }

    public void run() {
        JOptionPane.showMessageDialog(null, "Funciona");
    }
    
}

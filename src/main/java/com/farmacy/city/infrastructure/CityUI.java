package com.farmacy.city.infrastructure;

import java.util.List;
import java.util.Optional;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.farmacy.city.aplication.CreateCityUC;
import com.farmacy.city.aplication.DeleteCityUC;
import com.farmacy.city.aplication.FindCityUC;
import com.farmacy.city.aplication.EditCityUC;
import com.farmacy.city.aplication.FindAllCityUC;
import com.farmacy.city.domain.entity.City;

public class CityUI {
    private CreateCityUC createCityUC;
    private DeleteCityUC deleteCityUC;
    private FindCityUC findCityUC;
    private EditCityUC editCityUC;
    private FindAllCityUC findAllCityUC; 
    Object[] options = {"Crear Ciudad", "Eliminar Ciudad", "Buscar ciudad", "Editar ciudad", "Mostrar ciudades"};

    public CityUI(CreateCityUC createCityUC, DeleteCityUC deleteCityUC, FindCityUC findCityUC, EditCityUC editCityUC, FindAllCityUC findAllCityUC) {
        this.createCityUC = createCityUC;
        this.deleteCityUC = deleteCityUC;
        this.findCityUC = findCityUC;
        this.editCityUC = editCityUC;
        this.findAllCityUC = findAllCityUC;
    }

    public void run() {
        int option = JOptionPane.showOptionDialog(null, "Que deseas hacer", "Ciudades", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        //int option = JOptionPane.sho
        switch (option) {
            case 0:
                City city = new City(null, null);
                city.setId(JOptionPane.showInputDialog(null, "Acronimo Ciudad"));
                System.err.println(city.getId());
                city.setName(JOptionPane.showInputDialog(null, "Nommbre Ciudad"));
                System.err.println(city.getName());
                createCityUC.execute(city);
                break;
            case 1:
                String cityDelete = JOptionPane.showInputDialog(null, "Acronimo de la Ciudad");
                try {
                    deleteCityUC.execute(cityDelete);
                } catch (Exception e) {
                    // TODO: handle exception
                    System.err.println("Something dosen't work :(");
                }

                break;
            case 2:
                String cityFind = JOptionPane.showInputDialog(null, "Acronimo de la Ciudad");
                try {
                    Optional<City> cityOptional = findCityUC.execute(cityFind);
                    if (cityOptional.isPresent()) {
                        City cityReturn = cityOptional.get();
                        String[] columnTitle = {"id", "name"};
                        Object[][] data = {
                            {cityReturn.getId(), cityReturn.getName()}
                        };

                        JTable findTable = new JTable(data, columnTitle);
                        JOptionPane.showMessageDialog(null, new JScrollPane(findTable), "Ciudad enontrada", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Esta ciudad no se ha encontrado", "Info ciudad", JOptionPane.WARNING_MESSAGE);
                    }
                } catch (Exception e) {
                    // TODO: handle exception
                    System.err.println("Something dosen't work :(");
                }
                break;
            case 3:
                String cityEdit = JOptionPane.showInputDialog(null, "Acronimo de la Ciudad");
                try {
                    Optional<City> cityOptional = findCityUC.execute(cityEdit);
                    if (cityOptional.isPresent()) {
                        Object[] editOptions = {"id", "name"};
                        String editField = (String) JOptionPane.showInputDialog(null, "Que deseas editar", "Editar ciudad", JOptionPane.QUESTION_MESSAGE, null, editOptions, editOptions[0]);
                        String newValue = JOptionPane.showInputDialog(null, "Nuevo valor para " + editField);
                        editCityUC.execute(cityEdit, editField, newValue);
                    } else {
                        JOptionPane.showMessageDialog(null, "Esta ciudad no se ha encontrado", "Info ciudad", JOptionPane.WARNING_MESSAGE);
                    }
                } catch (Exception e) {
                    System.err.println("Something doesn't work :(");
                }
                break;
            case 4:
                try {
                    List<City> allCities = findAllCityUC.execute();
                    if (allCities.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "No se han encontrado ciudades", "Info ciudades", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        String[] columnTitle = {"id", "nombre"};
                        Object[][] data = new Object[allCities.size()][2];
                        for (int i = 0; i < allCities.size(); i++) {
                            City cityIterator = allCities.get(i);
                            data[i][0] = cityIterator.getId();
                            data[i][1] = cityIterator.getName();
                        }

                        JTable allCitiesTable = new JTable(data, columnTitle);
                        JOptionPane.showMessageDialog(null, new JScrollPane(allCitiesTable), "Todas las ciudades", JOptionPane.INFORMATION_MESSAGE);
                    }
                } catch (Exception e) {
                    System.err.println("Something doesn't work :(");
                }
            default:
                break;
        }
    }
    
}

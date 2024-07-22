package com.farmacy.district.infrastructure;

import java.util.List;
import java.util.Optional;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.farmacy.city.aplication.GetAllCitiesUC;
import com.farmacy.city.domain.entity.City;
import com.farmacy.district.aplication.CreateDistrictUC;
import com.farmacy.district.aplication.DeleteDistrictUC;
import com.farmacy.district.aplication.EditDistrictUC;
import com.farmacy.district.aplication.FindAllDistrictsUC;
import com.farmacy.district.aplication.FindDistrictUC;
import com.farmacy.district.domain.entity.District;

public class DistrictUI {
    private CreateDistrictUC createDistrictUC;
    private DeleteDistrictUC deleteDistrictUC;
    private FindDistrictUC findDistrictUC;
    private EditDistrictUC editDistrictUC;
    private FindAllDistrictsUC findAllDistrictsUC;
    private GetAllCitiesUC getAllCitiesUC;
    Object[] options = {"Crear Barrio", "Eliminar Barrio", "Buscar Barrio", "Editar Barrio", "Mostrar Barrios"};

    public DistrictUI(CreateDistrictUC createDistrictUC, DeleteDistrictUC deleteDistrictUC, FindDistrictUC findDistrictUC, EditDistrictUC editDistrictUC, FindAllDistrictsUC findAllDistrictsUC,  GetAllCitiesUC getAllCitiesUC) {
        this.createDistrictUC = createDistrictUC;
        this.deleteDistrictUC = deleteDistrictUC;
        this.findDistrictUC = findDistrictUC;
        this.editDistrictUC = editDistrictUC;
        this.findAllDistrictsUC = findAllDistrictsUC;
        this.getAllCitiesUC = getAllCitiesUC;
    }

    public void run() {
        int option = JOptionPane.showOptionDialog(null, "Que deseas hacer", "Barrios", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

        switch (option) {
            case 0:
                List<City> cities = getAllCitiesUC.execute();
                String[] cityOptions = new String[cities.size()];
                for (int i = 0; i < cities.size(); i++) {
                    cityOptions[i] = cities.get(i).getName();
                }

                JComboBox<String> cityDropdown = new JComboBox<>(cityOptions);
                String districtName = JOptionPane.showInputDialog(null, "Nombre del Barrio");

                JOptionPane.showMessageDialog(null, cityDropdown, "Selecciona una Ciudad", JOptionPane.QUESTION_MESSAGE);
                String selectedCityName = (String) cityDropdown.getSelectedItem();
                String selectedCityId = cities.stream().filter(c -> c.getName().equals(selectedCityName)).findFirst().get().getId();

                District newDistrict = new District(0, districtName, selectedCityId);
                createDistrictUC.execute(newDistrict);
                break;
            case 1: 
                String districtNameToDelete = JOptionPane.showInputDialog(null, "Nombre del barrio a Eliminar");
                deleteDistrictUC.execute(districtNameToDelete);
                break;
            case 2: 
                String districtToFind = JOptionPane.showInputDialog(null, "name del barrio a Buscar");
                Optional<District> foundDistrict = findDistrictUC.execute(districtToFind);
                if (foundDistrict.isPresent()) {
                    District district = foundDistrict.get();
                    String[] columnTitle = {"id", "name", "city"};
                    Object[][] data = {
                        {district.getId(), district.getName(), district.getCity()}
                    };

                    JTable findTable = new JTable(data, columnTitle);
                    JOptionPane.showMessageDialog(null, new JScrollPane(findTable), "barrio Encontrado", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Este barrio no se ha encontrado", "Info barrio", JOptionPane.WARNING_MESSAGE);
                }
                break;
            case 3: 
                String districtNameToEdit = JOptionPane.showInputDialog(null, "Nombre del Barrio a Editar");
            
                Optional<District> foundEditDistrict = findDistrictUC.execute(districtNameToEdit);
                if (foundEditDistrict.isPresent()) {
                    //District district = foundEditDistrict.get();
                    String[] fields = {"name", "city"};
                    String fieldToEdit = (String) JOptionPane.showInputDialog(null, "Selecciona el campo a editar", "Editar Barrio", JOptionPane.QUESTION_MESSAGE, null, fields, fields[0]);
                    String newValue = "";
                    if (fieldToEdit.equals("city")) {
                        List<City> citiesListEdit = getAllCitiesUC.execute();
                        String[] cityOptionsEdit = new String[citiesListEdit.size()];
                        for (int i = 0; i < citiesListEdit.size(); i++) {
                            cityOptionsEdit[i] = citiesListEdit.get(i).getName();
                        }
                        JComboBox<String> cityDropdownEdit = new JComboBox<>(cityOptionsEdit);
                        JOptionPane.showMessageDialog(null, cityDropdownEdit, "Selecciona una Ciudad", JOptionPane.QUESTION_MESSAGE);
                        String selectedCityNameEdit = (String) cityDropdownEdit.getSelectedItem();
                        newValue = citiesListEdit.stream().filter(c -> c.getName().equals(selectedCityNameEdit)).findFirst().get().getId();
                    } else {
                        newValue = JOptionPane.showInputDialog(null, "Nuevo valor para " + fieldToEdit);
                    }
                    editDistrictUC.execute(districtNameToEdit, fieldToEdit, newValue);
                } else {
                    JOptionPane.showMessageDialog(null, "Este barrio no se ha encontrado", "Info barrio", JOptionPane.WARNING_MESSAGE);
                }
                break;
            case 4: // Assuming option 4 is for finding all
                List<District> allDistricts = findAllDistrictsUC.execute();
                if (allDistricts.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "No se encontraron barrios", "Info barrios", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    String[] columnTitle = {"id", "name", "city"};
                    Object[][] data = new Object[allDistricts.size()][3];
                    for (int i = 0; i < allDistricts.size(); i++) {
                        District district = allDistricts.get(i);
                        data[i][0] = district.getId();
                        data[i][1] = district.getName();
                        data[i][2] = district.getCity();
                    }

                    JTable allDistrictsTable = new JTable(data, columnTitle);
                    JOptionPane.showMessageDialog(null, new JScrollPane(allDistrictsTable), "Todos los barrios", JOptionPane.INFORMATION_MESSAGE);
                }
                break;
            default:
                break;
        }
    }
}

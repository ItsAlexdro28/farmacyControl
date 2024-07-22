package com.farmacy.client.infrastructure;

import java.util.List;
import java.util.Optional;
import java.util.Date;  
import java.util.Calendar; 
import java.text.SimpleDateFormat;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.text.DateFormat;
import com.farmacy.city.aplication.GetAllCitiesUC;
import com.farmacy.city.domain.entity.City;
import com.farmacy.client.aplication.CreateClientUC;
import com.farmacy.client.aplication.DeleteClientUC;
import com.farmacy.client.aplication.EditClientUC;
import com.farmacy.client.aplication.FindAllClientsUC;
import com.farmacy.client.aplication.FindClientUC;
import com.farmacy.district.aplication.GetAllDistrictsUC;
import com.farmacy.typeid.aplication.GetAllTypeIdsUC;
import com.farmacy.client.domain.entity.Client;
import com.farmacy.district.domain.entity.District;
import com.farmacy.typeid.domain.entity.TypeId;
import com.toedter.calendar.JDateChooser;

public class ClientUI {
    private CreateClientUC createClientUC;
    private DeleteClientUC deleteClientUC;
    private FindClientUC findClientUC;
    private EditClientUC editClientUC;
    private FindAllClientsUC findAllClientsUC;
    private GetAllTypeIdsUC getAllTypeIdsUC;
    private GetAllDistrictsUC getAllDistrictsUC;

    Object[] options = {"Crear Cliente", "Eliminar Cliente", "Buscar Cliente", "Editar Cliente", "Mostrar Clientes"};

    public ClientUI(CreateClientUC createClientUC, DeleteClientUC deleteClientUC, FindClientUC findClientUC, EditClientUC editClientUC, FindAllClientsUC findAllClientsUC,GetAllTypeIdsUC getAllTypeIdsUC, GetAllDistrictsUC getAllDistrictsUC) {
        this.createClientUC = createClientUC;
        this.deleteClientUC = deleteClientUC;
        this.findClientUC = findClientUC;
        this.editClientUC = editClientUC;
        this.findAllClientsUC = findAllClientsUC;
        this.getAllTypeIdsUC = getAllTypeIdsUC;
        this.getAllDistrictsUC = getAllDistrictsUC;
    }

    public void run() {
        int option = JOptionPane.showOptionDialog(null, "Que deseas hacer", "Clientes", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

        switch (option) {
            case 0:
                // Collect all type IDs
                List<TypeId> typeIds = getAllTypeIdsUC.execute();
                String[] typeIdOptions = new String[typeIds.size()];
                for (int i = 0; i < typeIds.size(); i++) {
                    typeIdOptions[i] = typeIds.get(i).getDocument();
                }

                JComboBox<String> typeIdDropdown = new JComboBox<>(typeIdOptions);
                JOptionPane.showMessageDialog(null, typeIdDropdown, "Selecciona un Tipo de ID", JOptionPane.QUESTION_MESSAGE);
                String selectedTypeIdDocument = (String) typeIdDropdown.getSelectedItem();
                int selectedTypeId = typeIds.stream().filter(t -> t.getDocument().equals(selectedTypeIdDocument)).findFirst().get().getId();

                int id = Integer.parseInt(JOptionPane.showInputDialog(null, "Numero de identidad"));

                List<District> districts = getAllDistrictsUC.execute();
                String[] districtOptions = new String[districts.size()];
                for (int i = 0; i < districts.size(); i++) {
                    districtOptions[i] = districts.get(i).getName();
                }

                JComboBox<String> districtDropdown = new JComboBox<>(districtOptions);
                JOptionPane.showMessageDialog(null, districtDropdown, "Selecciona un Distrito", JOptionPane.QUESTION_MESSAGE);
                String selectedDistrictName = (String) districtDropdown.getSelectedItem();
                int selectedDistrictId = districts.stream().filter(d -> d.getName().equals(selectedDistrictName)).findFirst().get().getId();

                String names = JOptionPane.showInputDialog(null, "Nombres del Cliente");
                String lastNames = JOptionPane.showInputDialog(null, "Apellidos del Cliente");
                int age = Integer.parseInt(JOptionPane.showInputDialog(null, "Edad del Cliente"));

                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                JDateChooser dateBirthDate = new JDateChooser();
                JOptionPane.showMessageDialog(null, dateBirthDate, "Selecciona la Fecha de Nacimiento", JOptionPane.QUESTION_MESSAGE);
                String birthDate = dateFormat.format(dateBirthDate.getDate());

                JDateChooser dateRegistDate = new JDateChooser();
                JOptionPane.showMessageDialog(null, dateRegistDate, "Selecciona la Fecha de Registro", JOptionPane.QUESTION_MESSAGE);
                String registDate = dateFormat.format(dateRegistDate.getDate());

                Client newClient = new Client(id, selectedTypeId, names, lastNames, age, birthDate, registDate, selectedDistrictId);
                System.err.println(newClient.getBirthDate());
                createClientUC.execute(newClient);
                break;
            case 1:
                int idToDelete = Integer.parseInt(JOptionPane.showInputDialog(null, "ID del cliente a eliminar"));
                deleteClientUC.execute(idToDelete);
                break;
            case 2:
                int idToFind = Integer.parseInt(JOptionPane.showInputDialog(null, "ID del cliente a buscar"));
                Optional<Client> foundClient = findClientUC.execute(idToFind);
                if (foundClient.isPresent()) {
                    JOptionPane.showMessageDialog(null, "Client founded:\nID: " + foundClient.get().getId() + "\nIDType: " + foundClient.get().getTypeId() + "\nNombre: " + foundClient.get().getNames() + "\nLastName: " + foundClient.get().getLastNames() + "\nAge: " + foundClient.get().getAge() + "\nBirthDate: " + foundClient.get().getBirthDate() + "\nRegistration Date: " + foundClient.get().getRegistDate() + "\nDistrict ID: " + foundClient.get().getDistrict(),
                    "Client Info", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Este cliente no se ha encontrado", "Info Cliente", JOptionPane.WARNING_MESSAGE);
                }
                break;

            // Other cases...
            default:
                break;
        }
    }
}
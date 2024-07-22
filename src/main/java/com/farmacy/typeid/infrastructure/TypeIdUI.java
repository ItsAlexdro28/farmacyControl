package com.farmacy.typeid.infrastructure;

import java.util.List;
import java.util.Optional;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.farmacy.typeid.aplication.CreateTypeIdUC;
import com.farmacy.typeid.aplication.DeleteTypeIdUC;
import com.farmacy.typeid.aplication.EditTypeIdUC;
import com.farmacy.typeid.aplication.FindAllTypeIdsUC;
import com.farmacy.typeid.aplication.FindTypeIdUC;
import com.farmacy.typeid.domain.entity.TypeId;

public class TypeIdUI {
    private CreateTypeIdUC createTypeIdUC;
    private DeleteTypeIdUC deleteTypeIdUC;
    private FindTypeIdUC findTypeIdUC;
    private EditTypeIdUC editTypeIdUC;
    private FindAllTypeIdsUC findAllTypeIdsUC;
    Object[] options = {"Crear Tipo de ID", "Eliminar Tipo de ID", "Buscar Tipo de ID", "Editar Tipo de ID", "Mostrar Tipos de ID"};

    public TypeIdUI(CreateTypeIdUC createTypeIdUC, DeleteTypeIdUC deleteTypeIdUC, FindTypeIdUC findTypeIdUC, EditTypeIdUC editTypeIdUC, FindAllTypeIdsUC findAllTypeIdsUC) {
        this.createTypeIdUC = createTypeIdUC;
        this.deleteTypeIdUC = deleteTypeIdUC;
        this.findTypeIdUC = findTypeIdUC;
        this.editTypeIdUC = editTypeIdUC;
        this.findAllTypeIdsUC = findAllTypeIdsUC;
    }

    public void run() {
        int option = JOptionPane.showOptionDialog(null, "Que deseas hacer", "Tipos de ID", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

        switch (option) {
            case 0:
                String document = JOptionPane.showInputDialog(null, "Documento");
                TypeId newTypeId = new TypeId(0, document);
                createTypeIdUC.execute(newTypeId);
                break;
            case 1: 
                String documentToDelete = JOptionPane.showInputDialog(null, "Documento a Eliminar");
                deleteTypeIdUC.execute(documentToDelete);
                break;
            case 2: 
                String documentToFind = JOptionPane.showInputDialog(null, "Documento a Buscar");
                Optional<TypeId> foundTypeId = findTypeIdUC.execute(documentToFind);
                if (foundTypeId.isPresent()) {
                    TypeId typeId = foundTypeId.get();
                    String[] columnTitle = {"id", "document"};
                    Object[][] data = {
                        {typeId.getId(), typeId.getDocument()}
                    };

                    JTable findTable = new JTable(data, columnTitle);
                    JOptionPane.showMessageDialog(null, new JScrollPane(findTable), "Tipo de ID Encontrado", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Este Tipo de ID no se ha encontrado", "Info Tipo de ID", JOptionPane.WARNING_MESSAGE);
                }
                break;
            case 3: 
                String documentToEdit = JOptionPane.showInputDialog(null, "Documento a Editar");
            
                Optional<TypeId> foundEditTypeId = findTypeIdUC.execute(documentToEdit);
                if (foundEditTypeId.isPresent()) {
                    String[] fields = {"document"};
                    String fieldToEdit = (String) JOptionPane.showInputDialog(null, "Selecciona el campo a editar", "Editar Tipo de ID", JOptionPane.QUESTION_MESSAGE, null, fields, fields[0]);
                    String newValue = JOptionPane.showInputDialog(null, "Nuevo valor para " + fieldToEdit);
                    editTypeIdUC.execute(documentToEdit, fieldToEdit, newValue);
                } else {
                    JOptionPane.showMessageDialog(null, "Este Tipo de ID no se ha encontrado", "Info Tipo de ID", JOptionPane.WARNING_MESSAGE);
                }
                break;
            case 4: 
                List<TypeId> allTypeIds = findAllTypeIdsUC.execute();
                if (allTypeIds.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "No se encontraron Tipos de ID", "Info Tipos de ID", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    String[] columnTitle = {"id", "document"};
                    Object[][] data = new Object[allTypeIds.size()][2];
                    for (int i = 0; i < allTypeIds.size(); i++) {
                        TypeId typeId = allTypeIds.get(i);
                        data[i][0] = typeId.getId();
                        data[i][1] = typeId.getDocument();
                    }

                    JTable allTypeIdsTable = new JTable(data, columnTitle);
                    JOptionPane.showMessageDialog(null, new JScrollPane(allTypeIdsTable), "Todos los Tipos de ID", JOptionPane.INFORMATION_MESSAGE);
                }
                break;
            default:
                break;
        }
    }
}

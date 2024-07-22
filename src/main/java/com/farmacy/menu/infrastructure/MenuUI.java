package com.farmacy.menu.infrastructure;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.farmacy.city.infrastructure.CityUI;
import com.farmacy.client.infrastructure.ClientUI;
import com.farmacy.district.domain.entity.District;
import com.farmacy.district.infrastructure.DistrictUI;
import com.farmacy.typeid.infrastructure.TypeIdUI;

public class MenuUI extends JFrame {
    private CityUI cityUI;
    private ClientUI clientUI;
    private TypeIdUI typeIdUI;
    private DistrictUI districtUI;

    public MenuUI(CityUI cityUI, DistrictUI districtUI, TypeIdUI typeIdUI) {
        this.cityUI = cityUI;
        this.districtUI = districtUI;
        this.typeIdUI = typeIdUI;
        
        setTitle("Titulo");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(2, 3, 10, 10));

        JButton button1 = new JButton("Ciudad");
        JButton button2 = new JButton("Barrio");
        JButton button3 = new JButton("Cliente");
        JButton button4 = new JButton("Medicamento");
        JButton button5 = new JButton("Tipo de documennto");

        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            cityUI.run();
            }
        });
        
        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            districtUI.run();
            }
        });

        button5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            typeIdUI.run();
            }
        });
        buttonPanel.add(button1);
        buttonPanel.add(button2);
        buttonPanel.add(button3);
        buttonPanel.add(button4);
        buttonPanel.add(button5);

        getContentPane().add(buttonPanel, BorderLayout.CENTER);
        
        setLocationRelativeTo(null);
        setVisible(true);

    }


}

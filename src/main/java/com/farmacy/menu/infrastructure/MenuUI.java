package com.farmacy.menu.infrastructure;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.farmacy.city.infrastructure.CityUI;
import com.farmacy.client.infrastructure.ClientUI;
import com.farmacy.district.domain.entity.District;
import com.farmacy.district.infrastructure.DistrictUI;

public class MenuUI extends JFrame {
    private CityUI cityUI;
    private ClientUI clientUI;
    private DistrictUI districtUI;

    public MenuUI(CityUI cityUI, DistrictUI districtUI) {
        this.cityUI = cityUI;
        this.districtUI = districtUI;
        
        setTitle("Titulo");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(2, 2, 10, 10));

        JButton button1 = new JButton("Ciudad");
        JButton button2 = new JButton("Barrio");
        JButton button3 = new JButton("Cliente");
        JButton button4 = new JButton("Medicamento");

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

        buttonPanel.add(button1);
        buttonPanel.add(button2);
        buttonPanel.add(button3);
        buttonPanel.add(button4);

        getContentPane().add(buttonPanel, BorderLayout.CENTER);
        
        setLocationRelativeTo(null);
        setVisible(true);

    }


}

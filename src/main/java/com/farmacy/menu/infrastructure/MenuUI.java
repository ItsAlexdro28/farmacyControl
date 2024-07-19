package com.farmacy.menu.infrastructure;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.farmacy.city.infrastructure.CityUI;
import com.farmacy.client.infrastructure.ClientUI;

public class MenuUI extends JFrame {
    private CityUI cityUI;
    private ClientUI clientUI;

    public MenuUI(CityUI cityUI) {
        this.cityUI = cityUI;
        
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

        buttonPanel.add(button1);
        buttonPanel.add(button2);
        buttonPanel.add(button3);
        buttonPanel.add(button4);

        getContentPane().add(buttonPanel, BorderLayout.CENTER);
        
        setLocationRelativeTo(null);
        setVisible(true);

    }


}

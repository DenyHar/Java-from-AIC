package org.example.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Application{
    public Application(){

        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        GridLayout gridLayout = new GridLayout(4,1);
        gridLayout.setVgap(5);
        panel.setLayout(gridLayout);
        panel.setPreferredSize(new Dimension(300,300));
        JButton insertButton = new JButton("Додати");
        JButton selectButton = new JButton("Показати");
        JButton updateButton = new JButton("Змінити");
        JButton deleteButton = new JButton("Видалити");

        panel.add(insertButton);
        panel.add(selectButton);
        panel.add(updateButton);
        panel.add(deleteButton);

        JFrame frame = new MyWindow("Менеджер кав'ярні");
        frame.add(panel);

        insertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                new InsertWindow(frame);
            }
        });
        selectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                new SelectWindow(frame);
            }
        });
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                new UpdateWindow(frame);
            }
        });
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DeleteWindow(frame);
            }
        });

        frame.pack();
    }
}

package org.example.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateWindow {
    public UpdateWindow(JFrame frame){
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        GridLayout gridLayout = new GridLayout(5,1);
        gridLayout.setVgap(5);
        panel.setLayout(gridLayout);
        panel.setPreferredSize(new Dimension(300,350));

        JButton updateStaff = new JButton("Змінити дані працівника");
        JButton updateClient = new JButton("Змінити дані клієнта");
        JButton updateMenu = new JButton("Змінити дані пункту меню");
        JButton updateOrder = new JButton("Змінити дані замовлення");
        JButton updateSchedule = new JButton("Змінити дані про робочу зміну");

        panel.add(updateStaff);
        panel.add(updateClient);
        panel.add(updateMenu);
        panel.add(updateOrder);
        panel.add(updateSchedule);

        updateStaff.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });


        JDialog dialog = new DialogWindow(frame, "Меню Видалення");
        dialog.add(panel);
        dialog.pack();
        dialog.setVisible(true);
    }
}

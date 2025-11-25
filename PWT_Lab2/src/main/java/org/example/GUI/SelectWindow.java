package org.example.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectWindow {
    public SelectWindow(JFrame frame){
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        GridLayout gridLayout = new GridLayout(5,1);
        gridLayout.setVgap(5);
        panel.setLayout(gridLayout);
        panel.setPreferredSize(new Dimension(300,350));

        JButton selectStaff = new JButton("Показати працівника");
        JButton selectClient = new JButton("Показати клієнта");
        JButton selectMenu = new JButton("Показати пункт меню");
        JButton selectOrder = new JButton("Показати замовлення");
        JButton selectSchedule = new JButton("Показати робочу зміну");

        panel.add(selectStaff);
        panel.add(selectClient);
        panel.add(selectMenu);
        panel.add(selectOrder);
        panel.add(selectSchedule);

        selectStaff.addActionListener(new ActionListener() {
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

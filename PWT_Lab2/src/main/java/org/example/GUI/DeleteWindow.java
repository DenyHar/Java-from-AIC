package org.example.GUI;

import com.github.lgooddatepicker.components.CalendarPanel;
import org.example.DBDelete;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class DeleteWindow {
    public DeleteWindow(JFrame frame){
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        GridLayout gridLayout = new GridLayout(6,1);
        gridLayout.setVgap(5);
        panel.setLayout(gridLayout);
        panel.setPreferredSize(new Dimension(300,350));

        JButton deleteStaff = new JButton("Видалити працівника");
        JButton deleteClient = new JButton("Видалити клієнта");
        JButton deleteMenu = new JButton("Видалити пункт меню");
        JButton deleteOrder = new JButton("Видалити замовлення");
        JButton deleteSchedule = new JButton("Видалити робочу зміну");

        JTextField resultField = new JTextField();
        resultField.setEditable(false);

        panel.add(deleteStaff);
        panel.add(deleteClient);
        panel.add(deleteMenu);
        panel.add(deleteOrder);
        panel.add(deleteSchedule);
        panel.add(resultField);

        deleteStaff.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = JOptionPane.showInputDialog(null, "Введіть ID", "Ввід ID працівника", JOptionPane.QUESTION_MESSAGE);
                if (id != null && !id.isBlank()){
                    try {
                        resultField.setText(DBDelete.DeleteStaff(Integer.parseInt(id)));
                    }catch (NumberFormatException _){
                        resultField.setText("ID має бути цілочисельним числом");
                    }
                }

            }
        });
        deleteClient.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = JOptionPane.showInputDialog(null, "Введіть ID", "Ввід ID клієнта", JOptionPane.QUESTION_MESSAGE);
                if (id != null && !id.isBlank()){
                    try {
                        resultField.setText(DBDelete.DeleteClient(Integer.parseInt(id)));
                    }catch (NumberFormatException _){
                        resultField.setText("ID має бути цілочисельним числом");
                    }
                }
            }
        });
        deleteMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = JOptionPane.showInputDialog(null, "Введіть ID", "Ввід ID пункту меню", JOptionPane.QUESTION_MESSAGE);
                if (id != null && !id.isBlank()){
                    try {
                        resultField.setText(DBDelete.DeleteMenu(Integer.parseInt(id)));
                    }catch (NumberFormatException _){
                        resultField.setText("ID має бути цілочисельним числом");
                    }
                }
            }
        });
        deleteOrder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = JOptionPane.showInputDialog(null, "Введіть ID", "Ввід ID замовлення", JOptionPane.QUESTION_MESSAGE);
                if (id != null && !id.isBlank()){
                    try {
                        resultField.setText(DBDelete.DeleteOrder(Integer.parseInt(id)));
                    }catch (NumberFormatException _){
                        resultField.setText("ID має бути цілочисельним числом");
                    }
                }
            }
        });
        deleteSchedule.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CalendarPanel calendarPanel =  new CalendarPanel();
                String id = JOptionPane.showInputDialog(null, "Введіть ID", "Ввід ID працівника", JOptionPane.QUESTION_MESSAGE);
                int result = JOptionPane.showConfirmDialog(null, calendarPanel , "Вибір дати",JOptionPane.OK_CANCEL_OPTION,  JOptionPane.QUESTION_MESSAGE);
                if (result == JOptionPane.OK_OPTION && id != null && !id.isBlank()){
                    if (calendarPanel.getSelectedDate() != null){
                        LocalDate date = calendarPanel.getSelectedDate();
                        try {
                            resultField.setText(DBDelete.DeleteSchedule(Integer.parseInt(id), date));
                        }catch (Exception _){
                            resultField.setText("Помилка вводу");
                        }

                    }
                }
            }
        });


        JDialog dialog = new DialogWindow(frame, "Меню Видалення");
        dialog.add(panel);
        dialog.pack();
        dialog.setVisible(true);
    }
}

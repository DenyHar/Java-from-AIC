package org.example.GUI;

import org.example.DBInsert;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static org.example.MyUtilityClass.isStringEmpty;

public class InsertWindow {

    public InsertWindow(JFrame frame){
        GridLayout gridLayout = new GridLayout(6,1);
        gridLayout.setVgap(5);

        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panel.setLayout(gridLayout);
        panel.setPreferredSize(new Dimension(300,350));

        JPanel inputPanel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        inputPanel.setLayout(gridLayout);
        inputPanel.setPreferredSize(new Dimension(300,350));

        JButton insertStaff = new JButton("Додати працівника");
        JButton insertClient = new JButton("Додати клієнта");
        JButton insertMenu = new JButton("Додати пункт меню");
        JButton insertOrder = new JButton("Додати замовлення");
        JButton insertSchedule = new JButton("Додати робочу зміну");

        JTextField resultField = new JTextField();
        resultField.setEditable(false);

        JTextField input1 = new JTextField();
        JTextField input2 = new JTextField();
        JTextField input3 = new JTextField();
        JTextField input4 = new JTextField();
        JTextField input5 = new JTextField();


        panel.add(insertStaff);
        panel.add(insertClient);
        panel.add(insertMenu);
        panel.add(insertOrder);
        panel.add(insertSchedule);
        panel.add(resultField);

        insertStaff.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inputPanel.removeAll();
                inputPanel.add(input1);
                inputPanel.add(input2);
                inputPanel.add(input3);
                inputPanel.add(input4);
                inputPanel.add(input5);
                int result =  JOptionPane.showConfirmDialog(null, inputPanel, "Створити ", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (result == JOptionPane.OK_OPTION){
                    if (!isStringEmpty(input1.getText()) && !isStringEmpty(input2.getText()) && !isStringEmpty(input3.getText()) && !isStringEmpty(input4.getText()) && !isStringEmpty(input5.getText())){
                        try{
                            resultField.setText(DBInsert.InsertStaff(Integer.parseInt(input1.getText())
                                                                    ,input2.getText()
                                                                    ,Integer.parseInt(input3.getText())
                                                                    ,input4.getText()
                                                                    ,input5.getText() ));
                        }catch (Exception exception){
                            resultField.setText(exception.getMessage());
                        }
                    }
                }
            }
        });
        insertClient.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        insertMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        insertOrder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        insertSchedule.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        JDialog dialog = new DialogWindow(frame, "Меню Створення");
        dialog.add(panel);
        dialog.pack();
        dialog.setVisible(true);
    }

}

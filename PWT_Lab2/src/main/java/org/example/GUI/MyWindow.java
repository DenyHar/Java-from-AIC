package org.example.GUI;

import javax.swing.*;

public class MyWindow extends JFrame{
    public MyWindow(String title){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle(title);
        setSize(500,500);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}

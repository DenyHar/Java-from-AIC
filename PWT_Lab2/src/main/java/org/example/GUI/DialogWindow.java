package org.example.GUI;

import javax.swing.*;
import java.awt.*;

public class DialogWindow extends JDialog {
    public DialogWindow(Window owner, String title){
        super (owner, title);
        setModal(true);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setSize(500,500);
        setLocationRelativeTo(null);
    }
}

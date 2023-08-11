package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Demogui {
    private JPanel panel1;
    private JButton textoButton;
    public Demogui(){
        textoButton = new JButton("Texto");
        textoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Hola mundo");
            }
        });
        panel1.add(textoButton);
    }

}

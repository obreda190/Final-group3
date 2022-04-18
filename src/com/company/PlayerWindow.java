package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlayerWindow {

    private JFrame frame;
    private JLabel label;
    private JTextField field;
    private JButton butt;
    private String name;

    public PlayerWindow() {
        frame = new JFrame("Enter Name:");

        label = new JLabel("Please Enter Your Name: ");
        frame.getContentPane().add(label);

        field = new JTextField(25);
        frame.getContentPane().add(field);

        butt = new JButton("Done");
        butt.addActionListener(new PlayerWindow.ButtonListener(field));
        frame.getContentPane().add(butt);

        frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    class ButtonListener implements ActionListener {

        private JTextField field;

        public ButtonListener(JTextField field) {
            this.field = field;
        }

        public void actionPerformed(ActionEvent e) {
            String name = field.getText();
            Player play = new Player(name);
            //definitely not done


        }
    }
}

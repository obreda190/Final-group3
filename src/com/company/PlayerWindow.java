package com.company;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

//Make into runnable
public class PlayerWindow {

    private JFrame frame;
    private JLabel label;
    private JTextField field;
    private JButton button;
    private String name;
    private ArrayList<Player> players;

    public PlayerWindow(ArrayList<Player> players) {

        Border blank = BorderFactory.createEmptyBorder(5, 5, 5, 5);

        this.players = players;
        frame = new JFrame("Enter Name!");

        label = new JLabel("Please Enter Your Name: ");
        label.setBorder(blank);
        frame.getContentPane().add(label);

        field = new JTextField(25);
        frame.getContentPane().add(field);

        button = new JButton("Done");
        button.addActionListener(new PlayerWindow.ButtonListener(field));
        frame.getContentPane().add(button);

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
            players.add(play);
            frame.dispose();

            //Return player somehow in order to create scoreboard

        }
    }
}

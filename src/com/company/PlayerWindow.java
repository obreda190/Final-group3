package com.company;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class PlayerWindow extends Thread {
    private JFrame frame;
    private JLabel label;
    private JTextField field;
    private JButton butt;
    private ArrayList<Player> players;
    private JWindow jWind;
    private JWindow jDWind;

    public PlayerWindow(ArrayList<Player> players, JWindow jWind, JWindow jDWind) {
        this.players = players;
        this.jWind = jWind;
        this.jDWind = jDWind;
    }
    public void run(){
        frame = new JFrame("Enter Name!");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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
            players.add(play);
            frame.dispose();



            jWind.start();

            jDWind.start();



        }
    }

}

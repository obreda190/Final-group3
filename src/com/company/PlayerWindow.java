package com.company;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class PlayerWindow extends Thread {

    private JFrame frame;
    private JLabel p1;
    private JLabel p2;
    private JLabel p3;
    private JTextField f1;
    private JTextField f2;
    private JTextField f3;
    private JButton button;
    private ArrayList<Player> players;
    private JWindow jWind;
    public PlayerWindow(){

    }

    public PlayerWindow(ArrayList<Player> players, JWindow jWind) {
        this.players = players;
        this.jWind = jWind;
    }

    public void run() {

        frame = new JFrame("Enter Name!");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        p1 = new JLabel("Player 1, please enter your name: ");
        frame.getContentPane().add(p1);

        f1 = new JTextField(20);
        frame.getContentPane().add(f1);

        p2 = new JLabel("Player 2, please enter your name: ");
        frame.getContentPane().add(p2);

        f2 = new JTextField(20);
        frame.getContentPane().add(f2);

        p3 = new JLabel("Player 3, please enter your name: ");
        frame.getContentPane().add(p3);

        f3 = new JTextField(20);
        frame.getContentPane().add(f3);

        button = new JButton("Done");
        button.addActionListener(new PlayerWindow.ButtonListener(f1, f2, f3));
        frame.getContentPane().add(button);

        frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    class ButtonListener implements ActionListener {

        private JTextField f1;
        private JTextField f2;
        private JTextField f3;

        public ButtonListener(JTextField f1, JTextField f2, JTextField f3) {
            this.f1 = f1;
            this.f2 = f2;
            this.f3 = f3;
        }

        public void actionPerformed(ActionEvent e) {
            String n1 = f1.getText();
            Player p1 = new Player(n1);
            players.add(p1);

            String n2 = f2.getText();
            Player p2 = new Player(n2);
            players.add(p2);

            String n3 = f3.getText();
            Player p3 = new Player(n3);
            players.add(p3);

            frame.dispose();
            jWind.setPlayers(players);
            jWind.start();
        }
    }
    public ArrayList<Player> getPlayers(){
        return players;
    }
}

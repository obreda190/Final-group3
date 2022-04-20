package com.company;

import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

public class PlayerWindow extends Thread {

    private JFrame frame;
    private JLabel p1, p2, p3;
    private JTextField f1, f2, f3;
    private JButton button;
    private ArrayList<Player> players;
    private JWindow jWind;

    /**
     * creates a GUI that asks the user to input 3 names
     * @param players an ArrayList of Player objects
     * @param jWind JWindow
     */
    public PlayerWindow(ArrayList<Player> players, JWindow jWind) {
        this.players = players;
        this.jWind = jWind;
    }

    /**
     * creates the GUI that is displayed after being called to start
     */
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

        private JTextField f1, f2, f3;

        /**
         * creates a ButtonListener
         * @param f1 JTextField
         * @param f2 JTextField
         * @param f3 JTextField
         */
        public ButtonListener(JTextField f1, JTextField f2, JTextField f3) {
            this.f1 = f1;
            this.f2 = f2;
            this.f3 = f3;
        }

        /**
         * When the button is pressed the names in the JTextField are added to the player ArrayList and the frame is disposed of and the JWindow begins to run
         * @param e
         */
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
}

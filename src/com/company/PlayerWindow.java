package com.company;

import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

/**
 * @author Niko Toro, Grace Ordonez, Olivia Breda
 * This class creates a JFrame allowing all 3 players to enter their names
 */
public class PlayerWindow extends Thread {

    private JFrame frame;
    private final ArrayList<Player> players;
    private final JWindow jWind;

    /**
     * Non-default constructor that creates a new PlayerWindow object with an ArrayList containing the players
     * and a JWindow to be displayed when the PlayerWindow ends
     * @param players ArrayList containing the 3 Player objects representing the people playing the game
     * @param jWind JWindow to be displayed when the PlayerWindow ends
     */
    public PlayerWindow(ArrayList<Player> players, JWindow jWind) {
        this.players = players;
        this.jWind = jWind;
    }

    /**
     * Overridden run method that sets up and displays a JFrame containing 3 JTextFields for players
     * to enter their names along with a JButton to retrieve the information entered
     */
    public void run() {

        // New JFrame created
        frame = new JFrame("Enter Name!");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // New JLabel and JTextField created to allow player 1 to enter their name
        JLabel p1 = new JLabel("Player 1, please enter your name: ");
        frame.getContentPane().add(p1);
        JTextField f1 = new JTextField(20);
        frame.getContentPane().add(f1);

        // New JLabel and JTextField created to allow player 2 to enter their name
        JLabel p2 = new JLabel("Player 2, please enter your name: ");
        frame.getContentPane().add(p2);
        JTextField f2 = new JTextField(20);
        frame.getContentPane().add(f2);

        // New JLabel and JTextField created to allow player 3 to enter their name
        JLabel p3 = new JLabel("Player 3, please enter your name: ");
        frame.getContentPane().add(p3);
        JTextField f3 = new JTextField(20);
        frame.getContentPane().add(f3);

        // New JButton and ButtonListener created and added to the JFrame
        JButton button = new JButton("Done");
        button.addActionListener(new PlayerWindow.ButtonListener(f1, f2, f3));
        frame.getContentPane().add(button);

        // JFrame packed, formatted, and displayed
        frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    /**
     * @author Niko Toro, Grace Ordonez, Olivia Breda
     * This class establishes a ButtonListener object that tells JButtons how they should behave once clicked.
     */
    class ButtonListener implements ActionListener {

        private final JTextField f1;
        private final JTextField f2;
        private final JTextField f3;

        /**
         * Non-default constructor that instantiates a JButton object and the 3 JTextFields players entered their names in
         * @param f1 JTextField where player 1 entered their name
         * @param f2 JTextField where player 2 entered their name
         * @param f3 JTextField where player 3 entered their name
         */
        public ButtonListener(JTextField f1, JTextField f2, JTextField f3) {
            this.f1 = f1;
            this.f2 = f2;
            this.f3 = f3;
        }

        /**
         * Overridden actionPerformed method that retrieves the information from the JTextFields and uses it to create
         * the 3 new Player objects to be used in the game.
         * Upon completion, the JFrame is disposed of and a new JWindow object is created and ran
         * @param e ActionEvent representing the clicking of a JButton
         */
        @Override
        public void actionPerformed(ActionEvent e) {

            // Retrieves the name String from player 1's JTextField and creates a p1 Player object
            String n1 = f1.getText();
            Player p1 = new Player(n1);

            // Retrieves the name String from player 2's JTextField and creates a p2 Player object
            String n2 = f2.getText();
            Player p2 = new Player(n2);

            // Retrieves the name String from player 3's JTextField and creates a p3 Player object
            String n3 = f3.getText();
            Player p3 = new Player(n3);

            // Player objects added to an ArrayList to be passed into the JWindow
            players.add(p1);
            players.add(p2);
            players.add(p3);

            // JFrame disposed of and JWindow starts after being passed the ArrayList of Players
            frame.dispose();
            jWind.setPlayers(players);
            jWind.start();
        }
    }
}

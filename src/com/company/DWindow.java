package com.company;

import java.awt.*;
import java.awt.event.*;
import java.lang.reflect.Array;
import javax.swing.*;
import javax.swing.border.Border;
import java.util.*;

/**
 * @author Niko Toro, Grace Ordonez, Olivia Breda
 * This class creates a JFrame containing 6 random categories and their respective questions displayed as a grid of JButtons.
 */
public class DWindow extends Thread {

    private final ArrayList<Category> categories;
    private ArrayList<Player> players;

    /**
     * Non-default constructor that takes an ArrayLists containing 6 random categories to be displayed in the game.
     * @param categories ArrayList that contains the Category objects to be used for the Double Jeopardy round
     */
    public DWindow(ArrayList<Category> categories) {
        this.categories = categories;
    }

    /**
     * Setter method that instantiates an ArrayList of the current players into the DWindow.
     * @param players ArrayList containing the Player objects that represent the current players
     */
    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    /**
     * Overridden run method that sets up and displays the JFrame and Timer to be used in the Double Jeopardy round.
     * Upon completion, the JFrame is disposed of and a new ResultWindow is created and started.
     */
    @Override
    public void run() {

        // Borders used in JFrame layout
        Border blackLine = BorderFactory.createLineBorder(Color.black);
        Border blank = BorderFactory.createEmptyBorder(10, 10, 10, 10);

        // Timer and new JFrame created and formatted
        Timers t1 = new Timers(RoundType.Jeopardy);

        JFrame frame = new JFrame("Double Jeopardy Round");
        frame.setForeground(Color.white);
        frame.setBackground(Color.blue);
        frame.getRootPane().setBorder(blank);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // For loop that iterates through the Categories used for the current round and adding them into their own JPanel
        for (Category c : categories) {

            c.doubleJeopardy();
            ArrayList<Question> questions = c.getQuestionsList();
            JPanel panel = new JPanel();
            panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));

            // Formatting the JLabel representing the Category object
            JLabel cat = new JLabel("<html><p>" + c.getName() + "</p></html>", SwingConstants.CENTER);
            cat.setVerticalAlignment(SwingConstants.CENTER);
            cat.setBorder(blank);
            cat.setForeground(Color.white);
            panel.add(cat);
            cat.setAlignmentX(Box.CENTER_ALIGNMENT);

            // For loop that iterates through the Questions in a respective Category and adding them as JButtons into
            // their Category's JPanel
            for (Question q : questions) {

                JPanel p = new JPanel();
                p.setLayout(new BorderLayout());

                // Formatting the JButton representing the Question object and establishing ButtonListeners
                JButton button = new JButton(q.pointString());
                button.addActionListener(new ButtonListener(q, button));
                p.add(button, BorderLayout.CENTER);
                p.setBackground(Color.blue);
                panel.add(p);
            }

            // Formatting JPanel and adding it to the JFrame
            panel.setPreferredSize(new Dimension(210, 500));
            panel.setBorder(blackLine);
            panel.setVisible(true);
            panel.setBackground(Color.blue);
            frame.getContentPane().add(panel);
        }

        // JFrame packed and displayed
        frame.getContentPane().setLayout(new FlowLayout());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        // Round timer begins after the JFrame is displayed, JFrame is made invisible once timer ends
        t1.start();
        try {
            t1.join();
        } catch (InterruptedException e) {
            System.out.print("Interrupted Jeopardy");
        }
        frame.setVisible(false);

        // JFrame representing Single Jeopardy is disposed of after creating and running a new ResultWindow object
        ResultWindow rw = new ResultWindow(players);
        rw.start();
        frame.dispose();
    }

    /**
     * @author Niko Toro, Grace Ordonez, Olivia Breda
     * This class establishes a ButtonListener object that tells JButtons how they should behave once clicked.
     */
    class ButtonListener implements ActionListener {

        private final Question question;
        private final JButton button;

        /**
         * Non-default constructor that instantiates a JButton object and the Question object that it represents.
         * @param question Question object representing the desired question
         * @param button JButton object representing the JButton linked to the Question object
         */
        public ButtonListener(Question question, JButton button) {
            this.question = question;
            this.button = button;
        }

        /**
         * Overridden actionPerformed method that creates a new AskWindow object upon a JButton being clicked,
         * and disabling the clicked JButton to avoid repeats.
         * @param e ActionEvent representing the clicking of a JButton
         */
        @Override
        public void actionPerformed(ActionEvent e) {

            new AskWindow(question, players);

            ActionListener[] a = button.getActionListeners();
            button.removeActionListener((ActionListener) Array.get(a, 0));
            button.setText("");
        }
    }
}


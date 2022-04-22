package com.company;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import javax.swing.border.Border;
import java.util.*;

/**
 * @author Niko Toro, Grace Ordonez, Olivia Breda
 * This class creates a JFrame containing text that explains the program
 */
public class MenuWindow {

    private final JFrame menu;
    private final PlayerWindow pw;

    /**
     * Non-default constructor that creates and displays a JWindow containing text explaining the game and a JButton to begin
     * @param pw PlayerWindow object that runs upon clicking the start button
     */
    public MenuWindow(PlayerWindow pw) {

        // Borders used in JFrame layout
        Border blackLine = BorderFactory.createLineBorder(Color.black);
        Border blank = BorderFactory.createEmptyBorder(10, 10, 10, 10);

        // New JFrame created and formatted
        this.pw = pw;
        menu = new JFrame("Main Menu");
        menu.getRootPane().setBorder(blank);
        menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // New JPanel created and formatted to store JLabels
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        panel.setBorder(blackLine);

        // New JLabel holding the title created, formatted, and added to the JPanel
        JLabel title = new JLabel("This Is Jeopardy!", SwingConstants.CENTER);
        title.setVerticalAlignment(SwingConstants.CENTER);
        title.setBorder(blank);
        panel.add(title);

        // New JPanel created and formatted to store all text related to how the game works
        JPanel g = new JPanel();
        g.setLayout(new BoxLayout(g, BoxLayout.PAGE_AXIS));
        g.setBorder(blank);

        // New JLabel holding the header for how the game works created, formatted, and added to JPanel g
        JLabel game = new JLabel("How the game works:", SwingConstants.CENTER);
        game.setVerticalAlignment(SwingConstants.CENTER);
        g.add(game);
        game.setAlignmentX(Box.CENTER_ALIGNMENT);

        // New JPanel created and formatted to store all text read from the Game.txt file
        JPanel gameText = new JPanel();
        gameText.setLayout(new BoxLayout(gameText, BoxLayout.PAGE_AXIS));

        // For loop that iterates through every line found in Game.txt and adding them to JPanel g
        for (String s : getGame()) {
            JLabel text = new JLabel(s, SwingConstants.CENTER);
            text.setVerticalAlignment(SwingConstants.CENTER);
            gameText.add(text);
            text.setAlignmentX(Box.CENTER_ALIGNMENT);
        }
        gameText.setBorder(blank);
        g.add(gameText);
        panel.add(g);

        // New JPanel created and formatted to store all text related to the rules of the game
        JPanel r = new JPanel();
        r.setLayout(new BoxLayout(r, BoxLayout.PAGE_AXIS));
        r.setBorder(blank);

        // New JLabel holding the header for the game rules created, formatted, and added to JPanel r
        JLabel rules = new JLabel("Rules:", SwingConstants.CENTER);
        rules.setVerticalAlignment(SwingConstants.CENTER);
        r.add(rules);
        r.setAlignmentX(Box.CENTER_ALIGNMENT);

        // New JPanel created and formatted to store all text read from the Rules.txt file
        JPanel rulesText = new JPanel();
        rulesText.setLayout(new BoxLayout(rulesText, BoxLayout.PAGE_AXIS));

        // For loop that iterates through every line found in Rules.txt and adding them to JPanel r
        for (String s : getRules()) {
            JLabel text = new JLabel(s, SwingConstants.CENTER);
            text.setVerticalAlignment(SwingConstants.CENTER);
            rulesText.add(text);
            text.setAlignmentX(Box.CENTER_ALIGNMENT);
        }
        rulesText.setBorder(blank);
        r.add(rulesText);
        panel.add(r);

        // New JButton and ButtonListener created and added to the JPanel
        JButton button = new JButton("Start!");
        button.addActionListener(new MenuWindow.ButtonListener());
        panel.add(button);

        // Formatting all components of the JPanel
        title.setAlignmentX(Box.CENTER_ALIGNMENT);
        game.setAlignmentX(Box.CENTER_ALIGNMENT);
        rules.setAlignmentX(Box.CENTER_ALIGNMENT);
        button.setAlignmentX(Box.CENTER_ALIGNMENT);
        menu.getContentPane().add(panel);

        // JFrame packed and displayed
        menu.pack();
        menu.setLocationRelativeTo(null);
        menu.setVisible(true);
    }

    /**
     * @author Niko Toro, Grace Ordonez, Olivia Breda
     * This class establishes a ButtonListener object that tells JButtons how they should behave once clicked.
     */
    class ButtonListener implements ActionListener {

        /**
         * Overridden actionPerformed method that disposes of the MenuWindow and begins running a new PlayerWindow
         * @param e ActionEvent representing the clicking of a JButton
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            menu.dispose();
            pw.start();
        }
    }

    /**
     * Method that iterates through each line of the Game.txt file, adding the contents of each line into an ArrayList
     * @return ArrayList containing every line found in Game.txt
     */
    public ArrayList<String> getGame() {

        ArrayList<String> game = new ArrayList<>();
        Scanner reader = null;
        FileInputStream file;

        try {
            file = new FileInputStream("Game.txt");
            reader = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        while (reader.hasNextLine()) {
            String s = reader.nextLine();
            game.add(s);
        }

        return game;
    }

    /**
     * Method that iterates through each line of the Rules.txt file, adding the contents of each line into an ArrayList
     * @return ArrayList containing every line found in Rules.txt
     */
    public ArrayList<String> getRules() {

        ArrayList<String> rules = new ArrayList<>();
        Scanner reader = null;
        FileInputStream file;

        try {
            file = new FileInputStream("Rules.txt");
            reader = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        while (reader.hasNextLine()) {
            String s = reader.nextLine();
            rules.add(s);
        }

        return rules;
    }
}

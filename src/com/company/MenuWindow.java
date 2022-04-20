package com.company;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import javax.swing.border.Border;
import java.util.*;

public class MenuWindow {

    private JFrame menu;
    private PlayerWindow pw;

    /**
     * creates a GUI that displays the rules of jeopardy
     * @param pw PlayerWindow
     */
    public MenuWindow(PlayerWindow pw) {

        Border blackLine = BorderFactory.createLineBorder(Color.black);
        Border blank = BorderFactory.createEmptyBorder(10, 10, 10, 10);

        this.pw = pw;
        menu = new JFrame("Main Menu");
        menu.getRootPane().setBorder(blank);
        menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        panel.setBorder(blackLine);

        JLabel title = new JLabel("This Is Jeopardy!", SwingConstants.CENTER);
        title.setVerticalAlignment(SwingConstants.CENTER);
        title.setBorder(blank);
        panel.add(title);

        JPanel g = new JPanel();
        g.setLayout(new BoxLayout(g, BoxLayout.PAGE_AXIS));
        g.setBorder(blank);

        JLabel game = new JLabel("How the game works:", SwingConstants.CENTER);
        game.setVerticalAlignment(SwingConstants.CENTER);
        g.add(game);
        game.setAlignmentX(Box.CENTER_ALIGNMENT);

        JPanel gameText = new JPanel();
        gameText.setLayout(new BoxLayout(gameText, BoxLayout.PAGE_AXIS));
        for (String s : getGame()) {
            JLabel text = new JLabel(s, SwingConstants.CENTER);
            text.setVerticalAlignment(SwingConstants.CENTER);
            gameText.add(text);
            text.setAlignmentX(Box.CENTER_ALIGNMENT);
        }
        gameText.setBorder(blank);
        g.add(gameText);
        panel.add(g);

        JPanel r = new JPanel();
        r.setLayout(new BoxLayout(r, BoxLayout.PAGE_AXIS));
        r.setBorder(blank);

        JLabel rules = new JLabel("Rules:", SwingConstants.CENTER);
        rules.setVerticalAlignment(SwingConstants.CENTER);
        r.add(rules);
        r.setAlignmentX(Box.CENTER_ALIGNMENT);

        JPanel rulesText = new JPanel();
        rulesText.setLayout(new BoxLayout(rulesText, BoxLayout.PAGE_AXIS));
        for (String s : getRules()) {
            JLabel text = new JLabel(s, SwingConstants.CENTER);
            text.setVerticalAlignment(SwingConstants.CENTER);
            rulesText.add(text);
            text.setAlignmentX(Box.CENTER_ALIGNMENT);
        }
        rulesText.setBorder(blank);
        r.add(rulesText);
        panel.add(r);

        JButton button = new JButton("Start!");
        button.addActionListener(new MenuWindow.ButtonListener());
        panel.add(button);

        title.setAlignmentX(Box.CENTER_ALIGNMENT);
        game.setAlignmentX(Box.CENTER_ALIGNMENT);
        rules.setAlignmentX(Box.CENTER_ALIGNMENT);
        button.setAlignmentX(Box.CENTER_ALIGNMENT);

        menu.getContentPane().add(panel);
        menu.pack();
        menu.setLocationRelativeTo(null);
        menu.setVisible(true);
    }


    class ButtonListener implements ActionListener {
        /**
         * dispose of the MenuWindow GUI and starts running the PlayerWindow
         * @param e ActionEvent
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            menu.dispose();
            pw.start();
        }
    }

    /**
     * returns the text in the Game.txt text file
     * @return ArrayList</String> of the text in the text file
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
     * returns the text in the Rules.txt text file
     * @return ArrayList</String> of the text in the text file
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

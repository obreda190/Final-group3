package com.company;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MenuWindow {

    private JFrame menu;
    private Thread t;
    private PlayerWindow pw;

    public MenuWindow(PlayerWindow pw) {

        this.pw=pw;

        Border blackLine = BorderFactory.createLineBorder(Color.black);
        Border blank = BorderFactory.createEmptyBorder(10, 10, 10, 10);

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

        //Add component that reads from Game.txt
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

        //Add component that reads from Rules.txt
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
        g.setAlignmentX(Box.CENTER_ALIGNMENT);
        rules.setAlignmentX(Box.CENTER_ALIGNMENT);
        button.setAlignmentX(Box.CENTER_ALIGNMENT);

        menu.getContentPane().add(panel);
        menu.pack();
        menu.setLocationRelativeTo(null);
        menu.setVisible(true);

    }


    class ButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            menu.dispose();
            pw.start();
        }
    }

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

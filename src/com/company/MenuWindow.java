package com.company;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MenuWindow {

    private JFrame menu;
    private Thread t;

    public MenuWindow() {

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

        JLabel game = new JLabel("How the game works:", SwingConstants.CENTER);
        game.setVerticalAlignment(SwingConstants.CENTER);
        game.setBorder(blank);
        panel.add(game);

        //Add component that reads from Game.txt

        JLabel rules = new JLabel("Rules:", SwingConstants.CENTER);
        rules.setVerticalAlignment(SwingConstants.CENTER);
        rules.setBorder(blank);
        panel.add(rules);

        //Add component that reads from Rules.txt

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

        t = Thread.currentThread();
    }

    public Thread getThread() {
        return this.t;
    }

    class ButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            ArrayList<Player> p = new ArrayList<>();

            for (int m = 0; m<3; m++) {
                PlayerWindow pw = new PlayerWindow(p);
            }

            //Interrupted here

        }
    }
}

package com.company;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuWindow {
    private JFrame menu;
    private JTextField text;

    public MenuWindow() {

        menu = new JFrame("Main Menu");
        menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Border blackLine = BorderFactory.createLineBorder(Color.black);
        Border blank = BorderFactory.createEmptyBorder(10, 10, 10, 10);
        menu.getRootPane().setBorder(blank);

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

        //Add component (JLabel, JTextArea, etc. whichever works best) that reads from Game.txt into panel

        JLabel rules = new JLabel("Rules:", SwingConstants.CENTER);
        rules.setVerticalAlignment(SwingConstants.CENTER);
        rules.setBorder(blank);
        panel.add(rules);

        //Add component (JLabel, JTextArea, etc. whichever works best) that reads from Game.txt into panel

        JButton button = new JButton("Start!");
        //button.addActionListener(new MenuWindow.ButtonListener());
        panel.add(button);

        title.setAlignmentX(Box.CENTER_ALIGNMENT);
        game.setAlignmentX(Box.CENTER_ALIGNMENT);
        rules.setAlignmentX(Box.CENTER_ALIGNMENT);
        button.setAlignmentX(Box.CENTER_ALIGNMENT);

        menu.getContentPane().add(panel);

        menu.getContentPane().setLayout(new FlowLayout());
        menu.pack();
        menu.setLocationRelativeTo(null);
        menu.setVisible(true);
    }

   // class ButtonListener implements ActionListener {

        //public void actionPreformed(ActionEvent e){




       // }

   // }
}

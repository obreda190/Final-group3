package com.company;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import java.util.*;

public class ScoreBoard extends Thread {

    private ArrayList<Player> players;
    private JFrame board;

    /**
     * creates a gui displaying players scores
     * @param players ArrayList of player objects
     */
    public ScoreBoard(ArrayList<Player> players) {

        Border blackLine = BorderFactory.createLineBorder(Color.black);
        Border blank = BorderFactory.createEmptyBorder(10, 10, 10, 10);

        this.players = players;
        board = new JFrame("ScoreBoard");
        board.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        board.getRootPane().setBorder(blank);

        for (Player player : players) {

            JPanel panel = new JPanel();
            panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
            panel.setBorder(blackLine);

            JLabel name = new JLabel(player.getName(), SwingConstants.CENTER);
            name.setVerticalAlignment(SwingConstants.CENTER);
            name.setBorder(blank);
            panel.add(name);

            JLabel score = new JLabel(String.valueOf(player.getScore()), SwingConstants.CENTER);
            score.setVerticalAlignment(SwingConstants.CENTER);
            score.setBorder(blank);
            panel.add(score);

            name.setAlignmentX(Box.CENTER_ALIGNMENT);
            score.setAlignmentX(Box.CENTER_ALIGNMENT);

            board.getContentPane().add(panel);
        }

        board.getContentPane().setLayout(new FlowLayout());
        board.pack();
        board.setLocationRelativeTo(null);
        board.setVisible(true);
    }

    /**
     * returns the JFrame of the GUI
     * @return JFrame
     */
    public JFrame getBoard(){
        return this.board;
    }

}

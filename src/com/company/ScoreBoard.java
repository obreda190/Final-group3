package com.company;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.ArrayList;

public class ScoreBoard extends Thread {

    private ArrayList<Player> players;
    private JFrame board;

    public ScoreBoard(ArrayList<Player> players) {

        this.players = players;
        board = new JFrame("ScoreBoard");
        board.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Border blackLine = BorderFactory.createLineBorder(Color.black);
        Border blank = BorderFactory.createEmptyBorder(10, 10, 10, 10);
        board.getRootPane().setBorder(blank);

        for(int j = 0; j < this.players.size(); ++j) {
            JPanel panel = new JPanel();
            panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
            panel.setBorder(blackLine);

            JLabel name = new JLabel("Player " + (j + 1) + ": " + this.players.get(j).getName(), SwingConstants.CENTER);
            name.setVerticalAlignment(SwingConstants.CENTER);
            name.setBorder(blank);
            panel.add(name);

            JLabel score = new JLabel(String.valueOf(this.players.get(j).getScore()), SwingConstants.CENTER);
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

    public void run(){
        try{
            Thread.sleep(5000);
            board.repaint();
        }catch(InterruptedException e){
            System.out.println("Interrupt ScoreBoard");
        }
        start();
    }

}

package com.company;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ScoreBoard extends Thread{
    private ArrayList<Player> players;
    private JFrame board;

    public ScoreBoard(ArrayList<Player> players){
        this.players=players;

        board = new JFrame("ScoreBoard");
        board.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new BorderLayout());


        for (int j = 0; j< this.players.size(); ++j){
            JLabel label = new JLabel("Player "+ j+1 +": " + this.players.get(j).getName());
            panel.add(label);

            JLabel label2 = new JLabel(String.valueOf(this.players.get(j).getScore()));
            panel.add(label2);

        }

        panel.setPreferredSize(new Dimension(200,200));

        board.getContentPane().add(panel);
        board.getContentPane().setLayout(new FlowLayout());
        board.pack();
        board.setVisible(true);
    }

    public void run(){
        try{
            Thread.sleep(1000);
            board.repaint();
        }catch(InterruptedException e){
            System.out.println("Interrupt ScoreBoard");

        }
    }

}

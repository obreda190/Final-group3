package com.company;

import javax.swing.*;
import java.lang.*;

public class Player {

    private String name;
    private int score;
    private int num;

    public Player(String name) {
        this.name = name;
        score = 0;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void addPoints(int p) {
        score = score + p;
    }

    public void subtractPoints(int p) {
        score = score - p;
    }

    public void Wager(JTextField tf) {
        int maxWager;
        if (score < 0) {
            maxWager = 1000;
        } else {
            maxWager = score;
        }

        String wagerSt = tf.getText();
        int wager = Integer.parseInt(wagerSt);
        if (wager > maxWager) {
            JOptionPane.showMessageDialog(null, "The maximum amount you are able to wager for this question is: " + maxWager);
        } else {
            //Ask the question or close the window so the next player
        }
    }

}

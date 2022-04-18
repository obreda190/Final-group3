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

    public void wager(JTextField tf) {

        int maxWager;
        if (score < 0) {
            maxWager = 1000;
        } else {
            maxWager = score;
        }

        String wagerString = tf.getText();
        int wager = Integer.parseInt(wagerString);

        if (wager > maxWager) {
            JOptionPane.showMessageDialog(null, "The maximum amount you are able to wager for this question is: " + maxWager);
            //Return to whatever state allowed player to enter their wager
        } else {
            //Open QuestionWindow or close the window so the next player can enter their wager for finalJ
        }
    }
}

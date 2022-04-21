package com.company;

import java.lang.*;

/**
 * @author Grace Ordonez, Niko Toro, Olivia Breda
 * sets up player info
 */

public class Player {

    private String name;
    private int score;

    /**
     * sets player name as accesible object
     * sets score to 0
     * @param name
     */

    public Player(String name) {
        this.name = name;
        score = 0;
    }

    /**
     * gets player name
     * @return player name
     */

    public String getName() {
        return name;
    }

    /**
     * gets players current score
     * @return players score
     */

    public int getScore() {
        return score;
    }

    /**
     * adds points to score
     * @param p
     */

    public void addPoints(int p) {
        score = score + p;
    }

    /**
     * subtracts points from score
     * @param p
     */

    public void subtractPoints(int p) {
        score = score - p;
    }
}

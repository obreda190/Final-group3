package com.company;

import java.lang.*;

/**
 * @author Grace Ordonez, Niko Toro, Olivia Breda
 * This class represents any one person who is playing the game
 */
public class Player {

    private String name;
    private int score;

    /**
     * Non-default constructor that creates a new Player object with a name and a score of 0
     * @param name String value representing the name of a specified player
     */
    public Player(String name) {
        this.name = name;
        score = 0;
    }

    /**
     * Getter method that retrieves the name of a Player object
     * @return instance variable name
     */
    public String getName() {
        return name;
    }

    /**
     * Getter method that retrieves the score of a Player object
     * @return instance variable score
     */
    public int getScore() {
        return score;
    }

    /**
     * Method that adds a specified amount of points to a Player's score
     * @param p int value representing the number of points to be added
     */
    public void addPoints(int p) {
        score = score + p;
    }

    /**
     * Method that subtracts a specified amount of points from a Player's score
     * @param p int value representing the number of points to be subtracted
     */
    public void subtractPoints(int p) {
        score = score - p;
    }
}

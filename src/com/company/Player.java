package com.company;

import java.lang.*;

public class Player {

    private String name;
    private int score;

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
}

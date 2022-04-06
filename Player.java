import javax.swing.*;
import java.awt.event.*;
import java.lang.*;

public class Player {

    private String name;
    private int score;
    private boolean control;

    public Player(String name){
        this.name=name;
    }

    public void addPoints(int p){
        score = score + p;
    }

    public void subtractPoints(int p){
        score = score - p;
    }

}

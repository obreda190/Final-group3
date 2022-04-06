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

    public void Wager(JTextField tf){
        String wagerSt= tf.getText();
        int wager= Integer.parseInt(wagerSt);
        Question question= new Question();
        if (question.getQuestion().equals(question.getAnswer())){
            score=wager+score;
        }
        else{
            score=score-wager;
        }
    }
    public int getScore() {
        return score;
    }

}

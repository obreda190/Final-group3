package com.company;

import java.awt.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.event.*;

public class ResultWindow extends Thread{

    public ResultWindow(ArrayList<Player> players) {
        //this.p1=players.get(0);
        //this.p2=players.get(1);
        //this.p3=players.get(2);
    }
    //private Player p1;
    //private Player p2;
    //private Player p3;

    int s1= 1;//p1.getScore();
    int s2= 2;//p2.getScore();
    int s3= 3;//p3.getScore();

    JLabel label;
    //Figure out which player has the highest amount
    public void run(){
        JFrame frame=new JFrame("The winner is...");
        Timers t1 = new Timers(RoundType.Jeopardy);
        if ((s1>s2)&&(s1>s3)){
            new JLabel(s1+" Wins! Congrats");
        }
        if ((s2>s1)&&(s2>s3)){
            new JLabel(s2+" Wins! Congrats");
        }
        if ((s3>s1)&&(s3>s2)){
            new JLabel(s3+" Wins! Congrats");
        }
        if ((s3>s1)&&(s3==s2)){
            new JLabel(s3+" and "+s2+" have tied for the win! Congrats");
        }
        if ((s3>s2)&&(s3==s1)){
            new JLabel(s3+" and "+s1+" have tied for the win! Congrats");
        }
        if ((s3==s1)&&(s3==s2)){
            new JLabel(s3+" and "+s2+" and "+s3+" have tied for the win! Congrats");
        }
        if ((s2>s3)&&(s1==s2)){
            new JLabel(s1+" and "+s2+" have tied for the win! Congrats");
        }
        
        t1.start();
        try {
            t1.join();
        } catch (InterruptedException e) {
            System.out.print("Interrupted Jeopardy");
        }
        frame.dispose();


        label.setVerticalAlignment(SwingConstants.CENTER);
        frame.getContentPane().add(label);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setPreferredSize(new Dimension(210, 500));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    //Print out congratulation message in window with player's name

    //Confetti?

    //Exit listener

}
package com.company;

import java.io.*;
import javax.imageio.*;
import java.awt.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.event.*;

public class ResultWindow extends Thread{
    ArrayList<Player> players;

    public ResultWindow(ArrayList<Player> players) {
        this.players=players;
    }

    JLabel label;
    //Figure out which player has the highest amount
    public void run(){
        Player p1;
        Player p2;
        Player p3;

        int s1= players.get(0).getScore();
        int s2= players.get(1).getScore();
        int s3= players.get(2).getScore();


        JFrame frame=new JFrame("The winner is...");
        if ((s1>s2)&&(s1>s3)){
            label= new JLabel(players.get(0).getName()+" Wins with " +s1+" points! Congrats");
        }
        if ((s2>s1)&&(s2>s3)){
            label= new JLabel(players.get(1).getName()+" Wins! with " +s2+" points! Congrats");
        }
        if ((s3>s1)&&(s3>s2)){
            label= new JLabel(players.get(2).getName()+" Wins! with " +s3+" points! Congrats");
        }
        if ((s3>s1)&&(s3==s2)){
            label= new JLabel(players.get(2).getName()+" and "+players.get(1).getName()+" have tied for the win with "+s3+" points! Congrats");
        }
        if ((s3>s2)&&(s3==s1)){
            label= new JLabel(players.get(2).getName()+" and "+players.get(0).getName()+" have tied for the win with "+s3+" points! Congrats");
        }
        if ((s3==s1)&&(s3==s2)){
            label= new JLabel(players.get(2).getName()+" and "+players.get(1).getName()+" and "+players.get(0).getName()+" have tied for the win with "+s3+" points! Congrats");
        }
        if ((s2>s3)&&(s1==s2)){
            label= new JLabel(players.get(0).getName()+" and "+players.get(1).getName()+" have tied for the win with "+s1+" points! Congrats");
        }

        Border blackLine = BorderFactory.createLineBorder(Color.black);
        label.setBorder(blackLine);
        label.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setVerticalAlignment(SwingConstants.CENTER);



        frame.add(label).setSize(500,30);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setSize(500, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    //Print out congratulation message in window with player's name
    //Confetti?

    //Exit listener

}
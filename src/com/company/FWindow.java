package com.company;
import java.awt.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.event.*;
public class FWindow {
    private Timers t=new Timers(RoundType.Final);
    private String c;
    private Question q;
    private JFrame frame;
    private JFrame frame2;
    private JLabel label;
    private JLabel label2;
    private JTextField tf;
    private JButton button;

   public void printCategory(String c, String player){
       this.c= q.getCat();

       //initial frame for suspense
       frame = new JFrame("Final Jeopardy");
       frame.setSize(300,500);
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

       label= new JLabel("The final category is...");
       frame.add(label).setBounds(250,150,300,25);

       //Second frame for category
       frame2= new JFrame(c);
       frame2.setSize(300,500);
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

       label2= new JLabel(c);
       frame2.add(label2).setBounds(250,150,300,25);

       }
   public void wager(){


       }

}
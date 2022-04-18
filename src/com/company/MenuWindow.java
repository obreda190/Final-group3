package com.company;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MenuWindow {
    private JFrame menu;
    private JTextField text;
    private Thread t;

    public MenuWindow(){
        menu = new JFrame("Main Menu");
        menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        Border blackLine = BorderFactory.createLineBorder(Color.black);
        Border blank = BorderFactory.createEmptyBorder(10, 10, 10, 10);
        menu.getRootPane().setBorder(blank);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        panel.setBorder(blackLine);

        JLabel name = new JLabel("Rules");
        name.setVerticalAlignment(SwingConstants.CENTER);
        name.setBorder(blank);
        panel.add(name);

        JLabel score = new JLabel("Rules here");
        score.setVerticalAlignment(SwingConstants.CENTER);
        score.setBorder(blank);
        panel.add(score);

        JButton button = new JButton("Start!");
        button.addActionListener(new MenuWindow.ButtonListener());
        panel.add(button);

        button.setAlignmentX(Box.CENTER_ALIGNMENT);
        name.setAlignmentX(Box.CENTER_ALIGNMENT);
        score.setAlignmentX(Box.CENTER_ALIGNMENT);

        menu.getContentPane().add(panel);


        menu.getContentPane().setLayout(new FlowLayout());
        menu.pack();
        menu.setLocationRelativeTo(null);
        menu.setVisible(true);

        this. t = Thread.currentThread();




    }

    public Thread getThread(){return this.t;}


    class ButtonListener implements ActionListener {


        @Override
        public void actionPerformed(ActionEvent e) {
            ArrayList<Player> p = new ArrayList<>();

            for(int m = 0; m<3; m++){
                PlayerWindow pw = new PlayerWindow(p);
            }

            //Interrupted here

        }
    }
}

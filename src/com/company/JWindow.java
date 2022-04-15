package com.company;

import java.awt.*;
import java.util.*;
import java.io.*;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.event.*;

public class JWindow {

    private int roundNum;
    private ArrayList<Category> categories;
    private JFrame frame;

    public JWindow(ArrayList<Category> categories, int roundNum) {
        this.categories = categories;
        this.roundNum = roundNum;

        if (roundNum == 1) {
            frame = new JFrame("Jeopardy Round");
        } else {
            frame = new JFrame("Double Jeopardy Round");
            doubleJeopardy();
        }
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        for(Category c : categories) {
            ArrayList<Question> questions = c.getQuestionsList();
            JPanel panel = new JPanel();
            Border blackLine = BorderFactory.createLineBorder(Color.black);
            panel.setLayout(new FlowLayout(FlowLayout.CENTER));
            panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

            JLabel cat = new JLabel(c.getName());
            cat.setBorder(blackLine);
            panel.add(cat);
            cat.setAlignmentX(Box.CENTER_ALIGNMENT);

            for(Question q : questions) {
                //Add buttons and listeners for each Question in the ArrayList and add to the panel
                JButton button = new JButton(q.pointString());
                button.setMinimumSize(new Dimension(75,75));
                button.setMaximumSize(button.getMinimumSize());
                button.setAlignmentX(Box.CENTER_ALIGNMENT);
                panel.add(button);
            }

            panel.setBorder(blackLine);
            panel.setVisible(true);
            frame.getContentPane().add(panel);
            frame.getContentPane().add(Box.createHorizontalStrut(50));
        }

        frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.X_AXIS));
        frame.setSize(1000,450);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public void doubleJeopardy() {
        for (Category c : categories) {
            c.doubleJeopardy();
        }
    }

    class ExitListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }

}

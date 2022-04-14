package com.company;

import java.util.*;
import java.io.*;
import javax.swing.*;
import java.awt.event.*;

public class JWindow {

    private int roundNum;
    private ArrayList<Category> categories;
    private ArrayList<JPanel> panels;
    private JFrame frame;

    public JWindow(ArrayList<Category> categories, int roundNum) {
        this.categories = categories;
        this.roundNum = roundNum;
        panels = new ArrayList<>();

        if (roundNum == 1) {
            frame = new JFrame("Jeopardy Round");
        } else {
            frame = new JFrame("Double Jeopardy Round");
            doubleJeopardy();
        }

        for(Category c : categories) {
            ArrayList<Question> questions = c.getQuestionsList();
            JPanel panel = new JPanel();
            panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

            JLabel cat = new JLabel(c.getName());
            panel.add(cat);

            for(Question q : questions) {
                //Add buttons and listeners for each Question in the ArrayList and add to the panel
            }
            //Add panels to the frame to hopefully have 6 rows, each representing one category
        }
    }

    public void doubleJeopardy() {
        for (Category c : categories) {
            c.doubleJeopardy();
        }
    }

}

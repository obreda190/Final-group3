package com.company;

import java.awt.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.event.*;

public class JWindow {

    private int roundNum;
    private ArrayList<Category> categories;
    private JFrame frame;

    public JWindow(ArrayList<Category> categories, int roundNum) throws InterruptedException {
        this.categories = categories;
        this.roundNum = roundNum;
        //Timer being made
        Timers t1 = new Timers(RoundType.Jeopardy);
        Border blackLine = BorderFactory.createLineBorder(Color.black);
        Border blank = BorderFactory.createEmptyBorder(10, 10, 10, 10);

        if (roundNum == 1) {
            frame = new JFrame("Jeopardy Round");
        } else {
            frame = new JFrame("Double Jeopardy Round");
            doubleJeopardy();
        }
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getRootPane().setBorder(blank);

        for(Category c : categories) {
            ArrayList<Question> questions = c.getQuestionsList();
            JPanel panel = new JPanel();
            panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));

            JLabel cat = new JLabel("<html><p>"+c.getName()+"</p></html>", SwingConstants.CENTER);
            cat.setVerticalAlignment(SwingConstants.CENTER);
            cat.setBorder(blank);
            panel.add(cat);
            cat.setAlignmentX(Box.CENTER_ALIGNMENT);

            for(Question q : questions) {
                //Add buttons and listeners for each Question in the ArrayList and add to the panel
                JPanel p = new JPanel();
                p.setLayout(new BorderLayout());
                JButton button = new JButton(q.pointString());
                button.addActionListener(new ButtonListener(q));
                p.add(button, BorderLayout.CENTER);
                panel.add(p);
            }

            panel.setPreferredSize(new Dimension(200, 500));
            panel.setBorder(blackLine);
            panel.setVisible(true);
            frame.getContentPane().add(panel);
        }

        frame.getContentPane().setLayout(new FlowLayout());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        //starts t1 after window is established(look into if this changes timing)
        t1.start();

        try{
            //joins t1 to window thread so when t1 is done...
            t1.join();
        }catch(InterruptedException e){
            System.out.print("Interrupted Jeo");
        }
        //...the window becomes invisible
        frame.setVisible(false);
    }

    class ButtonListener implements ActionListener {

        private Question question;

        public ButtonListener(Question question) {
            this.question = question;
        }

        public void actionPerformed(ActionEvent e) {
            AskWindow aw = new AskWindow(question);
        }
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

package com.company;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.*;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.event.*;

public class DWindow extends Thread {

    private ArrayList<Category> categories;
    private JFrame frame;

    public DWindow(ArrayList<Category> categories) {
        this.categories = categories;
    }

    public void run() {
        Border blackLine = BorderFactory.createLineBorder(Color.black);
        Border blank = BorderFactory.createEmptyBorder(10, 10, 10, 10);

        Timers t1 = new Timers(RoundType.Jeopardy);

        frame = new JFrame("Double Jeopardy Round");

        frame.getRootPane().setBorder(blank);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        for (Category c : categories) {
            c.doubleJeopardy();

            ArrayList<Question> questions = c.getQuestionsList();
            JPanel panel = new JPanel();
            panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));

            JLabel cat = new JLabel("<html><p>" + c.getName() + "</p></html>", SwingConstants.CENTER);
            cat.setVerticalAlignment(SwingConstants.CENTER);
            cat.setBorder(blank);
            panel.add(cat);
            cat.setAlignmentX(Box.CENTER_ALIGNMENT);

            for (Question q : questions) {
                JPanel p = new JPanel();
                p.setLayout(new BorderLayout());
                JButton button = new JButton(q.pointString());
                button.addActionListener(new ButtonListener(q, button));
                p.add(button, BorderLayout.CENTER);
                panel.add(p);
            }

            panel.setPreferredSize(new Dimension(210, 500));
            panel.setBorder(blackLine);
            panel.setVisible(true);
            frame.getContentPane().add(panel);
        }

        frame.getContentPane().setLayout(new FlowLayout());

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        t1.start();
        try {
            t1.join();
        } catch (InterruptedException e) {
            System.out.print("Interrupted Jeopardy");
        }
        frame.dispose();

    }

    class ButtonListener implements ActionListener {

        private Question question;
        private JButton button;

        public ButtonListener(Question question, JButton button) {
            this.question = question;
            this.button = button;
        }

        public void actionPerformed(ActionEvent e) {

            AskWindow aw = new AskWindow(question);

            ActionListener a[] = button.getActionListeners();
            button.removeActionListener((ActionListener) Array.get(a, 0));
            button.setText("");
        }
    }

}

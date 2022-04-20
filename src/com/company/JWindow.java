package com.company;

import java.awt.*;
import java.awt.event.*;
import java.lang.reflect.Array;
import java.util.*;
import javax.swing.*;
import javax.swing.border.Border;

public class JWindow extends Thread {

    private ArrayList<Category> categories;
    private ArrayList<Category> categories2;
    private ArrayList<Player> players;
    private JFrame frame;

    public JWindow(ArrayList<Category> categories,ArrayList<Category> categories2) {
        this.categories = categories;
        this.categories2 = categories2;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    public void run() {

        Border blackLine = BorderFactory.createLineBorder(Color.black);
        Border blank = BorderFactory.createEmptyBorder(10, 10, 10, 10);

        Timers t1 = new Timers(RoundType.Jeopardy);

        frame = new JFrame("Jeopardy Round");
        frame.setForeground(Color.white);
        frame.setBackground(Color.blue);
        frame.getRootPane().setBorder(blank);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        for (Category c : categories) {

            ArrayList<Question> questions = c.getQuestionsList();
            JPanel panel = new JPanel();
            panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));

            JLabel cat = new JLabel("<html><p>"+c.getName()+"</p></html>", SwingConstants.CENTER);
            cat.setVerticalAlignment(SwingConstants.CENTER);
            cat.setBorder(blank);
            panel.add(cat);
            cat.setForeground(Color.white);
            cat.setAlignmentX(Box.CENTER_ALIGNMENT);

            for (Question q : questions) {

                JPanel p = new JPanel();
                p.setLayout(new BorderLayout());

                JButton button = new JButton(q.pointString());
                button.addActionListener(new ButtonListener(q, button));
                p.add(button, BorderLayout.CENTER);
                panel.add(p);
                p.setBackground(Color.blue);
            }

            panel.setPreferredSize(new Dimension(210, 500));
            panel.setBorder(blackLine);
            panel.setVisible(true);
            panel.setBackground(Color.blue);
            frame.getContentPane().add(panel);
        }

        frame.getContentPane().setLayout(new FlowLayout());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        t1.start();
        try {
            t1.join();
        } catch(InterruptedException e) {
            System.out.print("Interrupted Jeopardy");
        }
        frame.setVisible(false);
        ScoreBoard board = new ScoreBoard(players);

        Timers t2 = new Timers(RoundType.Double);
        t2.start();
        try {
            t2.join();
        } catch (InterruptedException e) {
            System.out.println("Interrupted Timer");
        }
        board.getBoard().dispose();

        DWindow doubleJeopardy = new DWindow(categories2);
        doubleJeopardy.setPlayers(players);
        doubleJeopardy.start();
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

            AskWindow aw = new AskWindow(question, players);

            ActionListener[] a = button.getActionListeners();
            button.removeActionListener((ActionListener) Array.get(a, 0));
            button.setText("");
        }
    }
}

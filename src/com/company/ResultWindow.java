package com.company;

import java.io.*;
import javax.imageio.*;
import java.awt.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.event.*;
public class ResultWindow extends Thread {

    private Player p1;
    private Player p2;
    private Player p3;

    public ResultWindow(ArrayList<Player> players) {
        p1 = players.get(0);
        p2 = players.get(1);
        p3 = players.get(2);
    }

    public void run() {

        Border blackLine = BorderFactory.createLineBorder(Color.black);
        Border blank = BorderFactory.createEmptyBorder(10, 10, 10, 10);

        JFrame results = new JFrame("And the winner is....");
        results.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        panel.setBorder(blackLine);
        panel.setPreferredSize(new Dimension(100,100));

        JLabel congrats = new JLabel("Congratulations!!!", SwingConstants.CENTER);
        congrats.setVerticalAlignment(SwingConstants.CENTER);
        congrats.setBorder(blank);
        panel.add(congrats);

        JLabel name = new JLabel(getWinner().getName(), SwingConstants.CENTER);
        name.setVerticalAlignment(SwingConstants.CENTER);
        name.setBorder(blank);
        panel.add(name);

        JLabel score = new JLabel(String.valueOf(getWinner().getScore()), SwingConstants.CENTER);
        score.setVerticalAlignment(SwingConstants.CENTER);
        score.setBorder(blank);
        panel.add(score);

        congrats.setAlignmentX(Box.CENTER_ALIGNMENT);
        congrats.setFont(new Font("Times New Roman", Font.BOLD, 15));
        name.setAlignmentX(Box.CENTER_ALIGNMENT);
        name.setFont(new Font("Times New Roman", Font.BOLD, 15));
        score.setAlignmentX(Box.CENTER_ALIGNMENT);
        score.setFont(new Font("Times New Roman", Font.BOLD, 15));

        results.getContentPane().add(new GameWorld(250));
        results.setSize(500,500);
        results.setLocationRelativeTo(null);
        results.setVisible(true);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
        }
        UIManager.put("OptionPane.minimumSize", new Dimension(300,300));
        JOptionPane.showMessageDialog(results, panel);
    }

    public Player getWinner() {

        int points1 = p1.getScore();
        int points2 = p2.getScore();
        int points3 = p3.getScore();
        Player winner = null;

        if ((points1 > points2) && (points1 > points3)) {
            winner = p1;
        } else if ((points2 > points1) && (points2 > points3)) {
            winner = p2;
        } else if ((points3 > points1) && (points3 > points2)) {
            winner = p3;
        }


        return winner;
    }

    class Confetti {

        private double x, y, dx, dy;

        public Confetti() {
            Random r = new Random();
            x = r.nextFloat() * 500;
            y = r.nextFloat() * 500;

            dx = r.nextFloat() * 50 - 25;
            dy = r.nextFloat() * 50 + 100;
        }

        public void draw(Graphics g) {
            g.fillRect((int) x, (int) y, 5, 5);
        }

        public void update(double dt) {
            x += (dx * dt);
            y += (dy * dt);

            if (y < 0) {
                y = 500;
            }
            if (y > 500) {
                y = 0;
            }
            if (x < 0) {
                x = 500;
            }
            if (x > 500) {
                x = 0;
            }
        }
    }

    public class GameWorld extends JComponent {

        private ArrayList<Confetti> yellow;
        private ArrayList<Confetti> red;
        private ArrayList<Confetti> green;
        private ArrayList<Confetti> blue;
        private long last_time;

        public GameWorld(int count) {
            last_time = new Date().getTime();

            yellow = new ArrayList<>(count/4);
            for (int i = 0; i < count; i++) {
                yellow.add(new Confetti());
            }
            red = new ArrayList<>(count/4);
            for (int i = 0; i < count; i++) {
                red.add(new Confetti());
            }
            green = new ArrayList<>(count/4);
            for (int i = 0; i < count; i++) {
                green.add(new Confetti());
            }
            blue = new ArrayList<>(count/4);
            for (int i = 0; i < count; i++) {
                blue.add(new Confetti());
            }
        }

        @Override
        public void paintComponent(Graphics g) {
            g.setColor(Color.white);
            g.fillRect(0,0,500,500);

            g.setColor(Color.yellow);
            for (Confetti c : yellow) {
                c.draw(g);
            }
            g.setColor(Color.red);
            for (Confetti c : red) {
                c.draw(g);
            }
            g.setColor(Color.green);
            for (Confetti c : green) {
                c.draw(g);
            }
            g.setColor(Color.blue);
            for (Confetti c : blue) {
                c.draw(g);
            }

            long time_now = new Date().getTime();
            long elapsed_ms = time_now - last_time;
            double dt = elapsed_ms / 1000.0;

            for (Confetti c : yellow) {
                c.update(dt);
            }
            for (Confetti c : red) {
                c.update(dt);
            }
            for (Confetti c : green) {
                c.update(dt);
            }
            for (Confetti c : blue) {
                c.update(dt);
            }

            last_time = time_now;
            revalidate();
            repaint();
        }
    }
}
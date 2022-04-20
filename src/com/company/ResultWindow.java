package com.company;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import java.util.*;

public class ResultWindow extends Thread {

    private Player p1, p2, p3;

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

        JLabel name = new JLabel(getWinner() + "!!", SwingConstants.CENTER);
        name.setVerticalAlignment(SwingConstants.CENTER);
        name.setBorder(blank);
        panel.add(name);

        congrats.setAlignmentX(Box.CENTER_ALIGNMENT);
        name.setAlignmentX(Box.CENTER_ALIGNMENT);

        results.getContentPane().add(new GameWorld(250));
        results.setSize(500,500);
        results.setLocationRelativeTo(null);
        results.setVisible(true);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

        UIManager.put("OptionPane.minimumSize", new Dimension(200,200));
        JOptionPane.showMessageDialog(results, panel, "Winner!", JOptionPane.PLAIN_MESSAGE);
    }

    public String getWinner() {

        int points1 = p1.getScore();
        int points2 = p2.getScore();
        int points3 = p3.getScore();
        String winner = "";

        if ((points1 > points2) && (points1 > points3)) {
            winner = p1.getName();
        } else if ((points2 > points1) && (points2 > points3)) {
            winner = p2.getName();
        } else if ((points3 > points1) && (points3 > points2)) {
            winner = p3.getName();
        } else {
            if (points1 == points2) {
                winner = p1.getName() + " and " + p2.getName() + " tied!";
            } else if (points1 == points3) {
                winner = p1.getName() + " and " + p3.getName() + " tied!";
            } else if (points2 == points3) {
                winner = p2.getName() + " and " + p3.getName() + " tied!";
            }
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

        private ArrayList<Confetti> yellow, red, green, blue;
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
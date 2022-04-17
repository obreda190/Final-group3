package com.company;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class AskWindow {

    private String category;
    private Question question;
    private JFrame frame;
    private JLabel label;
    private JButton b1;
    private JButton b2;
    private JButton b3;

    public AskWindow(Question q) {
        this.category = q.getCat();
        question = q;
        Border b = BorderFactory.createEmptyBorder(10, 10, 10, 10);

        frame = new JFrame(category);
        frame.getContentPane().add(Box.createVerticalStrut(10));

        label = new JLabel(question.getQuestion());
        label.setBorder(b);
        frame.getContentPane().add(label);
        label.setAlignmentX(Box.CENTER_ALIGNMENT);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        b1 = new JButton("Player 1");
        b2 = new JButton("Player 2");
        b3 = new JButton("Player 3");
        panel.add(b1);
        panel.add(b2);
        panel.add(b3);
        frame.getContentPane().add(panel);
        frame.getContentPane().add(Box.createVerticalStrut(10));

        frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }


}
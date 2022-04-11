package com.company;

import javax.swing.*;
import java.awt.event.*;

public class QuestionWindow {

    private String category;
    private Question question;
    private JFrame frame;
    private JLabel label;
    private JTextField tf;
    private JButton button;

    public QuestionWindow(Question q) {
        this.category = q.getCat();
        question = q;

        frame = new JFrame(category);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        label = new JLabel(question.getQuestion());
        frame.getContentPane().add(label);

        tf = new JTextField(25);
        frame.getContentPane().add(tf);

        button = new JButton("done");
        frame.getContentPane().add(button);

        frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    class ExitListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }

}

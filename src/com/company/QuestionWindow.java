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

        button = new JButton("Done");
        button.addActionListener(new ButtonListener(tf));
        frame.getContentPane().add(button);

        frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public boolean checkAnswer(String response) {
        boolean check;
        String answer = question.getAnswer().toLowerCase();

        check = answer.equals(response.toLowerCase());
        return check;
    }

    class ButtonListener implements ActionListener {

        private JTextField tf;

        public ButtonListener(JTextField tf) {
            this.tf = tf;
        }

        public void actionPerformed(ActionEvent e) {
            String getValue = tf.getText();
            boolean check = checkAnswer(getValue);
            if (check) {
                //call method to add points to player's score
                System.out.println("Correct");
            } else {
                //call method to subtract points to player's score
                // return to whatever state we were in that allowed players to buzz in
                System.out.println("Incorrect, the correct answer was: " + question.getAnswer());
            }
        }
    }

    class ExitListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }

}

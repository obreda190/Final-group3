package com.company;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;

public class QuestionWindow {

    private static final int IFW = JComponent.WHEN_IN_FOCUSED_WINDOW;
    private Action enterAction;

    private String category;
    private Question question;
    private JFrame frame;
    private JLabel name, label;
    private JTextField tf;
    private JButton button;
    private Player player;

    public QuestionWindow(Question q, Player p) {

        Border blank = BorderFactory.createEmptyBorder(5, 5, 5, 5);

        this.category = q.getCat();
        question = q;
        player = p;

        frame = new JFrame(category);

        name = new JLabel(p.getName());
        name.setBorder(blank);
        frame.getContentPane().add(name);

        label = new JLabel(question.getQuestion());
        label.setBorder(blank);
        frame.getContentPane().add(label);

        tf = new JTextField(20);
        frame.getContentPane().add(tf);

        button = new JButton("Submit");
        button.addActionListener(new ButtonListener(tf));
        frame.getContentPane().add(button);
        enterAction = new EnterAction();
        button.getInputMap(IFW).put(KeyStroke.getKeyStroke("ENTER"), "enterAction");
        button.getActionMap().put("enterAction", enterAction);

        frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        tf.requestFocus();
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
                player.addPoints(question.getPoints());
                JOptionPane.showMessageDialog(frame, "Correct! Points have been added to your score.");
            } else {
                player.subtractPoints(question.getPoints());
                JOptionPane.showMessageDialog(frame, "Incorrect, the correct answer was: " + question.getAnswer() +
                        ". Points have been deducted");
            }
            frame.dispose();
        }
    }

    public class EnterAction extends AbstractAction {
        @Override
        public void actionPerformed(ActionEvent e) {
            button.requestFocus();
            button.doClick();
        }
    }
}

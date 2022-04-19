package com.company;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.event.*;

public class QuestionWindow {

    private String category;
    private Question question;
    private JFrame frame;
    private JLabel name;
    private JLabel label;
    private JTextField tf;
    private JButton button;

    private static final int IFW = JComponent.WHEN_IN_FOCUSED_WINDOW;
    private Action enterAction;

    public QuestionWindow(Question q, String player) {
        Timers t1 = new Timers(RoundType.Question);

        Border blank = BorderFactory.createEmptyBorder(5, 5, 5, 5);

        this.category = q.getCat();
        question = q;

        frame = new JFrame(category);

        name = new JLabel(player);
        name.setBorder(blank);
        frame.getContentPane().add(name);

        label = new JLabel(question.getQuestion());
        label.setBorder(blank);
        frame.getContentPane().add(label);

        tf = new JTextField(20);
        frame.getContentPane().add(tf);

        button = new JButton("Done");
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

        t1.start();
        try{
            t1.join();
        }catch(InterruptedException e){
            System.out.println("Timer Interrupted");
        }
        //frame.dispose();

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
                JOptionPane.showMessageDialog(null, "Correct! Points have been added to your score.");
            } else {
                //call method to subtract points to player's score
                JOptionPane.showMessageDialog(null, "Incorrect, the correct answer was: " + question.getAnswer() +
                        ". Points have been deducted");
            }
            frame.dispose();
            //Dispose AskWindow
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

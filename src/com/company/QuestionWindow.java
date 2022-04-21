package com.company;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;

/**
 * @author Niko Toro, Grace Ordonez, Olivia Breda
 * This class creates a JFrame containing a Question object and a JTextField to allow a player to type in an answer
 */
public class QuestionWindow {

    private static final int IFW = JComponent.WHEN_IN_FOCUSED_WINDOW;

    private final Player player;
    private final Question question;
    private final JFrame frame;
    private final JButton button;

    /**
     * Non-default constructor that creates and displays a new JFrame containing a question, JTextField, and JButton
     * @param question Question object representing the question being asked
     * @param player Player object representing the player who buzzed in
     */
    public QuestionWindow(Question question, Player player) {

        // Border used in JFrame layout
        Border blank = BorderFactory.createEmptyBorder(5, 5, 5, 5);

        String category = question.getCat();
        this.question = question;
        this.player = player;

        // New JFrame created
        frame = new JFrame(category);

        // New JLabel created with the name of player who buzzed in
        JLabel name = new JLabel(player.getName());
        name.setBorder(blank);
        frame.getContentPane().add(name);

        // New JLabel created with the String value of the desired Question object
        JLabel label = new JLabel(question.getQuestion());
        label.setBorder(blank);
        frame.getContentPane().add(label);

        // New JTextField created
        JTextField tf = new JTextField(20);
        frame.getContentPane().add(tf);

        // New JButton created and bound to the 'ENTER' key for the player to submit and check their answer
        button = new JButton("Submit");
        button.addActionListener(new ButtonListener(tf));
        frame.getContentPane().add(button);
        Action enterAction = new EnterAction();
        button.getInputMap(IFW).put(KeyStroke.getKeyStroke("ENTER"), "enterAction");
        button.getActionMap().put("enterAction", enterAction);

        // JFrame packed and displayed
        frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        tf.requestFocus();
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    /**
     * Method that compares given String to a Question object's answer.
     * @param response String value entered by a player
     * @return true when the player's response is equal to the answer and false otherwise
     */
    public boolean checkAnswer(String response) {

        boolean check;

        String answer = question.getAnswer().toLowerCase();
        check = answer.equals(response.toLowerCase());

        return check;
    }

    /**
     * @author Niko Toro, Grace Ordonez, Olivia Breda
     * This class establishes a ButtonListener object that tells JButtons how they should behave once clicked.
     */
    class ButtonListener implements ActionListener {

        private final JTextField tf;

        /**
         * Non-default constructor that instantiates a JTextField object
         * @param tf JTextField where the player entered their answer
         */
        public ButtonListener(JTextField tf) {
            this.tf = tf;
        }

        /**
         * Overridden actionPerformed method that compares the response in the JTextField to the answer,
         * a popup window appears telling the player if the response was correct or incorrect and adjust points accordingly.
         * Disposes of the QuestionWindow's JFrame when complete.
         * @param e ActionEvent representing the clicking of a JButton
         */
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

    /**
     * @author Niko Toro
     * This class creates an AbstractAction used to bind the 'ENTER' key to the submit JButton
     */
    public class EnterAction extends AbstractAction {
        @Override
        public void actionPerformed(ActionEvent e) {
            button.requestFocus();
            button.doClick();
        }
    }
}

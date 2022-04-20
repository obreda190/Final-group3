package com.company;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;
import java.util.*;

/**
 * @author Niko Toro, Grace Ordonez, Olivia Breda
 * This class creates a JFrame containing a Question object and a JButton "buzzer" for each Player
 */
public class AskWindow {

    private static final int IFW = JComponent.WHEN_IN_FOCUSED_WINDOW;

    private final Question question;
    private final JFrame frame;
    private final JButton b1, b2, b3;

    /**
     * Non-default constructor that creates and displays a new JFrame containing a question and one "buzzer" for each player
     * @param question Question object representing the question being asked
     * @param players ArrayList containing the Player objects that represent the current players
     */
    public AskWindow(Question question, ArrayList<Player> players) {

        // Border used in JFrame layout
        Border blank = BorderFactory.createEmptyBorder(10, 10, 10, 10);

        // New JFrame created and formatted
        this.question = question;
        String category = question.getCat();
        frame = new JFrame(category);
        frame.getContentPane().add(Box.createVerticalStrut(10));

        // New JLabel created with the String value of a desired Question object
        JLabel label = new JLabel(question.getQuestion());
        label.setBorder(blank);
        frame.getContentPane().add(label);
        label.setAlignmentX(Box.CENTER_ALIGNMENT);

        // New JPanel created and formatted to store buzzers in
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

        // New JButton created and bound to the 'Q' key for player one's buzzer
        b1 = new JButton("Q: " + (players.get(0)).getName());
        panel.add(b1);
        b1.addActionListener(new ButtonListener(players.get(0)));
        Action qPress = new QPress();
        b1.getInputMap(IFW).put(KeyStroke.getKeyStroke('q'), "qPress");
        b1.getActionMap().put("qPress", qPress);

        // New JButton created and bound to the 'B' key for player two's buzzer
        b2 = new JButton("B: " + (players.get(1)).getName());
        panel.add(b2);
        b2.addActionListener(new ButtonListener(players.get(1)));
        Action bPress = new BPress();
        b2.getInputMap(IFW).put(KeyStroke.getKeyStroke('b'), "bPress");
        b2.getActionMap().put("bPress", bPress);

        // New JButton created and bound to the 'P' key for player three's buzzer
        b3 = new JButton("P: " + (players.get(2)).getName());
        panel.add(b3);
        b3.addActionListener(new ButtonListener(players.get(2)));
        Action pPress = new PPress();
        b3.getInputMap(IFW).put(KeyStroke.getKeyStroke('p'), "pPress");
        b3.getActionMap().put("pPress", pPress);

        // JPanel added to JFrame and given focus to allow for buzzers to work
        frame.getContentPane().add(panel);
        panel.requestFocus();
        frame.getContentPane().add(Box.createVerticalStrut(10));

        // JFrame packed and displayed
        frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    /**
     * @author Niko Toro, Grace Ordonez, Olivia Breda
     * This class establishes a ButtonListener object that tells JButtons how they should behave once clicked.
     */
    class ButtonListener implements ActionListener {

        private final Player player;

        /**
         * Non-default constructor that instantiates a Player object
         * @param player Player object representing the player that the buzzer corresponds to
         */
        public ButtonListener(Player player) {
            this.player = player;
        }

        /**
         * Overridden actionPerformed method that creates a new QuestionWindow object upon a JButton being clicked,
         * disposing of the AskWindow's JFrame when complete.
         * @param e ActionEvent representing the clicking of a JButton
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            new QuestionWindow(question, player);
            frame.dispose();
        }
    }

    /**
     * @author Niko Toro
     * This class creates an AbstractAction used to bind the 'Q' key to player one's buzzer
     */
    public class QPress extends AbstractAction {
        @Override
        public void actionPerformed(ActionEvent e) {
            b1.requestFocus();
            b1.doClick();
        }
    }

    /**
     * @author Niko Toro
     * This class creates an AbstractAction used to bind the 'B' key to player two's buzzer
     */
    public class BPress extends AbstractAction {
        @Override
        public void actionPerformed(ActionEvent e) {
            b2.requestFocus();
            b2.doClick();
        }
    }

    /**
     * @author Niko Toro
     * This class creates an AbstractAction used to bind the 'P' key to player three's buzzer
     */
    public class PPress extends AbstractAction {
        @Override
        public void actionPerformed(ActionEvent e) {
            b3.requestFocus();
            b3.doClick();
        }
    }
}

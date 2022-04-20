package com.company;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;
import java.util.*;

public class AskWindow {

    private static final int IFW = JComponent.WHEN_IN_FOCUSED_WINDOW;
    private Action qPress, bPress, pPress;

    private String category;
    private Question question;
    private JFrame frame;
    private JLabel label;
    private JButton b1, b2, b3;

    public AskWindow(Question q, ArrayList<Player> players) {

        Border blank = BorderFactory.createEmptyBorder(10, 10, 10, 10);

        category = q.getCat();
        question = q;
        frame = new JFrame(category);
        frame.getContentPane().add(Box.createVerticalStrut(10));

        label = new JLabel(question.getQuestion());
        label.setBorder(blank);
        frame.getContentPane().add(label);
        label.setAlignmentX(Box.CENTER_ALIGNMENT);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

        b1 = new JButton((players.get(0)).getName() + ": Q");
        panel.add(b1);
        b1.addActionListener(new ButtonListener(players.get(0)));
        qPress = new QPress();
        b1.getInputMap(IFW).put(KeyStroke.getKeyStroke('q'), "qPress");
        b1.getActionMap().put("qPress", qPress);

        b2 = new JButton((players.get(1)).getName() + ": B");
        panel.add(b2);
        b2.addActionListener(new ButtonListener(players.get(1)));
        bPress = new BPress();
        b2.getInputMap(IFW).put(KeyStroke.getKeyStroke('b'), "bPress");
        b2.getActionMap().put("bPress", bPress);

        b3 = new JButton((players.get(2)).getName() + ": P");
        panel.add(b3);
        b3.addActionListener(new ButtonListener(players.get(2)));
        pPress = new PPress();
        b3.getInputMap(IFW).put(KeyStroke.getKeyStroke('p'), "pPress");
        b3.getActionMap().put("pPress", pPress);

        frame.getContentPane().add(panel);
        panel.requestFocus();
        frame.getContentPane().add(Box.createVerticalStrut(10));

        frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    class ButtonListener implements ActionListener {

        private Player p;

        public ButtonListener(Player p) {
            this.p = p;
        }

        public void actionPerformed(ActionEvent e) {
            QuestionWindow qw = new QuestionWindow(question, p);
            frame.dispose();
        }
    }

    public class QPress extends AbstractAction {
        @Override
        public void actionPerformed(ActionEvent e) {
            b1.requestFocus();
            b1.doClick();
        }
    }

    public class BPress extends AbstractAction {
        @Override
        public void actionPerformed(ActionEvent e) {
            b2.requestFocus();
            b2.doClick();
        }
    }

    public class PPress extends AbstractAction {
        @Override
        public void actionPerformed(ActionEvent e) {
            b3.requestFocus();
            b3.doClick();
        }
    }
}

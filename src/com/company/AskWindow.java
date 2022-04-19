package com.company;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class AskWindow {

    private String category;
    private Question question;
    private JFrame frame;
    private JLabel label;
    private JButton b1;
    private JButton b2;
    private JButton b3;

    private static final int IFW = JComponent.WHEN_IN_FOCUSED_WINDOW;
    private Action qPress;
    private Action bPress;
    private Action pPress;

    public AskWindow(Question q) {

        Timers t1 = new Timers(RoundType.Question);

        Border blank = BorderFactory.createEmptyBorder(10, 10, 10, 10);

        this.category = q.getCat();
        question = q;

        frame = new JFrame(category);
        frame.getContentPane().add(Box.createVerticalStrut(10));
        //Add timer

        label = new JLabel(question.getQuestion());
        label.setBorder(blank);
        frame.getContentPane().add(label);
        label.setAlignmentX(Box.CENTER_ALIGNMENT);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

        b1 = new JButton("Player 1" + ": Q"); //Get name of player 1 for the name of the button
        panel.add(b1);
        b1.addActionListener(new ButtonListener(b1.getText()));
        qPress = new QPress();
        b1.getInputMap(IFW).put(KeyStroke.getKeyStroke('q'), "qPress");
        b1.getActionMap().put("qPress", qPress);

        b2 = new JButton("Player 2" + ": B"); //Get name of player 2 for the name of the button
        panel.add(b2);
        b2.addActionListener(new ButtonListener(b2.getText()));
        bPress = new BPress();
        b2.getInputMap(IFW).put(KeyStroke.getKeyStroke('b'), "bPress");
        b2.getActionMap().put("bPress", bPress);

        b3 = new JButton("Player 3" + ": P"); //Get name of player 3 for the name of the button
        panel.add(b3);
        b3.addActionListener(new ButtonListener(b3.getText()));
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

        t1.start();
        try{
            t1.join();
        }catch(InterruptedException e){
            System.out.println("");
        }
        //frame.dispose();
    }

    class ButtonListener implements ActionListener {

        private String name;

        public ButtonListener(String name) {
            this.name = name;
        }

        public void actionPerformed(ActionEvent e) {
            QuestionWindow qw = new QuestionWindow(question, name);
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

package com.company;

import javax.swing.*;

public class Timers extends Thread {

    private RoundType rt;

    public Timers(RoundType rt) {
        this.rt = rt;
    }

    @Override
    public void run() {
        //Timer for rounds (regular jeopardy/double jeopardy possibly final?)
        if (rt == RoundType.Jeopardy) {
            try {
                Thread.sleep(10000);
                JOptionPane.showMessageDialog(null,"One minute remaining","Warning", JOptionPane.WARNING_MESSAGE);
                Thread.sleep(10000);

            } catch (InterruptedException e) {
                System.out.println("Timer Interrupted");
            }

        } else if (rt == RoundType.Double) {
            try {
                Thread.sleep(5000);
                //subtract points from player who buzzed in
            } catch (InterruptedException e) {
                System.out.println("Timer Interrupted");
            }

        }
    }
}

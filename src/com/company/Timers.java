package com.company;

import javax.swing.*;

public class Timers extends Thread {

    private RoundType rt;

    public Timers(RoundType rt) {
        this.rt = rt;
    }

    @Override
    public void run() {

        if (rt == RoundType.Jeopardy) {
            try {
                Thread.sleep(120000);
                JOptionPane.showMessageDialog(null,"One minute remaining","Warning", JOptionPane.WARNING_MESSAGE);
                Thread.sleep(60000);
            } catch (InterruptedException e) {
                System.out.println("Timer Interrupted");
            }
        } else if (rt == RoundType.Double) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                System.out.println("Timer Interrupted");
            }
        }
    }
}

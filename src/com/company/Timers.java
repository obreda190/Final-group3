package com.company;

import javax.swing.*;

/**
 * @author Grace Ordonez, Niko Toro, Olivia Breda
 * this class represents the timers for each round of jeopardy and the intermission
 */
public class Timers extends Thread {

    private RoundType rt;

    /**
     * create a timer with specific RoundType enum to ensure correct timing
     * @param rt RoundType
     */
    public Timers(RoundType rt) {
        this.rt = rt;
    }

    /**
     * creates a timer by sleeping the thread of a predetermined amount of time depending on the RoundType provided
     */
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

package com.company;

import javax.swing.*;

public class Timers extends Thread {

    private RoundType rt;

    public Timers(RoundType rt){
        this.rt = rt;
    }

    @Override
    public void run(){
        //Timer for rounds (regular jeopardy/double jeopardy possibly final?)
        if (rt == RoundType.Jeopardy){
            try {
                //sleep for 5 seconds for testing
                Thread.sleep(5000);
                //warning for a min
                JOptionPane.showMessageDialog(null,"One minute remaining","Warning", JOptionPane.WARNING_MESSAGE);
                //sleep for another 5 seconds for testing
                Thread.sleep(5000);

            } catch (InterruptedException e) {
                System.out.println("Timer Interrupted");
            }
            //add question timer and final timer if necessary

        }
    }
}

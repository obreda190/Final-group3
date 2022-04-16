package com.company;

import javax.swing.*;

public class Timers extends Thread {
    private String type;

    public Timers(String type){
        this.type = type;
    }

    @Override
    public void run(){
        //Timer for rounds (regular jeopardy/double jeopardy possibly final?)
        if (type.equals("jeopardy")){
            try {
                //sleep for 30 seconds for testing
                Thread.sleep(30000);
                //warning for a min
                JOptionPane.showMessageDialog(null,"One minute remaining","Warning", JOptionPane.WARNING_MESSAGE);
                //sleep for another 30 seconds for testing
                Thread.sleep(30000);

            } catch (InterruptedException e) {
                System.out.println("Timer Interrupted");
            }
            //add question timer and final timer if necessary

        }
    }
}

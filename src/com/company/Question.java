package com.company;

import java.util.*;

/**
 * @author Grace Ordonez, Niko Toro, Olivia Breda
 * gets questions, answers, and points and makes them accessible variables
 */

public class Question {

    String category, question, answer;
    int points;
    boolean asked;

    /**
     * takes question answer and points from category file
     * @param in
     * @param category
     */

    public Question(Scanner in, String category) {

        this.category = category;
        question = in.nextLine();
        answer = in.nextLine();

        String pointsString = in.nextLine();
        points = Integer.parseInt(pointsString);

        String askedString = in.nextLine();
        asked = Boolean.parseBoolean(askedString);

        if (in.hasNextLine()) {
            if (in.nextLine().length() == 0) {
                in.skip("");
            }
        }
    }

    /**
     * makes category accessible
     * @return category
     */

    public String getCat() {
        return category;
    }

    /**
     * makes question accessible
     * @return question
     */

    public String getQuestion() {
        return question;
    }

    /**
     * makes answer accessible
     * @return answer
     */

    public String getAnswer() {
        return answer;
    }

    /**
     * makes points accessible
     * @return points
     */

    public int getPoints() {
        return points;
    }

    /**
     * points as a string
     * @return data points
     */

    public String pointString() {
        String data = "";
        data = data + points;
        return data;
    }

    public void doubleJeopardy() {
        points = points * 2;
    }

    /**
     * string versions of all variables
     * @return data
     */

    @Override
    public String toString() {
        String data = "";
        data = data + question + "\n";
        data = data + answer + "\n";
        data = data + points + "\n";
        data = data + asked + "\n";

        return data;
    }
}

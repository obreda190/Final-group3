package com.company;

import java.util.*;

public class Question {

    String category;
    String question;
    String answer;
    int points;
    boolean asked;

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

    public String getCat() {
        return category;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    public int getPoints() {
        return points;
    }

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

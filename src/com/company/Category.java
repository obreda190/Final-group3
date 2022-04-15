package com.company;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Category {

    private String name;
    private ArrayList<Question> category;

    public Category(String name) {
        this.name = name;
        category = new ArrayList<>();

        Scanner reader = null;
        FileInputStream file;

        try {
            file = new FileInputStream("./jeopardy" + File.separator + name);
            reader = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

        while (reader.hasNextLine()) {
            Question q = new Question(reader, getName());
            category.add(q);
        }
    }

    public void doubleJeopardy() {
        for (Question q : category) {
            q.doubleJeopardy();
        }
    }

    public ArrayList<Question> getQuestionsList() {
        return category;
    }

    public String getName() {
        return name.replace("_", " ")
                .replace("(", "\"")
                .replace(")", "\"")
                .replace(".jeopardy", "")
                .toUpperCase(Locale.ROOT);
    }

    public Question getQuestion(int points) {
        int i;
        Question key = null;
        for (Question q : category) {
            i = q.getPoints();
            if (i == points) {
                key = q;
            }
        }
        return key;
    }

    @Override
    public String toString (){
        String data = "";
        data = data + "Category: " + getName() + "\n";
        for (Question q : category) {
            data = data + "Question " + (category.indexOf(q) + 1) + ":\n";
            data = data + q.toString() + "\n";
        }
        return data;
    }

}

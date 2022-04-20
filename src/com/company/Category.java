package com.company;

import java.io.*;
import java.util.*;

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

    public ArrayList<Question> getQuestionsList() {
        return category;
    }

    public void doubleJeopardy() {
        for (Question q : category) {
            q.doubleJeopardy();
        }
    }

    public String getName() {

        String data = name;
        data = data.replace("_", " ");
        data = data.replace("(", "\"");
        data = data.replace(")", "\"");
        data = data.replace(".jeopardy", "");

        return data.toUpperCase();
    }

    @Override
    public String toString() {
        String data = "";
        data = data + "Category: " + getName() + "\n";

        for (Question q : category) {
            data = data + "Question " + (category.indexOf(q) + 1) + ":\n";
            data = data + q.toString() + "\n";
        }
        return data;
    }
}

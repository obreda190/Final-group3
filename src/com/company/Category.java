package com.company;

import java.io.*;
import java.util.*;

/**
 * @author Grace Ordonez, Niko Toro, Olivia Breda
 * This class denotes categories and references the questions in them
 */

public class Category {

    private final String name;
    private final ArrayList<Question> category;

    /**
     * Non-default constructor gets categories from jeopardy directory
     * @param name String value representing the name of the .jeopardy file
     */
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

    /**
     * Getter method that retrieves the questions from a given category
     * @return An ArrayList containing all the Question objects in a Category
     */
    public ArrayList<Question> getQuestionsList() {
        return category;
    }

    /**
     * Method that iterates through the questions of a category and doubles their point value
     */
    public void doubleJeopardy() {
        for (Question q : category) {
            q.doubleJeopardy();
        }
    }

    /**
     * Getter method that retrieves a readable version of the Category name
     * @return String value representing the name of a Category to use for display
     */
    public String getName() {

        String data = name;
        data = data.replace("_", " ");
        data = data.replace("(", "\"");
        data = data.replace(")", "\"");
        data = data.replace(".jeopardy", "");

        return data.toUpperCase();
    }

    /**
     * Overridden toString method that presents the contents of a Category object as a String
     * @return String value of the contents of a Category object
     */
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

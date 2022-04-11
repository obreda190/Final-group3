package com.company;

import java.io.File;
import java.util.*;

public class Jeopardy {

    public static void main(String[] args) {

        ArrayList<String> categories = getCategories();
        ArrayList<Category> cat = new ArrayList<>();

        for (String s : categories) {
            Category c = new Category(s);
            cat.add(c);
        }

        Category c = cat.get(1);
        QuestionWindow q = new QuestionWindow(c.getQuestion(200));
    }

    public static ArrayList<String> getCategories() {

        ArrayList<String> names;

        File f = new File("./jeopardy");
        names = new ArrayList<>(Arrays.asList(f.list()));

        return names;
    }

}

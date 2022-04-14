package com.company;

import java.io.File;
import java.util.*;

public class Jeopardy {

    public static void main(String[] args) {

        ArrayList<Category> cat = getRoundCategories();

        System.out.println(cat);

    }

    public static ArrayList<Category> getAllCategories() {
        ArrayList<String> allNames;
        ArrayList<Category> allCats = new ArrayList<>();

        File f = new File("./jeopardy");
        allNames = new ArrayList<>(Arrays.asList(f.list()));

        for (String s : allNames) {
            Category c = new Category(s);
            allCats.add(c);
        }

        return allCats;
    }

    public static ArrayList<Category> getRoundCategories() {
        ArrayList<Category> allCats = getAllCategories();
        ArrayList<Category> roundCats = new ArrayList<>();
        Random rng = new Random();
        int sampleSize = allCats.size();

        for (int i = 0; i < 6; i++) {
            int num = rng.nextInt(sampleSize);
            Category c = allCats.get(num);
            roundCats.add(c);
            allCats.remove(c);
            sampleSize--;
        }

        return roundCats;
    }

}

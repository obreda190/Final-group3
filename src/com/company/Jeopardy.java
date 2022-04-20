package com.company;

import java.io.*;
import java.util.*;

public class Jeopardy {

    public static void main(String[] args) {
        ArrayList<Player> play = new ArrayList<>();
        ArrayList<Category> cats = getAllCategories();
        ArrayList<Category> roundCat = getRoundCategories(cats);
        ArrayList<Category> roundCat2 = getRoundCategories(cats);

        JWindow jeopardyWindow = new JWindow(roundCat,roundCat2);
        PlayerWindow player = new PlayerWindow(play,jeopardyWindow);
        MenuWindow menu = new MenuWindow(player);

    }

    public static ArrayList<Category> getRoundCategories(ArrayList<Category> catList) {
        ArrayList<Category> roundCats = new ArrayList<>();
        Random rng = new Random();
        int sampleSize = catList.size();

        for (int i = 0; i < 6; i++) {
            int num = rng.nextInt(sampleSize);
            Category c = catList.get(num);

            roundCats.add(c);
            catList.remove(c);
            sampleSize--;
        }

        return roundCats;
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
}

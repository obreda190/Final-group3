package com.company;

import javax.lang.model.type.IntersectionType;
import java.io.File;
import java.util.*;

public class Jeopardy {

    public static void main(String[] args) throws InterruptedException {

        ArrayList<Player> play = new ArrayList<>();
        ArrayList<Category> cats = getAllCategories();
        ArrayList<Category> roundCat = getRoundCategories(cats);

        JWindow jeopardyWindow = new JWindow(roundCat);
        PlayerWindow player = new PlayerWindow(play,jeopardyWindow);
        MenuWindow menu = new MenuWindow(player);

        System.out.println("DONE");
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

    //Get final category
}

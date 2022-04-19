package com.company;

import javax.lang.model.type.IntersectionType;
import java.io.File;
import java.util.*;

public class Jeopardy {

    public static void main(String[] args) throws InterruptedException {

        //MenuWindow menu = new MenuWindow();
        //Thread mt = new Thread(menu);
        //mt.start();
        //mt.join();

        //ArrayList<Category> cats = getAllCategories();
        //ArrayList<Category> roundCat = getRoundCategories(cats);
        //ArrayList<Category> roundCat2 = getRoundCategories(cats);
        //JWindow jeopardyWindow = new JWindow(roundCat, 1);
        //jeopardyWindow.start();
        //jeopardyWindow.join();
        //JWindow doubleWindow = new JWindow(roundCat2, 2);
        //doubleWindow.start();
        //doubleWindow.join();

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

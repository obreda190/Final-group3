package com.company;

import java.io.File;
import java.util.*;

public class Jeopardy {

    public static void main(String[] args) throws InterruptedException {

        MenuWindow menu = new MenuWindow();
        //Below makes it so until this window is interrupted it will display the menu.
        //Thread m = menu.getThread();
        //m.join();


        ArrayList<Category> cats = getAllCategories();

        ArrayList<Category> roundCat = getRoundCategories(cats);

        JWindow jeopardyWindow = new JWindow(roundCat, 1);

        ArrayList<Player> play = new ArrayList<Player>();
        Player one = new Player("Jerry");
        Player two = new Player("Jeremy");
        Player three = new Player("Jessica");
        play.add(one);
        play.add(two);
        play.add(three);

        ScoreBoard score = new ScoreBoard(play);
        score.start();

        ArrayList<Category> roundCat2 = getRoundCategories(cats);
        JWindow doubleWindow = new JWindow(roundCat2, 2);

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

}

package com.company;

import java.io.File;
import java.util.*;

public class Jeopardy {

    public static void main(String[] args) throws InterruptedException {
        ArrayList<Player> play = new ArrayList<Player>();
        ArrayList<Category> cats = getAllCategories();

        ArrayList<Category> roundCat = getRoundCategories(cats);
        ArrayList<Category> roundCat2 = getRoundCategories(cats);
        JWindow jeopardyWindow = new JWindow(roundCat, 1);
        JWindow doubleWindow = new JWindow(roundCat2, 2);
        PlayerWindow player = new PlayerWindow(play,jeopardyWindow,doubleWindow);
        MenuWindow menu = new MenuWindow(player);



        //Player one = new Player("Jerry");
        //Player two = new Player("Jeremy");
        //Player three = new Player("Jessica");
        //play.add(one);
        //play.add(two);
        //play.add(three);

        //ScoreBoard score = new ScoreBoard(play);
        //score.start();


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

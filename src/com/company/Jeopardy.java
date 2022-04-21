package com.company;

import java.io.*;
import java.util.*;

/**
 * @author Grace Ordonez, Niko Toro, Olivia Breda
 * Class that runs a replica of the Jeopardy game show
 */
public class Jeopardy {

    /**
     * Main method that runs the actual Jeopardy program
     * @param args
     */
    public static void main(String[] args) {
        ArrayList<Player> play = new ArrayList<>();
        ArrayList<Category> cats = getAllCategories();
        ArrayList<Category> roundCat = getRoundCategories(cats);
        ArrayList<Category> roundCat2 = getRoundCategories(cats);

        JWindow jeopardyWindow = new JWindow(roundCat,roundCat2);
        PlayerWindow player = new PlayerWindow(play,jeopardyWindow);
        MenuWindow menu = new MenuWindow(player);

    }

    /**
     * Method that retrieves 6 random Category objects to be used in one round, deleting them from the ArrayList
     * containing all the category files found
     * @param catList ArrayList representing all the category files found in the jeopardy directory
     * @return ArrayList containing 6 randomly chosen Category objects
     */
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

    /**
     * Method that iterates through the jeopardy directory, adding the contents of each file into a Category object
     * @return ArrayList representing all the category files found in the jeopardy directory
     */
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

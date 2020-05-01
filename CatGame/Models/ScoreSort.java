package CatGame.Models;

/*
this program will help sort the scores in a text file
@author anthony cardenas barrera, Gregory Dwyer
last updated:5/1/20
 */
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import java.io.BufferedReader;

public class ScoreSort {

    //declare the bufferedReader and Arraylist
    private BufferedReader reader;
    private ArrayList<String> sortedScores;

    public ScoreSort() {
        //create treemap (high score,list of players)  to sort scores and handle those that are equal
        TreeMap<Integer, List<String>> highestScores = new TreeMap<Integer, List<String>>();
        //set up file reader to open the scores text file
        try {
            this.reader = new BufferedReader(new FileReader("src/resources/GameScores.txt"));

            String line = null;
            //while loop to read the text file line by line and to split the names and scores
            while ((line = this.reader.readLine()) != null) {
                String[] playerScores = line.split(": ");
                int score = Integer.valueOf(playerScores[1]);
                List<String> playerList = null;

                //check if a player with that score already exists and if not
                if ((playerList = highestScores.get(score)) == null) {
                    //create a new list
                    playerList = new ArrayList<>(1);
                    playerList.add(playerScores[0]);
                    highestScores.put(Integer.valueOf(playerScores[1]), playerList);
                } // if they do exist, then add to the existing list
                else {
                    playerList.add(playerScores[0]);
                }
            }

            this.sortedScores = new ArrayList<String>();
            String entry;
            //for loop to iterate through the scores in treemap
            for (Integer score : highestScores.descendingKeySet()) {
                // for loop to iterate over player list in treemap
                for (String player : highestScores.get(score)) {
                    entry = player + " : " + score;
                    this.sortedScores.add(entry);
                }
            }
        } catch (Exception e) {
            System.out.println("ScoreSort: " + e);
        }
    }

//=================  GETTERS ===============
    public ArrayList<String> getArrayList() {
        return this.sortedScores;
    }
}

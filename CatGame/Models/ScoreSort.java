package CatGame.Models;

/*
this program will help sort the scores in a text file
@author anthony cardenas barrera
last updated:3/10/20
 */
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import java.io.BufferedReader;
import java.util.Scanner;

public class ScoreSort {
	//create a BufferedReader

	private BufferedReader reader;
	//method to sort the scores in the txt file

	public void Sorter() throws IOException {
		// (key-value pairs) = (high score - (list of players)) sorts scores and handles those that are equal
		TreeMap<Integer, List<String>> highestScores = new TreeMap<Integer, List<String>>();
		//try to open the dummyScores.txt file
		try {
			reader = new BufferedReader(new FileReader("C:\\Users\\antho\\Documents\\netbeans projects\\RuntimeTerrors\\src\\resources\\dummyScores.txt"));
		} catch (FileNotFoundException e) {
			System.out.println("Cannot find dummy file");
		}

		String line = null;
		//while loop
		while ((line = reader.readLine()) != null) {
			String[] playerScores = line.split(": ");
			int score = Integer.valueOf(playerScores[1]);
			List<String> playerList = null;

			// check if a player with that score already exists
			if ((playerList = highestScores.get(score)) == null) { // if NOT,
				playerList = new ArrayList<String>(1); // CREATE a new list
				playerList.add(playerScores[0]);
				highestScores.put(Integer.valueOf(playerScores[1]), playerList);
			} else { // if YES, ADD to the existing list
				playerList.add(playerScores[0]);
			}
		}

		// iterate in descending order
		for (Integer score : highestScores.descendingKeySet()) {
			for (String player : highestScores.get(score)) { // iterate over player list
				System.out.println(player + ": " + score);
			}
		}
	}
	//main method

	public static void main(String[] args) throws IOException {
		ScoreSort sortGame = new ScoreSort();
		sortGame.Sorter();
	}
}

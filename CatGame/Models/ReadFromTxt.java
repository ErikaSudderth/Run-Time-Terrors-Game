package CatGame.Models;

/**
 * this class uses a scanner to read a text file line by line display the contents
 *
 * @author anthony cardenas barrera last updated: 3/11/20
 */
import java.io.*;
import java.util.Scanner;

public class ReadFromTxt {
	private Scanner scores;
	//open the text file & display error message if file is not foun
	public void openFile() throws FileNotFoundException {
		try {
			scores = new Scanner(new File("src/resources/GameScores.txt"));
		} catch (FileNotFoundException e) {
			System.out.println("could not find file");
		}
	}

	//reads the contents using the scanner. Sets the variables of the text file
        int counter = 0;
	public void readFile() {
		while (scores.hasNextLine() && counter < 5) {
                    System.out.println(scores.nextLine());
                    counter++;
		}
	}
	//close the file
	public void closeFile() {
		scores.close();
	}
    }

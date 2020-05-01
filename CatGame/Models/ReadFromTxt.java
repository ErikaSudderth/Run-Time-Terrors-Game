package CatGame.Models;

/**
 * This class uses a scanner to read a text file line by line and display the contents.
 *
 * @author Anthony Cardenas Barrera
 * Last updated: 3/11/20
 */

import java.io.*;
import java.util.Scanner;

public class ReadFromTxt {

    private Scanner scores;
    int counter = 0;

    /**This method opens the text file & displays error message if file is not found.
     * @throws FileNotFoundException
     */
    public void openFile() throws FileNotFoundException {
        try {
            this.scores = new Scanner(new File("src/resources/GameScores.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("could not find file");
        }
    }

    /**The method reads the contents using the scanner. Sets the variables of the text file.
     */
    public void readFile() {
        while (this.scores.hasNextLine() && this.counter < 5) {
            System.out.println(this.scores.nextLine());
            this.counter++;
        }
    }

    /**This method closes the file.
     */
    public void closeFile() {
        this.scores.close();
    }
}

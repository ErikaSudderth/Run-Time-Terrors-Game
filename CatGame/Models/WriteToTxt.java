package CatGame.Models;

/**
 * the WriteToText class is used to append text to the text file "GameScores"
 * @author anthony cardenas barrera
 * last updated: 3/9/20
 */

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class WriteToTxt{
    //method creates a FileWriter, BufferedWriter, and PrintWriter
    public void writeTo() throws IOException{
       FileWriter fw = new FileWriter("C:\\Users\\antho\\Documents\\netbeans projects\\RuntimeTerrors\\src\\resources\\GameScores.txt", true);
       BufferedWriter bf = new BufferedWriter(fw);
       PrintWriter pw = new PrintWriter(bf);
       //new scores to be added to the txt file
       pw.println("5  208");
       pw.close();
    }
}
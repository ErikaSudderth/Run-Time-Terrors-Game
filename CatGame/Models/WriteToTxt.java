package CatGame.Models;

/**
 * the Writer class is used to append text to the text file "GameScores"
 * @author anthony cardenas barrera
 * last updated: 3/9/20
 */

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class WriteToTxt{

    public void writeTo() throws IOException{
       FileWriter fw = new FileWriter("src/GameScores.txt", true);
       BufferedWriter bf = new BufferedWriter(fw);
       PrintWriter pw = new PrintWriter(bf);

       pw.println("5 loser1 208");
       pw.println("6 loser2 104");
       pw.close();
    }
}
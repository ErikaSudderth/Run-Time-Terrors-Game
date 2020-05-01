package CatGame.Models;

/**
 * The WriteToText class is used to append text to the text file "GameScores."
 *
 * @author Anthony Cardenas Barrera, Greg Dwyer
 * Last updated: 4/2/20
 */

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteToTxt {

    /** This method creates a FileWriter, BufferedWriter, and PrintWriter.
     * @param _text
     * @param _points
     * @throws IOException
     */
    public void writeTo(String _text, int _points) throws IOException {
        if(_text.isEmpty()){
            _text = "(No Name)";
        }

	try {
            FileWriter fw = new FileWriter("src/resources/GameScores.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            if(_points > 0){
                bw.write(_text + ":" + " " + _points);
                bw.newLine();
            }
            bw.close();
            System.out.println("new player added");
       } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

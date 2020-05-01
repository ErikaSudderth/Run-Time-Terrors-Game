package CatGame.Models;

/**
 * the WriteToText class is used to append text to the text file "GameScores"
 *
 * @author anthony cardenas barrera, Greg Dwyer last updated: 5/1/20
 */
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteToTxt {

    /**
     * This method creates a FileWriter, BufferedWriter, and PrintWriter
     *
     * @param _text
     * @param _points
     * @throws IOException
     */
    public void writeTo(String _text, int _points) throws IOException {
        //In the case that a player doesn't input their name when prompted to, _text = no name.
        if (_text.isEmpty()) {
            _text = "(No Name)";
        }
        //try to open the gameScores.txt file to read its content
        try {
            FileWriter fw = new FileWriter("src/resources/GameScores.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            if (_points > 0) {
                bw.write(_text + ":" + " " + _points);
                bw.newLine();
            }
            bw.close();
            //print statement to confirm that a new player was added to the text file
            System.out.println("new player added");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

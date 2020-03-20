package CatGame.Models;

/**
 * the WriteToText class is used to append text to the text file "GameScores"
 *
 * @author anthony cardenas barrera last updated: 3/9/20
 */

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteToTxt{
	//method creates a FileWriter, BufferedWriter, and PrintWriter

	public void writeTo(String _text) throws IOException {
		try {
			FileWriter fw = new FileWriter("C:\\Users\\antho\\Documents\\netbeans projects\\RuntimeTerrors\\src\\resources\\GameScores.txt", true);
			BufferedWriter bw = new BufferedWriter(fw);
			//String text = "new string for the file";
			bw.write(_text);
			bw.close();

			System.out.println("done");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

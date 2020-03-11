/*
this classes utilizes the methods in FileReader to read a text file
@author anthony cardenas barrera
last updated: 3/9/20
*/
import CatGame.Models.ReadFromTxt;
import CatGame.Models.WriteToTxt;
import java.io.FileNotFoundException;
import java.io.IOException;

class ScoreKeeper {
    //main method calls methods from ReadFromTxt and WriteToTxt
    public static void main(String[] args) throws FileNotFoundException, IOException {

        ReadFromTxt read = new ReadFromTxt();
        read.openFile();
        read.readFile();
        read.closeFile();

        WriteToTxt write = new WriteToTxt();
        write.writeTo();

    }
}

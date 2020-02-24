/*
this classes utilizes the methods in FileReader to read a text file
@author anthony cardenas barrera
last updated: 2/24/20
*/
import java.io.FileNotFoundException;

class ScoreKeeper {

    public static void main(String[] args) throws FileNotFoundException {

        FileReader r = new FileReader();
        r.openFile();
        r.readFile();
        r.closeFile();
    }
}

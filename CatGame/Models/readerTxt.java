package CatGame.Models;

import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class readerTxt extends ReadFromTxt{
    public static void main(String[] args) {
        ReadFromTxt r = new ReadFromTxt();
        try {
            r.openFile();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(readerTxt.class.getName()).log(Level.SEVERE, null, ex);
        }
        r.readFile();
        r.closeFile();
    }
}
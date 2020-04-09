package CatGame.Sprite;

import java.util.Random;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

/**
 * Hairball class that simply initializes the location and size of the stationary hairballs on scree.
 *
 * @author Erika Sudderth
 * Last updated: 3/29/20
 */
public class Hairball extends Sprite {

    private final String hairballImage = "/resources/imgs/hairball.png";
    private final AnchorPane pane;

    public Hairball(AnchorPane _pane) {
        this.pane = _pane;
        this.spriteImage = new ImageView(hairballImage);

        //this.pane.getChildren().add(this.getImage());
    }


    public void placeHairball() {
        Random randGen = new Random();
        int xPos = randGen.nextInt(800);
        int yPos = randGen.nextInt(600);
        Hairball hairBall = new Hairball(this.pane);
    }

    @Override
    public int getX() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getY() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
package CatGame.Sprite;

import CatGame.ViewManagers.ViewManager;
import java.util.Random;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

/**
 * Cheese class that extends the Sprite class. Each cheese object will be
 * randomly placed.
 *
 * @author Erika Sudderth, Greg Dwyer
 * Last updated: 4/29/20
 */

public class Cheese extends Sprite {

    private final String CHEESE_IMAGE = "/resources/imgs/cheese.png";
    private final static int UPPER_BOUND = 140;
    private final static int LOWER_BOUND = ViewManager.getHeight() - 50;
    private final static int LEFT_BOUND = 5;
    private final static int RIGHT_BOUND = ViewManager.getWidth() - 5;
    private final String ID = "cheese";

    public Cheese(AnchorPane _pane) {
        this.spriteImage = new ImageView(CHEESE_IMAGE);
        Node cheeseNode = this.spriteImage;
        cheeseNode.setId(this.ID);
        _pane.getChildren().add(cheeseNode);
        this.placeCheese(cheeseNode);
    }

    /**
     * Method that generates random x and y coordinates for this cheese object.
     */
    public static void placeCheese(Node _cheese) {
        Random randNum = new Random();
        // The upper bound is less than the lower bound due to flipped y coordinates.
        int yRand = randNum.nextInt((Cheese.LOWER_BOUND - Cheese.UPPER_BOUND) + 1) + Cheese.UPPER_BOUND;
        int xRand = randNum.nextInt((Cheese.RIGHT_BOUND - Cheese.LEFT_BOUND) + 1) + Cheese.LEFT_BOUND;
        _cheese.setLayoutY(yRand);
        _cheese.setLayoutX(xRand);
    }
}

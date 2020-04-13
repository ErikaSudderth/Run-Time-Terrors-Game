package CatGame.Sprite;

import CatGame.ViewManagers.ViewManager;
import java.util.Random;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

/**
 * Cheese class that extends the Sprite class. Each object will have a Boolean variable to determine if it has been collected by the mouse.
 *
 * @author Erika Sudderth Last updated: 4/9/20
 */

public class Cheese extends Sprite {

    private final String cheeseImage = "/resources/imgs/cheese.png";
    private final static int upperBound = 140;
    private final static int lowerBound = ViewManager.getHeight() - 50;
    private final static int leftBound = 5;
    private final static int rightBound = ViewManager.getWidth() - 5;
    private final String ID = "cheese";

    public Cheese(AnchorPane _pane) {
        this.spriteImage = new ImageView(cheeseImage);
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
        int yRand = randNum.nextInt((Cheese.lowerBound - Cheese.upperBound) + 1) + Cheese.upperBound;
        int xRand = randNum.nextInt((Cheese.rightBound - Cheese.leftBound) + 1) + Cheese.leftBound;
        _cheese.setLayoutY(yRand);
        _cheese.setLayoutX(xRand);
    }
}

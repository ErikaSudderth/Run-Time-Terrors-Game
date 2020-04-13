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
    private final int upperBound = 140;
    private final int lowerBound = ViewManager.getHeight() - 50;
    private final int leftBound = 5;
    private final int rightBound = ViewManager.getWidth() - 5;
    private final String ID = "cheese";

    public Cheese(AnchorPane _pane) {
        this.spriteImage = new ImageView(cheeseImage);
        Node cheeseNode = this.spriteImage;
        cheeseNode.setId(this.ID);
        _pane.getChildren().add(cheeseNode);
        this.placeCheese();
    }

    /**
     * Method that generates random x and y coordinates for this cheese object.
     */
    private void placeCheese() {
        Random randNum = new Random();
        // The upper bound is less than the lower bound due to flipped y coordinates.
        int yRand = randNum.nextInt((this.lowerBound - this.upperBound) + 1) + this.upperBound;
        int xRand = randNum.nextInt((this.rightBound - this.leftBound) + 1) + this.leftBound;
        this.spriteImage.setLayoutY(yRand);
        this.spriteImage.setLayoutX(xRand);
    }
}

package CatGame.Sprite;

/**
 * Hairball class that simply initializes the location and size of the stationary hairballs on scree.
 *
 * @author Erika Sudderth
 * Last updated: 4/9/20
 */

import java.util.Random;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import CatGame.ViewManagers.ViewManager;
import javafx.scene.Node;

public class Hairball extends Sprite {

    private final String hairballImage = "/resources/imgs/hairball.png";
    private final AnchorPane pane;
    private final int upperBound = 140;
    private final int lowerBound = ViewManager.getHeight() - 50;
    private final int leftBound = 5;
    private final int rightBound = ViewManager.getWidth() - 5;
    private final String ID = "hairball";

    public Hairball(AnchorPane _pane) {
        this.pane = _pane;
        this.spriteImage = new ImageView(hairballImage);
        Node hairballNode = this.spriteImage;
        hairballNode.setId(this.ID);
        this.pane.getChildren().add(hairballNode);
        this.placeHairball();
    }

    /**
     * Method that generates random x and y coordinates for this hairball object.
     */
    private void placeHairball() {
        Random randNum = new Random();
        // The upper bound is less than the lower bound due to flipped y coordinates.
        int yRand = randNum.nextInt((this.lowerBound - this.upperBound) + 1) + this.upperBound;
        int xRand = randNum.nextInt((this.rightBound - this.leftBound) + 1) + this.leftBound;
        this.spriteImage.setLayoutY(yRand);
        this.spriteImage.setLayoutX(xRand);
    }

}
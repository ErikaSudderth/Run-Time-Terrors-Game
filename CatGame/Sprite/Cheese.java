package CatGame.Sprite;

import CatGame.ViewManagers.ViewManager;
import java.util.Random;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

/**
 * Cheese class that extends the Sprite class. Each object will have a Boolean variable to determine if it has been collected by the mouse.
 *
 * @author Erika Sudderth Last updated: 4/9/20
 */

public class Cheese extends Sprite {

    protected Boolean isCollected;
    private final String cheeseImage = "/resources/imgs/cheese.png";
    private final AnchorPane pane;
    private final int upperBound = 140;
    private final int lowerBound = ViewManager.getHeight() - 50;
    private final int leftBound = 5;
    private final int rightBound = ViewManager.getWidth() - 5;

    public Cheese(AnchorPane _pane) {
        this.pane = _pane;
        this.spriteImage = new ImageView(cheeseImage);
        this.pane.getChildren().add(this.spriteImage);
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

//=================  GETTERS ===============
    public Boolean getIsCollected() {
        return this.isCollected;
    }

    @Override
    public int getX() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getY() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

//=================  SETTERS ===============
    public void setIsCollected(Boolean _isCollected) {
        this.isCollected = _isCollected;
    }
}

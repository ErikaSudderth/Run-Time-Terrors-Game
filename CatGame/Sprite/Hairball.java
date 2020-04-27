package CatGame.Sprite;

/**
 * Hairball class that simply initializes the location and size of the stationary hairballs on screen.
 *
 * @author Erika Sudderth, Gregory Dwyer
 * Last updated: 4/27/20
 */

import java.util.Random;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import CatGame.ViewManagers.ViewManager;
import javafx.scene.Node;

public class Hairball extends Sprite {

    private final String hairballImage = "/resources/imgs/hairball.png";
    private final AnchorPane pane;
    private final String ID = "hairball";
    private final int upperBound = 140;
    private final int lowerBound = ViewManager.getHeight() - 50;
    private final int leftBound = 5;
    private final int rightBound = ViewManager.getWidth() - 5;
    // The upper bound is less than the lower bound due to flipped y coordinates.
    private final int yRange = (this.lowerBound - this.upperBound) + 1;
    private final int xRange = (this.rightBound - this.leftBound) + 1;
    private int yRand;
    private int xRand;
    private final int maxHairballs;
    private static final int yDivisions = 2;
    private static final int xDivisions = 3;
    private static final int numSections = yDivisions * xDivisions;
    private static final int[] sectionArray = new int[numSections];


    public Hairball(AnchorPane _pane, int _maxHairballs) {
        this.pane = _pane;
        this.spriteImage = new ImageView(hairballImage);
        this.maxHairballs = _maxHairballs;
        Node hairballNode = this.spriteImage;
        hairballNode.setId(this.ID);

        this.pane.getChildren().add(hairballNode);
        this.pane.getChildren().get(this.pane.getChildren().indexOf(hairballNode)).toBack();
        this.placeHairball();
    }

    /**
     * Method that generates random x and y coordinates for this hairball object.
     */
    private void placeHairball() {
        Random randNum = new Random();
        // The upper bound is less than the lower bound due to flipped y coordinates.
        yRand = randNum.nextInt(yRange) + this.upperBound;
        xRand = randNum.nextInt(xRange) + this.leftBound;

        this.spriteImage.setLayoutY(yRand);
        this.spriteImage.setLayoutX(xRand);
        this.assignSection();
    }

    /**
     * Method that determines which section this hairball has been placed into.
     */
    private void assignSection() {
        int sectionUpper = this.upperBound;
        int sectionLeft = this.leftBound;

        //The sections are numbered horizontally then vertically.
        for(int yCounter = 0; yCounter < this.yDivisions; yCounter++)  {
            if(this.yRand > sectionUpper && this.yRand < ((yCounter + 1) * (this.yRange / this.yDivisions) + this.upperBound)) {
                for(int xCounter = 0; xCounter < this.xDivisions; xCounter++) {
                    if(this.xRand > sectionLeft && this.xRand < ((xCounter + 1) * (this.xRange / this.xDivisions) + this.leftBound)) {
                        Hairball.sectionArray[(yCounter * this.xDivisions) + xCounter] += 1;
                    }
                    sectionLeft = ((xCounter + 1) * (this.xRange / this.xDivisions) + this.leftBound);
                }
            }
            sectionUpper = ((yCounter + 1) * (this.yRange / this.yDivisions) + this.upperBound);
        }

        // This is placed here to allow location reassignment without deleting the Hairball object and creating a new one.
        if(!this.isGoodPlacement()) {
            this.placeHairball();
        }
    }

    /**
     * Method that returns whether a placement is within a section with too many other hairballs.
     */
    private Boolean isGoodPlacement() {
        //Add one because integer division drops the remainder.
        int hairballsPerSection = (this.maxHairballs / this.numSections) + 1;

        for(int counter = 0; counter < Hairball.sectionArray.length; counter++) {
            if(Hairball.sectionArray[counter] > hairballsPerSection) {
                Hairball.sectionArray[counter] -= 1;
                return false;
            }
        }
        return true;
    }
}
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

    private final String HAIRBALL_IMAGE = "/resources/imgs/hairball.png";
    private final AnchorPane PANE;
    private final String ID = "hairball";
    private final int UPPER_BOUND = 140;
    private final int LOWER_BOUND = ViewManager.getHeight() - 50;
    private final int LEFT_BOUND = 5;
    private final int RIGHT_BOUND = ViewManager.getWidth() - 5;
    // The upper bound is less than the lower bound due to flipped y coordinates.
    private final int Y_RANGE = (this.LOWER_BOUND - this.UPPER_BOUND) + 1;
    private final int X_RANGE = (this.RIGHT_BOUND - this.LEFT_BOUND) + 1;
    private int yRand;
    private int xRand;
    private final int MAX_HAIRBALLS;
    private static final int Y_DIVISIONS = 2;
    private static final int X_DIVISIONS = 3;
    private static final int NUM_SECTIONS = Y_DIVISIONS * X_DIVISIONS;
    private static final int[] SECTION_ARRAY = new int[NUM_SECTIONS];


    public Hairball(AnchorPane _pane, int _maxHairballs) {
        this.PANE = _pane;
        this.spriteImage = new ImageView(this.HAIRBALL_IMAGE);
        this.MAX_HAIRBALLS = _maxHairballs;
        Node hairballNode = this.spriteImage;
        hairballNode.setId(this.ID);

        this.PANE.getChildren().add(hairballNode);
        this.PANE.getChildren().get(this.PANE.getChildren().indexOf(hairballNode)).toBack();
        this.placeHairball();
    }

    /**
     * Method that generates random x and y coordinates for this hairball object.
     */
    private void placeHairball() {
        Random randNum = new Random();
        // The upper bound is less than the lower bound due to flipped y coordinates.
        this.yRand = randNum.nextInt(this.Y_RANGE) + this.UPPER_BOUND;
        this.xRand = randNum.nextInt(this.X_RANGE) + this.LEFT_BOUND;

        this.spriteImage.setLayoutY(this.yRand);
        this.spriteImage.setLayoutX(this.xRand);
        this.assignSection();
    }

    /**
     * Method that determines which section this hairball has been placed into.
     */
    private void assignSection() {
        int sectionUpper = this.UPPER_BOUND;
        int sectionLeft = this.LEFT_BOUND;

        //The sections are numbered horizontally then vertically.
        for(int yCounter = 0; yCounter < this.Y_DIVISIONS; yCounter++)  {
            if(this.yRand > sectionUpper && this.yRand < ((yCounter + 1) * (this.Y_RANGE / this.Y_DIVISIONS) + this.UPPER_BOUND)) {
                for(int xCounter = 0; xCounter < this.X_DIVISIONS; xCounter++) {
                    if(this.xRand > sectionLeft && this.xRand < ((xCounter + 1) * (this.X_RANGE / this.X_DIVISIONS) + this.LEFT_BOUND)) {
                        Hairball.SECTION_ARRAY[(yCounter * this.X_DIVISIONS) + xCounter] += 1;
                    }
                    sectionLeft = ((xCounter + 1) * (this.X_RANGE / this.X_DIVISIONS) + this.LEFT_BOUND);
                }
            }
            sectionUpper = ((yCounter + 1) * (this.Y_RANGE / this.Y_DIVISIONS) + this.UPPER_BOUND);
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
        int hairballsPerSection = (this.MAX_HAIRBALLS / this.NUM_SECTIONS) + 1;

        for(int counter = 0; counter < Hairball.SECTION_ARRAY.length; counter++) {
            if(Hairball.SECTION_ARRAY[counter] > hairballsPerSection) {
                Hairball.SECTION_ARRAY[counter] -= 1;
                return false;
            }
        }
        return true;
    }
}
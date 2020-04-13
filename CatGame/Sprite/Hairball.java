package CatGame.Sprite;

/**
 * Hairball class that simply initializes the location and size of the stationary hairballs on scree.
 *
 * @author Erika Sudderth
 * Last updated: 4/11/20
 */

import java.util.Random;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import CatGame.ViewManagers.ViewManager;

public class Hairball extends Sprite {

    private final String hairballImage = "/resources/imgs/hairball.png";
    private final AnchorPane pane;
    private final int upperBound = 140;
    private final int lowerBound = ViewManager.getHeight() - 50;
    private final int leftBound = 5;
    private final int rightBound = ViewManager.getWidth() - 5;
    // The upper bound is less than the lower bound due to flipped y coordinates.
    private final int yRange = (this.lowerBound - this.upperBound) + 1;
    private final int xRange = (this.rightBound - this.leftBound) + 1;
    private int yRand;
    private int xRand;
    private static int section1;
    private static int section2;
    private static int section3;
    private static int section4;
    private final int maxHairballs;

    public Hairball(AnchorPane _pane, int _maxHairballs) {
        this.pane = _pane;
        this.spriteImage = new ImageView(hairballImage);
        this.maxHairballs = _maxHairballs;
        this.pane.getChildren().add(this.spriteImage);
        this.placeHairball();
        if(!this.isGoodPlacement()) {
            this.placeHairball();
        }
    }

    /**
     * Method that generates random x and y coordinates for this hairball object.
     */
    public void placeHairball() {
        Random randNum = new Random();
        // The upper bound is less than the lower bound due to flipped y coordinates.
        yRand = randNum.nextInt(yRange) + this.upperBound;
        xRand = randNum.nextInt(xRange) + this.leftBound;

        this.spriteImage.setLayoutY(yRand);
        this.spriteImage.setLayoutX(xRand);
        this.assignSection();
    }

    /**
     * Method that determines which of the four quadrants this hairball has been placed into.
     * Section 1 is the upper left quadrant, section 2 is the upper right quadrant,
     * section 3 is the lower right quadrant, and section 4 is the lower left quadrant.
     */
    public void assignSection() {
        if((this.yRand > this.upperBound) && (this.yRand < this.yRange / 2 + this.upperBound)) {
            if((this.xRand > this.leftBound) && (this.xRand < this.xRange / 2 + this.leftBound)) {
                Hairball.section1++;
            }
            else {
                Hairball.section2++;
            }
        }
        else {
            if((this.xRand < this.rightBound) && (this.xRand > this.xRange / 2 + this.leftBound)) {
                Hairball.section3++;
            }
            else {
                Hairball.section4++;
            }
        }
    }

    /**
     * Method that returns whether a placement is within a quadrant with too many other hairballs.
     */
    public Boolean isGoodPlacement() {
        //The number of quadrants is always going to be 4. Add one because integer division drops the remainder.
        int hairballsPerSection = this.maxHairballs / 4 + 1;

        if(Hairball.section1 > hairballsPerSection) {
            section1--;
            return false;
        }
        if(Hairball.section2 > hairballsPerSection) {
            section2--;
            return false;
        }
        if(Hairball.section3 > hairballsPerSection) {
            section3--;
            return false;
        }
        if(Hairball.section4 > hairballsPerSection) {
            section4--;
            return false;
        }
        return true;
    }

    @Override
    public int getX() {
        return xRand;
    }

    @Override
    public int getY() {
       return yRand;
    }
}
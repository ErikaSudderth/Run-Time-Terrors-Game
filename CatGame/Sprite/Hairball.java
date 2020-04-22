package CatGame.Sprite;

/**
 * Hairball class that simply initializes the location and size of the stationary hairballs on scree.
 *
 * @author Erika Sudderth, Gregory Dwyer
 * Last updated: 4/15/20
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
    // The upper bound is less than the lower bound due to flipped y coordinates.
    private final int yRange = (this.lowerBound - this.upperBound) + 1;
    private final int xRange = (this.rightBound - this.leftBound) + 1;
    private int yRand;
    private int xRand;
    private static int section1;
    private static int section2;
    private static int section3;
    private static int section4;
    private static int section5;
    private static int section6;
    private final int maxHairballs;

    private final String ID = "hairball";

    public Hairball(AnchorPane _pane, int _maxHairballs) {
        this.pane = _pane;
        this.spriteImage = new ImageView(hairballImage);
        this.maxHairballs = _maxHairballs;
        Node hairballNode = this.spriteImage;
        hairballNode.setId(this.ID);
        this.pane.getChildren().add(hairballNode);
        this.pane.getChildren().get(this.pane.getChildren().indexOf(hairballNode)).toBack();
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
     * Method that determines which of the six sections this hairball has been placed into.
     */
    public void assignSection() {
        if((this.yRand > this.upperBound) && (this.yRand < this.yRange / 3 + this.upperBound)) {
            if((this.xRand > this.leftBound) && (this.xRand < this.xRange / 3 + this.leftBound)) {
                Hairball.section1++;
            }
            else if((this.xRand >= this.xRange / 3 + this.leftBound) && this.xRand < ((2 * this.xRange / 3) + this.leftBound)) {
                Hairball.section2++;
            }
            else {
                Hairball.section3++;
            }
        }
        else {
            if((this.xRand < this.rightBound) && (this.xRand > this.xRange / 2 + this.leftBound)) {
                Hairball.section4++;
            }
            else if((this.xRand >= this.xRange / 3 + this.leftBound) && this.xRand < ((2 * this.xRange / 3) + this.leftBound)) {
                Hairball.section5++;
            }
            else {
                Hairball.section6++;
            }
        }
    }

    /**
     * Method that returns whether a placement is within a section with too many other hairballs.
     */
    public Boolean isGoodPlacement() {
        //The number of sections is always going to be 6. Add one because integer division drops the remainder.
        int hairballsPerSection = this.maxHairballs / 6 + 1;

        if(Hairball.section1 > hairballsPerSection) {
            Hairball.section1--;
            return false;
        }
        if(Hairball.section2 > hairballsPerSection) {
            Hairball.section2--;
            return false;
        }
        if(Hairball.section3 > hairballsPerSection) {
            Hairball.section3--;
            return false;
        }
        if(Hairball.section4 > hairballsPerSection) {
            Hairball.section4--;
            return false;
        }
        if(Hairball.section5 > hairballsPerSection) {
            Hairball.section5--;
            return false;
        }
        if(Hairball.section6 > hairballsPerSection) {
            Hairball.section6--;
            return false;
        }
        return true;
    }

//=================  GETTERS ===============
    public int getX() {
        return xRand;
    }

    public int getY() {
       return yRand;
    }
}
package CatGame.Sprite;

import javafx.geometry.Rectangle2D;

/**
 * Hairball class that simply initializes the location and size of the stationary hairballs on scree.
 *
 * @author Erika Sudderth Last updated: 3/24/20
 */
public class Hairball extends Sprite {

    public Hairball() {
    }
     public Rectangle2D getBounds(){
        return new Rectangle2D(getAnimationGroup().getTranslateX(), getAnimationGroup().getTranslateY(),this.DIMENSIONS,this.DIMENSIONS);
    }
}

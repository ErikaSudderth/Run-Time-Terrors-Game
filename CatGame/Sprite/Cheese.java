package CatGame.Sprite;

import javafx.geometry.Rectangle2D;

/**
 * Cheese class that extends the Sprite class. Each object will have a Boolean variable to determine if it has been collected by the mouse.
 *
 * @author Erika Sudderth Last updated: 3/24/20
 */
public class Cheese extends Sprite {

    protected Boolean isCollected;

    public Cheese() {
    }

//=================  GETTERS ===============
    public Boolean getIsCollected() {
        return this.isCollected;
    }
     public Rectangle2D getBounds(){
        return new Rectangle2D(getAnimationGroup().getTranslateX(), getAnimationGroup().getTranslateY(),this.DIMENSIONS,this.DIMENSIONS);
    }

//=================  SETTERS ===============
    public void setIsCollected(Boolean _isCollected) {
        this.isCollected = _isCollected;
    }
}

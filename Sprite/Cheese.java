package Sprite;

/**
 * Cheese class that extends the Sprite class. Each object will have a Boolean
 * variable to determine if it has been collected by the mouse.
 *
 * @author Erika Sudderth
 * Last updated: 3/19/20
 */

public class Cheese extends Sprite {

    protected Boolean isCollected;

    /**
     * Constructor to use the abstract Sprite class methods with sprite location
     * and size.
     *
     * @param _initialSpriteXValue
     * @param _initialSpriteYValue
     * @param _initialSpriteWidth
     * @param _initialSpriteHeight
     * @param _spriteImage
     */
    public Cheese(int _initialSpriteXValue, int _initialSpriteYValue, int _initialSpriteWidth, int _initialSpriteHeight, String _spriteImage) {
        super(_initialSpriteXValue, _initialSpriteYValue, _initialSpriteWidth, _initialSpriteHeight, _spriteImage);
    }

//=================  GETTERS ===============
    public Boolean getIsCollected() {
        return this.isCollected;
    }

//=================  SETTERS ===============
    public void setIsCollected(Boolean _isCollected) {
        this.isCollected = _isCollected;
    }
}

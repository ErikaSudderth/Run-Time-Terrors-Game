package Sprite;

import javafx.scene.image.ImageView;

/**
 * Projectile class that extends Sprite. Each object will have a Boolean value
 * to determine if it has been thrown or not.
 *
 * @author Erika
 * Last updated: 3/9/20
 */

public class Projectiles extends Sprite {

    protected Boolean hasBeenThrown = false;

    /**
     * Constructor to implement the abstract Sprite class methods with sprite location
     * and size.
     *
     * @param _initialSpriteXValue
     * @param _initialSpriteYValue
     * @param _initialSpriteWidth
     * @param _initialSpriteHeight
     * @param _spriteImage
     */
    public Projectiles(int _initialSpriteXValue, int _initialSpriteYValue, int _initialSpriteWidth, int _initialSpriteHeight, ImageView _spriteImage) {

        super (_initialSpriteXValue, _initialSpriteYValue, _initialSpriteWidth, _initialSpriteHeight, _spriteImage);
    }

//=================  GETTERS ===============
    public Boolean getHasBeenThrown() {
        return this.hasBeenThrown;
    }

//=================  SETTERS ===============
    public void setHasBeenThrown(Boolean _isThrown) {
        this.hasBeenThrown = _isThrown;
    }
}
package Sprite;

/**
 * Hairball class that simply initializes the location and size of the
 * stationary hairballs on scree.
 *
 * @author Erika Sudderth
 * Last updated: 3/19/20
 */
public class Hairball extends Sprite {

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
    public Hairball(int _initialSpriteXValue, int _initialSpriteYValue, int _initialSpriteWidth, int _initialSpriteHeight, String _spriteImage) {
        super(_initialSpriteXValue, _initialSpriteYValue, _initialSpriteWidth, _initialSpriteHeight, _spriteImage);
    }
}
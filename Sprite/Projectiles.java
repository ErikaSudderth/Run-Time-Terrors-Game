/*
 * 
 * 
 * 
 */
package Sprite;

import java.util.ArrayList;
import javafx.scene.image.ImageView;

/**
 *
 * @author Erika
 */
public class Projectiles extends Sprite {

    ArrayList<ImageView> throwableObjList = new ArrayList<ImageView>();

    /**
     * Constructor to implement the abstract Sprite class with sprite location
     * and size. Creates a list of throwable objects.
     *
     * @param _initialSpriteXValue
     * @param _initialSpriteYValue
     * @param _initialSpriteWidth
     * @param _initialSpriteHeight
     * @param _spriteImage
     * @param _ThrowableList
     */
    public Projectiles(int _initialSpriteXValue, int _initialSpriteYValue, int _initialSpriteWidth,
            int _initialSpriteHeight, String _spriteImage, ArrayList<ImageView> _ThrowableList) {

        super (_initialSpriteXValue, _initialSpriteYValue, _initialSpriteWidth,
                _initialSpriteHeight, _spriteImage);
    }

//=================  GETTERS ===============
    public ArrayList<ImageView> getThrowObjList() {
        return this.throwableObjList;
    }

//=================  SETTERS ===============
    public void setThrowObjList(ArrayList<ImageView> _throwObjList) {
        this.throwableObjList = _throwObjList;
    }
}
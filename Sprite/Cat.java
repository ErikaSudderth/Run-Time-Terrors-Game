package Sprite;

/**
 *
 * @author Erika
 */

import java.util.ArrayList;

public class Cat extends Sprite {

    ArrayList<Projectiles> projectilesList = new ArrayList<Projectiles>();

    /**
     * Constructor to implement the abstract Sprite class with sprite location
     * and size. Creates a list of throwable objects.
     *
     * @param _initialSpriteXValue
     * @param _initialSpriteYValue
     * @param _initialSpriteWidth
     * @param _initialSpriteHeight
     * @param _spriteImage
     * @param _projectileList
     */
    public Cat(int _initialSpriteXValue, int _initialSpriteYValue, int _initialSpriteWidth,
            int _initialSpriteHeight, String _spriteImage, ArrayList<Projectiles> _projectileList) {

        super (_initialSpriteXValue, _initialSpriteYValue, _initialSpriteWidth,
                _initialSpriteHeight, _spriteImage);

        this.projectilesList = _projectileList;
    }

//=================  GETTERS ===============
    public ArrayList<Projectiles> getProjectileObjList() {
        return this.projectilesList;
    }

//=================  SETTERS ===============
    public void setProjectileList(ArrayList<Projectiles> _projectilesList) {
        this.projectilesList = _projectilesList;
    }
}

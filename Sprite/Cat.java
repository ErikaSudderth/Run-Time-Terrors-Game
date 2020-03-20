package Sprite;

/**
 * Cat class extends abstract Sprite class. Initializes the cat character's
 * list of projectiles (claws).
 *
 * @author Erika Sudderth
 * Last updated: 3/19/20
 */

import java.util.ArrayList;

public class Cat extends Sprite {

    protected ArrayList<Projectiles> projectilesList = new ArrayList<>();

    /**
     * Constructor to use the abstract Sprite class methods with sprite location
     * and size. Creates a list of projectiles.
     *
     * @param _initialSpriteXValue
     * @param _initialSpriteYValue
     * @param _initialSpriteWidth
     * @param _initialSpriteHeight
     * @param _spriteImage
     * @param _projectileList
     */
    public Cat(int _initialSpriteXValue, int _initialSpriteYValue, int _initialSpriteWidth, int _initialSpriteHeight, String _spriteImage, ArrayList<Projectiles> _projectileList) {
        super(_initialSpriteXValue, _initialSpriteYValue, _initialSpriteWidth, _initialSpriteHeight, _spriteImage);
        this.projectilesList = _projectileList;
    }

//=================  GETTERS ===============
    public ArrayList<Projectiles> getProjectileObjList() {
        return this.projectilesList;
    }

//=================  SETTERS ===============
    public void setProjectileObjList(ArrayList<Projectiles> _projectilesList) {
        this.projectilesList = _projectilesList;
    }
}

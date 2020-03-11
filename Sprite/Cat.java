package Sprite;

/**
 * Cat class extends abstract Sprite class. Initializes the cat character's
 * list of projectiles.
 *
 * @author Erika
 * Last updated: 3/9/20
 */

import java.util.ArrayList;
import javafx.scene.image.ImageView;

public class Cat extends Sprite {

    protected ArrayList<Projectiles> projectilesList = new ArrayList<Projectiles>();

    /**
     * Constructor to implement the abstract Sprite class methods with sprite location
     * and size. Creates a list of projectiles.
     *
     * @param _initialSpriteXValue
     * @param _initialSpriteYValue
     * @param _initialSpriteWidth
     * @param _initialSpriteHeight
     * @param _spriteImage
     * @param _projectileList
     */
    public Cat(int _initialSpriteXValue, int _initialSpriteYValue, int _initialSpriteWidth, int _initialSpriteHeight, ImageView _spriteImage, ArrayList<Projectiles> _projectileList) {

        super (_initialSpriteXValue, _initialSpriteYValue, _initialSpriteWidth, _initialSpriteHeight, _spriteImage);
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

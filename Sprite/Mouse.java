package Sprite;

/**
 * Mouse class that extends abstract Sprite class. Initializes the mouse's list
 * of cheese objects it holds.
 *
 * @author Erika Sudderth
 * Last updated: 3/19/20
 */

import java.util.ArrayList;

public class Mouse extends Sprite {

    protected ArrayList<Cheese> cheeseList;

    public Mouse(int _initialSpriteXValue, int _initialSpriteYValue, int _initialSpriteWidth, int _initialSpriteHeight, String _spriteImage, ArrayList<Cheese> _cheeseList) {
        super(_initialSpriteXValue, _initialSpriteYValue, _initialSpriteWidth, _initialSpriteHeight, _spriteImage);
        this.cheeseList = _cheeseList;
    }

//=================  GETTERS ===============
    public ArrayList<Cheese> getCheeseObjList() {
        return this.cheeseList;
    }

//=================  SETTERS ===============
    public void setProjectileObjList(ArrayList<Cheese> _cheeseObjList) {
        this.cheeseList = _cheeseObjList;
    }
}

package CatGame.Models;

/**
* This class defines the necessary attributes and methods for anything that will be used as an input device.
* Author(s): Gregory Dwyer
* Last Updated: 3/26/20
*/

import CatGame.Controller.GameController;

public abstract class Input {

    private GameController controller;
    private boolean up;
    private boolean down;
    private boolean left;
    private boolean right;
    private boolean space;
    private boolean esc;

//=================  GETTERS ===============
    public boolean isUp() {
        return this.up;
    }

    public boolean isDown() {
        return this.down;
    }

    public boolean isLeft() {
        return this.left;
    }

    public boolean isRight() {
        return this.right;
    }

    public boolean isSpace() {
        return this.space;
    }

    public boolean isEsc() {
        return this.esc;
    }
}

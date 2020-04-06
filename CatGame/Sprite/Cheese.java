package CatGame.Sprite;

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

//=================  SETTERS ===============
    public void setIsCollected(Boolean _isCollected) {
        this.isCollected = _isCollected;
    }

    @Override
    public int getX() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getY() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

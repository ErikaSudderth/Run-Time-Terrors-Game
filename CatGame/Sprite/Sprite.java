package CatGame.Sprite;

/**
 * Abstract sprite class. Every movable object will have a location and a size and will inherit this class.
 *
 * @author Erika Sudderth, Greg
 * Last updated: 3/24/20
 */
import javafx.scene.image.ImageView;

public abstract class Sprite {

    protected ImageView spriteImage;
    protected SpriteAnimation animation;
    protected int x_pos;
    protected int y_pos;

//=================  GETTERS ===============
    public ImageView getImage() {
	return this.spriteImage;
    }
    public int getXPos(){
        return this.x_pos;
    }
     public int getYPos(){
        return this.y_pos;
    }

//=================  SETTERS ===============
    public void setImage(String _imagePNG) {
	this.spriteImage = new ImageView(_imagePNG);
    }
}

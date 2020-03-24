package CatGame.Sprite;

import javafx.scene.image.ImageView;

/**
 * Projectile class (for claws) that extends the Sprite class. Each object will have a Boolean value to determine if it has been thrown or not.
 *
 * @author Erika Sudderth
 * Last updated: 3/24/20
 */
public class Projectiles extends Sprite {

    protected Boolean isThrown;
    protected String clawImage = "/resources/imgs/claw.png";

    public Projectiles() {
        spriteImage = new ImageView(clawImage);
    }

//=================  GETTERS ===============
    public Boolean getIsThrown() {
	return this.isThrown;
    }

//=================  SETTERS ===============
    public void setIsThrown(Boolean _isThrown) {
	this.isThrown = _isThrown;
    }
}

package CatGame.Sprite;

/**
 * Projectile class (for claws) that extends the Sprite class. Each object will have a Boolean value to determine if it has been thrown or not.
 *
 * @author Erika Sudderth Last updated: 3/19/20
 */
public class Projectiles extends Sprite {

	protected Boolean isThrown;
        
	public Projectiles() {
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

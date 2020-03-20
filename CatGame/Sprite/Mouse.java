package CatGame.Sprite;

/**
 * Mouse class that extends abstract Sprite class. Initializes the mouse's list of cheese objects it holds.
 *
 * @author Erika Sudderth, Greg Dwyer Last updated: 3/20/20
 */
import CatGame.ViewManagers.ViewManager;
import java.util.ArrayList;
import javafx.animation.Animation;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

public class Mouse extends Sprite {

	protected ArrayList<Cheese> cheeseList;
	private final String IMAGE = "/resources/imgs/mouse_sprite_map.png";
	private final int DIMENSIONS = 32;
	private final int SPRITE_COLUMNS = 4;
	private final int FRAME_COUNT = 4;
	private final Duration FRAME_DURATION = Duration.millis(500);
	private final int OFFSET = 0;
	private final double STARTING_X = (ViewManager.getWidth() / 2) - (this.DIMENSIONS / 2);
	private final double STARTING_Y = ViewManager.getHeight() - (this.DIMENSIONS * 3);

	public Mouse(AnchorPane _pane) {
		this.setAnimationFields();
		this.x_pos = (int) this.STARTING_X;
		this.y_pos = (int) this.STARTING_Y;

		this.initialPos();
		_pane.getChildren().add(new Group(this.spriteImage));
	}

	/**
	 * This method can be used to set an explicit location for the sprite.
	 */
	private void initialPos() {
		this.spriteImage.setLayoutX(this.x_pos);
		this.spriteImage.setLayoutY(this.y_pos);
	}

	/**
	 * This method sets up the animation for the sprite.
	 */
	private void setAnimationFields() {
		this.spriteImage = new ImageView(this.IMAGE);
		this.animation = new SpriteAnimation(this.spriteImage, this.FRAME_DURATION, this.FRAME_COUNT, this.SPRITE_COLUMNS, this.OFFSET, this.OFFSET, this.DIMENSIONS, this.DIMENSIONS);
		this.spriteImage.setViewport(new Rectangle2D(this.OFFSET, this.OFFSET, this.DIMENSIONS, this.DIMENSIONS));
		this.animation.setCycleCount(Animation.INDEFINITE);
		this.animation.play();
	}

	/**
	 * Use to update the mouse's location in the X axis.
	 *
	 * @param _distance This is the mouse's movement speed.
	 */
	public void moveX(int _distance) {
		this.spriteImage.setLayoutX(this.x_pos + _distance);
	}

	/**
	 * Use to update the mouse's location in the X axis.
	 *
	 * @param _distance This is the mouse's movement speed.
	 */
	public void moveY(int _distance) {
		this.spriteImage.setLayoutY(this.y_pos + _distance);
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

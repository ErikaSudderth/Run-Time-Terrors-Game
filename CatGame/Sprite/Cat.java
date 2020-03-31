package CatGame.Sprite;

/**
 * Cat class extends abstract Sprite class. Initializes the cat character's list of projectiles (claws).
 *
 * @author Erika Sudderth, Greg Dwyer Last updated: 3/24/20
 */
import CatGame.ViewManagers.ViewManager;
import java.util.ArrayList;
import javafx.animation.Animation;
import static javafx.animation.Animation.INDEFINITE;
import javafx.animation.Interpolator;
import javafx.animation.PathTransition;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Line;
import javafx.util.Duration;

public class Cat extends Sprite {

    protected ArrayList<Projectiles> projectilesList = new ArrayList<>();
    private final String IMAGE = "/resources/imgs/cat_sprite_map.png";
    private final int DIMENSIONS = 128;
    private final int SPRITE_COLUMNS = 2;
    private final int FRAME_COUNT = 2;
    private final Duration FRAME_DURATION = Duration.millis(700);
    private final int OFFSET = 0;
    private final double STARTING_X = (ViewManager.getWidth() / 2) - (this.DIMENSIONS / 2);
    private final double STARTING_Y = 20;
    private final int CAT_SPEED = 2;
    private Group animationGroup;

    /**
     * This constructor sets the image and starting position, then begins the animation.
     */
    public Cat(AnchorPane _pane) {
        this.setAnimationFields();
        this.x_pos = (int) this.STARTING_X;
        this.y_pos = (int) this.STARTING_Y;
        this.initialPos();
        animationGroup = new Group(this.spriteImage);
        _pane.getChildren().add(animationGroup);
        this.moveCat();
    }

    /**
     * This method can be used to set an explicit location for the sprite.
     */
    private void initialPos() {
        this.spriteImage.setLayoutX(this.x_pos);
        this.spriteImage.setLayoutY(this.y_pos);
    }

    private void setAnimationFields() {
        this.spriteImage = new ImageView(this.IMAGE);
        this.animation = new SpriteAnimation(this.spriteImage, this.FRAME_DURATION, this.FRAME_COUNT, this.SPRITE_COLUMNS, this.OFFSET, this.OFFSET, this.DIMENSIONS, this.DIMENSIONS);
        this.spriteImage.setViewport(new Rectangle2D(this.OFFSET, this.OFFSET, this.DIMENSIONS, this.DIMENSIONS));
        this.animation.setCycleCount(Animation.INDEFINITE);
        this.animation.play();
    }

        /**
     * Method that creates a path transition on which the cat moves along on the screen.
     */
    private void moveCat() {
        PathTransition pathTransition = new PathTransition();
        pathTransition.setDuration(Duration.seconds(this.CAT_SPEED));
        pathTransition.setNode(this.animationGroup);
        pathTransition.setPath(new Line(0 + this.getCenter() , this.STARTING_Y + this.getCenter(), ViewManager.getWidth() - this.getCenter(), this.STARTING_Y + this.getCenter()));
        pathTransition.setCycleCount(INDEFINITE);
        pathTransition.setAutoReverse(true);
        pathTransition.setInterpolator(Interpolator.LINEAR);
        pathTransition.play();
    }

    /**
     * Use to update the cat's location in the X axis.
     *
     * @param _distance This is the cat's movement speed.
     */
    public void moveX(int _distance) {
        this.spriteImage.setLayoutX(this.spriteImage.getLayoutX() + _distance);
    }

//=================  GETTERS ===============
    public ArrayList<Projectiles> getProjectileObjList() {
        return this.projectilesList;
    }

    public Group getAnimation() {
        return new Group(this.spriteImage);
    }

    public Group getAnimationGroup() {
        return animationGroup;
    }

    public int getDimensions() {
        return this.DIMENSIONS;
    }

    public int getCenter() {
        return this.DIMENSIONS / 2;
    }

//=================  SETTERS ===============
    public void setProjectileObjList(ArrayList<Projectiles> _projectilesList) {
        this.projectilesList = _projectilesList;
    }
}

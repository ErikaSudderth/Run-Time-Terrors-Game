package CatGame.Sprite;

/**
 * Mouse class that extends abstract Sprite class. Initializes the mouse's list of cheese objects it holds.
 * @author Erika Sudderth, Greg Dwyer, Hasler Zuniga
 * Last updated: 4/15/20
 */

import CatGame.Models.Input;
import CatGame.ViewManagers.ViewManager;
import java.util.ArrayList;
import javafx.animation.Animation;
import javafx.geometry.Bounds;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Node;
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
    private final double STARTING_Y = ViewManager.getHeight() - (this.DIMENSIONS);
    private final int MOUSE_SPEED = 5;
    private final Group ANIMATION_GROUP;
    private final ArrayList<Node> COLLISION_LIST = new ArrayList();
    private boolean collided = false;
    private final String ID = "mouse";
    private boolean hasCheese = false;
    private Node collectedCheese;

    public Mouse(AnchorPane _pane) {
        this.setAnimationFields();
        this.initialPos();
        this.ANIMATION_GROUP = new Group(this.spriteImage);
        Node mouseNode = this.ANIMATION_GROUP;
        mouseNode.setId(this.ID);
        _pane.getChildren().add(mouseNode);
    }

    /**
     * Use these methods to update the mouse's location on the X axis.
     *
     * @param _distance This is the mouse's movement speed.
     */
    public void moveXLeft() {
        if (this.ANIMATION_GROUP.getLayoutX() >= -(ViewManager.getWidth() / 2)) {
            this.ANIMATION_GROUP.setLayoutX(this.ANIMATION_GROUP.getLayoutX() - this.MOUSE_SPEED);
        }
    }

    public void moveXRight() {
        if (this.ANIMATION_GROUP.getLayoutX() <= (ViewManager.getWidth() / 2)) {
            this.ANIMATION_GROUP.setLayoutX(this.ANIMATION_GROUP.getLayoutX() + this.MOUSE_SPEED);
        }
    }

    /**
     * Use these methods to update the mouse's location on the X axis.
     *
     * @param _distance This is the mouse's movement speed.
     */
    public void moveYUp() {
        if (this.ANIMATION_GROUP.getLayoutY() >= -ViewManager.getHeight() + (3 * this.DIMENSIONS)) {
            this.ANIMATION_GROUP.setLayoutY(this.ANIMATION_GROUP.getLayoutY() - this.MOUSE_SPEED);
        }
    }

    public void moveYDown() {
        if (this.ANIMATION_GROUP.getLayoutY() <= 0) {
            this.ANIMATION_GROUP.setLayoutY(this.ANIMATION_GROUP.getLayoutY() + this.MOUSE_SPEED);
        }
    }

    /**
     * Method that calls the moveY and moveX methods in response to the key event. Continues movement as long as the key is pressed.
     */
    public void moveMouse(Input _input) {
        if (_input.isUp()) {
            this.moveYUp();
        }
        if (_input.isDown()) {
            this.moveYDown();
        }
        if (_input.isLeft()) {
            this.moveXLeft();
        }
        if (_input.isRight()) {
            this.moveXRight();
        }
        if(this.hasCheese) {
            Bounds mouseBounds = this.ANIMATION_GROUP.getBoundsInParent();
            this.collectedCheese.setLayoutX(mouseBounds.getMinX());
            this.collectedCheese.setLayoutY(mouseBounds.getMinY() - (this.DIMENSIONS / 4));
        }
    }

    /**
     * This method adds a collision to the mouse's collision list.
     * @param _node This is the collided node.
     */
    public void addCollision(Node _node) {
        this.COLLISION_LIST.add(_node);

    }

    /**
     * This method removes a previously collided node, if it is no longer colliding.
     * @param _node This is the node to be removed.
     */
    public void removeCollision(Node _node) {
        this.COLLISION_LIST.remove(_node);
    }

    /**
     * This method can be used to set an explicit location for the sprite.
     */
    private void initialPos() {
        this.spriteImage.setLayoutX(this.STARTING_X);
        this.spriteImage.setLayoutY(this.STARTING_Y);
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

//=================  GETTERS ===============

    public ArrayList<Cheese> getCheeseObjList() {
        return this.cheeseList;
    }

    public int getXPos() {
        return (int) (this.ANIMATION_GROUP.getLayoutX() + this.STARTING_X) + this.getCenter();
    }

    public int getYPos() {
        return (int) (this.ANIMATION_GROUP.getLayoutY() + this.STARTING_Y) + this.getCenter();
    }

    public int getCenter() {
        return this.DIMENSIONS / 2;
    }

    public boolean hasCheese(){
        return this.hasCheese;
    }

    public Node getCollectedCheese() {
        return this.collectedCheese;
    }

    public Group getAnimationGroup() {
        return this.ANIMATION_GROUP;
    }

    public boolean isCollided() {
        return this.collided;
    }

    public ArrayList getCollisionList() {
        return this.COLLISION_LIST;
    }

//=================  SETTERS ===============

    public void setProjectileObjList(ArrayList<Cheese> _cheeseObjList) {
        this.cheeseList = _cheeseObjList;
    }

    public void setCollectedCheese(Node _cheese) {
        this.collectedCheese = _cheese;
    }

    public void setHasCheese(boolean _hasCheese) {
        this.hasCheese = _hasCheese;
    }

    public void setCollided(boolean _collided) {
        this.collided = _collided;
    }
}

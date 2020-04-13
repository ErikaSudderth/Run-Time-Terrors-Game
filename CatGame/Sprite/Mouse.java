package CatGame.Sprite;

/**
 * Mouse class that extends abstract Sprite class. Initializes the mouse's list of cheese objects it holds.
 *
 * @author Erika Sudderth, Greg Dwyer Last updated: 4/9/20
 */
import CatGame.Models.Input;
import CatGame.SFX;
import CatGame.ViewManagers.ViewManager;
import static java.lang.Math.sqrt;
import java.util.ArrayList;
import java.util.List;
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
    private final Group animationGroup;

    private ArrayList<Node> collisionList = new ArrayList();
    private boolean collided = false;
    private final String ID = "mouse";
    private boolean hasCheese = false;
    private Node collectedCheese;

    public Mouse(AnchorPane _pane) {
        this.setAnimationFields();
        this.initialPos();
        this.animationGroup = new Group(this.spriteImage);
        Node mouseNode = this.animationGroup;
        mouseNode.setId(this.ID);
        _pane.getChildren().add(mouseNode);
    }

    /**
     * Use these to update the mouse's location in the X axis.
     *
     * @param _distance This is the mouse's movement speed.
     */
    public void moveXLeft() {
        if (this.animationGroup.getLayoutX() >= -(ViewManager.getWidth() / 2)) {
            this.animationGroup.setLayoutX(this.animationGroup.getLayoutX() - this.MOUSE_SPEED);
        }
    }

    public void moveXRight() {
        if (this.animationGroup.getLayoutX() <= (ViewManager.getWidth() / 2)) {
            this.animationGroup.setLayoutX(this.animationGroup.getLayoutX() + this.MOUSE_SPEED);
        }
    }

    /**
     * Use these to update the mouse's location in the X axis.
     *
     * @param _distance This is the mouse's movement speed.
     */
    public void moveYUp() {
        if (this.animationGroup.getLayoutY() >= -ViewManager.getHeight() + (3 * this.DIMENSIONS)) {
            this.animationGroup.setLayoutY(this.animationGroup.getLayoutY() - this.MOUSE_SPEED);
        }
    }

    public void moveYDown() {
        if (this.animationGroup.getLayoutY() <= 0) {
            this.animationGroup.setLayoutY(this.animationGroup.getLayoutY() + this.MOUSE_SPEED);
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
            Bounds mouseBounds = this.animationGroup.getBoundsInParent();
            this.collectedCheese.setLayoutX(mouseBounds.getMinX());
            this.collectedCheese.setLayoutY(mouseBounds.getMinY() - (this.DIMENSIONS / 4));
        }
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

    private void checkEnemyCollision(Node _node) {
        if (this.checkCollision(_node)) {
            if (!this.collided) {
                SFX.playCollision();
                System.out.println("Collided with " + _node.getId());
                this.collisionList.add(_node);
                this.collided = true;
                //Decrement Health.
            }
        } else {
            if (this.collisionList.contains(_node)) {
                this.collisionList.remove(_node);
            }
            if (this.collisionList.isEmpty()) {
                this.collided = false;
            }
        }
    }

    private boolean checkCollision(Node _node) {
        Bounds nodeBounds = _node.getBoundsInParent();
        Bounds mouseBounds = this.animationGroup.getBoundsInParent();
        return mouseBounds.intersects(nodeBounds);
    }

    private void checkCheeseCollision(Node _cheese) {
        if (this.checkCollision(_cheese) && !this.hasCheese) {
            SFX.playCollect();
            this.collectedCheese = _cheese;
            this.hasCheese = true;
        }
    }

    private boolean checkDoorCollision(Node _door) {
        if (this.checkCollision(_door)) {
            //Increase score.
            this.hasCheese = false;
            SFX.playPoint();
            return true;
        }
        return false;
    }

    public void checkCollisionsList(List<Node> _nodes) {
        for (Node n : _nodes) {
            switch (n.getId()) {
                case "cat":
                //Fall through.
                case "hairball":
                //Fall through.
                case "claw":
                    //Fall through.
                    this.checkEnemyCollision(n);
                    break;
                case "cheese":
                    if (!this.hasCheese) {
                        this.checkCheeseCollision(n);
                    }
                    break;
                case "door":
                    if (this.hasCheese) {
                        if(this.checkDoorCollision(n)) {
                            _nodes.remove(this.collectedCheese);
                        }
                    }
                    break;
            }
        }
    }
//=================  GETTERS ===============

    public ArrayList<Cheese> getCheeseObjList() {
        return this.cheeseList;
    }

    public int getXPos() {
        return (int) (this.animationGroup.getLayoutX() + this.STARTING_X) + this.getCenter();
    }

    public int getYPos() {
        return (int) (this.animationGroup.getLayoutY() + this.STARTING_Y) + this.getCenter();
    }

    public int getCenter() {
        return this.DIMENSIONS / 2;
    }

//=================  SETTERS ===============

    public void setProjectileObjList(ArrayList<Cheese> _cheeseObjList) {
        this.cheeseList = _cheeseObjList;
    }
}

package CatGame.ViewManagers;

/**
 * This is the Menu View Manager
 * Author(s) - Greg, Erika Sudderth
 * Last updated - 3/24/20
 */

import CatGame.Sprite.*;
import static javafx.animation.Animation.INDEFINITE;
import javafx.animation.AnimationTimer;
import javafx.animation.PathTransition;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.util.Duration;

public class GameView extends ViewManager {

    private static final String BACKGROUND = "/resources/imgs/background.png";
    private AnimationTimer timer;
    private static final long FPS30 = 33333333;
    private Cat cat;
    private Mouse mouse;
    private Boolean moveUp = false;
    private Boolean moveDown = false;
    private Boolean moveLeft = false;
    private Boolean moveRight = false;
    private final int mouseSpeed = 5;
    private int catYPosition = 100;
    private int catSpeed = 5;

    public GameView(Stage _oldStage) {
	this.mainPane = new AnchorPane();
	this.mainScene = new Scene(this.mainPane, MenuView.WIDTH, MenuView.HEIGHT);
	this.mainStage = new Stage();
	this.mainStage.setScene(this.mainScene);
	this.mainStage.setTitle(this.TITLE);
	this.mainStage.setMaxHeight(this.HEIGHT);
	this.mainStage.setMaxWidth(this.WIDTH);
	this.mainStage.setMinHeight(this.HEIGHT);
	this.mainStage.setMinWidth(this.WIDTH);
	this.initializeTimer();
	_oldStage.hide();
	mainStage.show();
        //Create cat and mouse objects
	this.createSprites();
        //Call methods for cat and mouse movement
        this.createKeyPressedEvent();
        this.createKeyReleasedEvent();
        this.moveMouse();
        this.moveCat();

	BackgroundImage img = new BackgroundImage(new Image(GameView.BACKGROUND, GameView.WIDTH, GameView.HEIGHT, false, true), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
	this.mainPane.setBackground(new Background(img));
    }

    private void createSprites() {
	this.cat = new Cat(this.mainPane);
	this.mouse = new Mouse(this.mainPane);
    }

    private void initializeTimer() {
	this.timer = new AnimationTimer() {
            long lastUpdate = 0;
            int i = 0;

            @Override
            public void handle(long now) {
                //This if block will update every 30th of a second for animations.
                if (now - lastUpdate >= GameView.FPS30) {
                    lastUpdate = now;
                    i++;
                }
            }
        };
	timer.start();
    }

    /**
     * Method that handles the event of an arrow key being pressed. Will
     * be used in the moveMouse method to determine which direction the
     * mouse will move and when it starts moving.
     *
     * Cannot use this.moveUp within the handle method.
     */
    private void createKeyPressedEvent() {
        //Create key event
        this.mainScene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()) {
                    case UP:
                        moveUp = true;
                        break;
                    case DOWN:
                        moveDown = true;
                        break;
                    case LEFT:
                        moveLeft = true;
                        break;
                    case RIGHT:
                        moveRight = true;
                        break;
                    case SPACE:
                        break;
                }
            }
        }
        );
    }

    /**
     * Method that handles the event of a key being released. Will be used
     * in the moveMouse method to determine when the mouse stops moving
     * in a certain direction.
     *
     * Cannot use this.moveUp within the handle method.
     */
    private void createKeyReleasedEvent() {
        //Create key event
        this.mainScene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()) {
                    case UP:
                        moveUp = false;
                        break;
                    case DOWN:
                        moveDown = false;
                        break;
                    case LEFT:
                        moveLeft = false;
                        break;
                    case RIGHT:
                        moveRight = false;
                        break;
                    case SPACE:
                        break;
                }
            }
        }
        );
    }

    /**
     * Method that calls the moveY and moveX methods in response to the
     * key event. Continues movement as long as the key is pressed.
     */
    private void moveMouse() {

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                if (moveUp) {
                    mouse.moveYUp(-mouseSpeed);
                }
                if (moveDown) {
                    mouse.moveYDown(mouseSpeed);
                }
                if (moveLeft) {
                    mouse.moveXLeft(-mouseSpeed);
                }
                if (moveRight) {
                    mouse.moveXRight(mouseSpeed);
                }
            }
        };
        timer.start();
    }

    /**
     * Method that creates a path transition on which the cat moves along on
     * the screen.
     */
    private void moveCat() {
        PathTransition pathTransition = new PathTransition();
        pathTransition.setDuration(Duration.seconds(catSpeed));
        pathTransition.setNode(cat.getAnimationGroup());
        pathTransition.setPath(new Line(0, catYPosition, ViewManager.getWidth(), catYPosition));
        pathTransition.setCycleCount(INDEFINITE);
        pathTransition.setAutoReverse(true);
        //checkCollision();
        pathTransition.play();
    }

//=================  GETTERS ===============
    public Cat getCat() {
	return this.cat;
    }

    public Mouse getMouse() {
        return this.mouse;
    }
}

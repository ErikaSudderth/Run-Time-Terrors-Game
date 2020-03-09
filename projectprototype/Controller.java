package projectprototype;

/**
 * This initializes both a mouse and cat object and provides methods to move the
 * corresponding images on screen.
 *
 *
 *
 * Author Erika and Hasler Last updated: 2/22/20
 *
 */
import static javafx.animation.Animation.INDEFINITE;
import javafx.animation.AnimationTimer;
import javafx.animation.PathTransition;
import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Controller {

    private final int sceneWidth = 500;
    private final int sceneHeight = 500;
    private final int initialEnemyXLocation = 50;
    private final int initialEnemyYLocation = 50;
    private final int enemyImageWidth = 30;
    private final int enemyImageHeight = 30;
    private final int initialPlayerXLocation = 250;
    private final int initialPlayerYLocation = 450;
    private final int playerImageWidth = 30;
    private final int playerImageHeight = 30;
    private final int linePathDuration = 5;
    private final int initialLineXLocation = 30;
    private final int initialLineYLocation = 30;
    private final int finalLineXLocation = 30;
    private final int finalLineYLocation = 400;
    private final int changeInAxis = 2;
    private Stage initialStage;
    private GameplayGUI gameGUI;
    private GenericCharacter cat;
    private GenericCharacter mouse;
    private String catPNG = "CatImage.png";
    private String mousePNG = "MouseImage.png";
    private Boolean moveUp = false;
    private Boolean moveDown = false;
    private Boolean moveLeft = false;
    private Boolean moveRight = false;

    public Controller(Stage _initialStage) {
        // Set up the window (stage) and a separate scene for gameplay.
        this.initialStage = _initialStage;
        this.gameGUI = new GameplayGUI(_initialStage);
        this.gameGUI.createScene(sceneWidth, sceneHeight);
        // Initialize stand in characters for prototyping.
        this.cat = new GenericCharacter(this.initialEnemyXLocation,
                this.initialEnemyYLocation, this.enemyImageWidth,
                this.enemyImageHeight, this.catPNG);
        this.mouse = new GenericCharacter(this.initialPlayerXLocation,
                this.initialPlayerYLocation, this.playerImageWidth,
                this.playerImageHeight, this.mousePNG);
        // Call for cat movement with path transition and key controlled mouse movement.

        this.createLinePathTransition(cat.getImage());

        this.createLinePathTransition(cat.getImage());

        this.createKeyPressedEvent();
        this.createKeyReleasedEvent();
        this.moveMouse(mouse.getImage());
    }

    public void createLinePathTransition(ImageView _enemyImage) {

        PathTransition pathTransition = new PathTransition();
        pathTransition.setDuration(Duration.seconds(this.linePathDuration));
        pathTransition.setNode(_enemyImage);
        pathTransition.setPath(new Line(this.initialLineYLocation,
                this.initialLineXLocation, this.finalLineYLocation,
                this.finalLineXLocation));
        pathTransition.setCycleCount(INDEFINITE);
        pathTransition.setAutoReverse(true);
        checkCollision();
        pathTransition.play();

    }

    public void createKeyPressedEvent() {

        //Create key event
        this.gameGUI.getScene().setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()) {
                    case UP:
                        moveUp = true;
                        checkCollision();
                        break;
                    case DOWN:
                        moveDown = true;
                        checkCollision();
                        break;
                    case LEFT:
                        moveLeft = true;
                        checkCollision();
                        break;
                    case RIGHT:
                        moveRight = true;
                        checkCollision();
                        break;
                }
            }
        }
        );
    }

    public void createKeyReleasedEvent() {
        this.gameGUI.getScene().setOnKeyReleased(new EventHandler<KeyEvent>() {
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
                }
            }
        }
        );
    }

    public void checkCollision() {
        double radius = enemyImageHeight;
        double distanceX = (cat.getImage().getTranslateX() + 65) - (mouse.getImage().getLayoutX() + 15);
        double distanceY = (cat.getImage().getTranslateY() + 65) - (mouse.getImage().getLayoutY() + 15);

        double distanceFormula = Math.sqrt((distanceX * distanceX) + (distanceY * distanceY));

        if (distanceFormula <= radius) {
            System.out.println("Collided");
        }

    }

    public void moveMouse(ImageView _playerImage) {
        int higherBound = this.sceneHeight - this.playerImageHeight - changeInAxis;

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                if (moveUp && _playerImage.getLayoutY() >= changeInAxis) {
                    _playerImage.setLayoutY(_playerImage.getLayoutY() - changeInAxis);
                }
                if (moveDown && _playerImage.getLayoutY() <= higherBound) {
                    _playerImage.setLayoutY(_playerImage.getLayoutY() + changeInAxis);
                }
                if (moveLeft && _playerImage.getLayoutX() >= changeInAxis) {
                    _playerImage.setLayoutX(_playerImage.getLayoutX() - changeInAxis);
                }
                if (moveRight && _playerImage.getLayoutX() <= higherBound) {

                    _playerImage.setLayoutX(_playerImage.getLayoutX() + changeInAxis);
                }
            }
        };
        timer.start();
    }

}

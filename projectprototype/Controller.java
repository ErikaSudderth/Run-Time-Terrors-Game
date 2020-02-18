package projectprototype;

/**
 *
 * @author Erika
 */

import static javafx.animation.Animation.INDEFINITE;
import javafx.animation.AnimationTimer;
import javafx.animation.PathTransition;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Controller {

    protected Stage initialStage;
    protected GameplayGUI gameGUI;
    protected int sceneWidth = 500;
    protected int sceneHeight = 500;
    protected GenericCharacter cat;
    protected GenericCharacter mouse;
    protected String catPNG = "CatImage.png";
    protected String mousePNG = "MouseImage.png";
    protected Boolean moveUp = false;
    protected Boolean moveDown = false;
    protected Boolean moveLeft = false;
    protected Boolean moveRight = false;

    public Controller(Stage _initialStage) {
        this.initialStage = _initialStage;
        this.gameGUI = new GameplayGUI(_initialStage);

        this.gameGUI.createScene(sceneWidth, sceneHeight);

        this.cat = new GenericCharacter(50, 50, 30, 30, catPNG);
        this.mouse = new GenericCharacter(250, 450, 30, 30, mousePNG);

        this.createPathTransition();
        this.moveMouse();

    }

    public void createPathTransition() {
        PathTransition pathTransition = new PathTransition();
        pathTransition.setDuration(Duration.seconds(5));
        pathTransition.setNode(cat.getImage());
        pathTransition.setPath(new Line(30, 30, 400, 30));
        pathTransition.setCycleCount(INDEFINITE);
        pathTransition.setAutoReverse(true);
        pathTransition.play();
    }

    public void moveMouse() {
        //Create key event
        this.gameGUI.getScene().setOnKeyPressed(new EventHandler<KeyEvent>() {
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
                }
            }
        }
        );

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

        AnimationTimer timer = new AnimationTimer(){
            @Override
            public void handle(long now) {
                if(moveUp && mouse.getValueY() >= 5) {
                    mouse.setValueY(mouse.getValueY() - 2);
                }
                if(moveDown && mouse.getValueY() <= 465) {
                    mouse.setValueY(mouse.getValueY() + 2);
                }
                if(moveLeft && mouse.getValueX() >= 5) {
                    mouse.setValueX(mouse.getValueX() - 2);
                }
                if(moveRight && mouse.getValueX() <= 465) {
                    mouse.setValueX(mouse.getValueX() + 2);
                }
            }
        };
        timer.start();
    }
}

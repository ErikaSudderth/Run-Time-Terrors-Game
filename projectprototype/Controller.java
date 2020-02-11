package projectprototype;

/**
 *
 * @author Erika
 */

import static javafx.animation.Animation.INDEFINITE;
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
                        if(mouse.getValueY() >= 5)
                            mouse.setValueY(mouse.getValueY() - 5);
                        break;
                    case DOWN:
                        if(mouse.getValueY() <= 465) //500-35 (height of image + 5)
                            mouse.setValueY(mouse.getValueY() + 5);
                        break;
                    case LEFT:
                        if (mouse.getValueX() >= 5)
                            mouse.setValueX(mouse.getValueX() - 5);
                        break;
                    case RIGHT:
                        if(mouse.getValueX() <= 465)
                            mouse.setValueX(mouse.getValueX() + 5);
                        break;
                    case SPACE:
                        break;

                }
            }
        }
        );
    }
}

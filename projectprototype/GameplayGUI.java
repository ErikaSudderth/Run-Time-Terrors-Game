package projectprototype;

/**
 * This class allows for creation of a scene. This will have to be combined with
 * the other GUI code.
 *
 * @author Erika
 * Last updated: 2/18/20
 */

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class GameplayGUI {

    public static Stage initialStage;
    public static Pane layoutPane = new Pane();
    public static Scene scene;
    private static final String BACKGROUND = "/resources/imgs/background.png";

    public GameplayGUI(Stage _initialStage) {
        this.initialStage = _initialStage;
    }

    public void createScene(int _sceneWidth, int _sceneHeight) {
        this.scene = new Scene(this.layoutPane, _sceneWidth, _sceneHeight);
        this.initialStage.setScene(this.scene);
        //Setting the background
        BackgroundImage img = new BackgroundImage(new Image(BACKGROUND, _sceneWidth, _sceneHeight, false, true), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        this.layoutPane.setBackground(new Background(img));
    }

//=================  GETTERS ===============
    public Scene getScene() {
        return scene;
    }

//=================  SETTERS ===============
}

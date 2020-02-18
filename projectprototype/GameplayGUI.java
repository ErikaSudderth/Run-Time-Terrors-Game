package projectprototype;

/**
 *
 * @author Erika
 */

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class GameplayGUI {

    public static Stage initialStage;
    public static Pane layoutPane = new Pane();
    public static Scene scene;

    public GameplayGUI(Stage _initialStage) {
        this.initialStage = _initialStage;
    }

    public void createScene(int _sceneWidth, int _sceneHeight) {
        this.scene = new Scene(this.layoutPane, _sceneWidth, _sceneHeight);
        this.initialStage.setScene(this.scene);
    }

    public Scene getScene() {
        return scene;
    }

}

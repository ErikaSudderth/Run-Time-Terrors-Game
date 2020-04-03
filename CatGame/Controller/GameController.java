package CatGame.Controller;

/**
 * This class will route the calls from the Game view. Author(s): Greg Dwyer Last Updated: 3/31/20
 */
import CatGame.Models.Input;
import CatGame.Models.KeyboardInput;
import CatGame.Sprite.Mouse;
import CatGame.ViewManagers.GameView;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class GameController {

    private final GameView VIEW;
    private final Stage MENUSTAGE;
    private final Input input;

    public GameController(Stage _menuStage) {
        this.MENUSTAGE = _menuStage;
        this.VIEW = new GameView(this, MENUSTAGE);
        this.input = new KeyboardInput(this);
    }

    public void moveMouse(Mouse _mouse) {
        _mouse.moveMouse(this.input);
    }

    public Scene getViewScene() {
        return this.VIEW.getMainScene();
    }

    public AnchorPane getViewPane() {
        return this.VIEW.getMainPane();
    }

    public Stage getViewStage() {
        return this.VIEW.getMainStage();
    }
}

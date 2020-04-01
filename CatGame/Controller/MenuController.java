package CatGame.Controller;

/**
 * This method handles calls from the MenuView. Author(s): Greg Dwyer Last Updated: 3/25/20
 *
 */
import CatGame.Events.EventCodes;
import CatGame.ViewManagers.MenuView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MenuController {

    private final MenuView VIEW;

    public MenuController() {
        this.VIEW = new MenuView(this);
    }

    public void handle(int _code) {
        switch (_code) {
            case EventCodes.START_GAME:
                GameController game = new GameController(this.getViewStage());
                break;
            case EventCodes.HOW_TO_PLAY:
                //show how to play
                break;
            case EventCodes.HIGHSCORES:
                //Display High scores
                break;
            case EventCodes.SETTINGS_MENU:
                //open settings menu
                break;
            case EventCodes.EXIT:
                this.VIEW.getMainStage().close();
                break;
        }
    }

    public AnchorPane getViewPane() {
        return this.VIEW.getMainPane();
    }

    public Stage getViewStage() {
        return this.VIEW.getMainStage();
    }
}

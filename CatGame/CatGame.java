package CatGame;

/**
 * This is the main method for the game. It calls the method to start the Menu view. Author(s) - Greg Last updated - 3/6/20
 */
import CatGame.Controller.MenuController;
import javafx.application.Application;
import javafx.stage.Stage;

public class CatGame extends Application {

    @Override
    public void start(Stage _mainMenu) {
        MenuController controller = new MenuController();
        _mainMenu = controller.getViewStage();
        _mainMenu.show();
        //SFX.music();
    }

    public static void main(String[] args) {
        launch();
    }

}

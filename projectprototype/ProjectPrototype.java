package projectprototype;

/**
 * This is the main class. It starts the program, creates a stage, and calls
 * the controller to begin the game.
 *
 * @author Erika
 * Last updated: 2/18/20
 */

import javafx.application.Application;
import javafx.stage.Stage;

public class ProjectPrototype extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage _primaryStage) {
        Controller controller = new Controller(_primaryStage);
        //This shows the actual window
        _primaryStage.show();
    }
}

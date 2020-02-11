package projectprototype;

/**
 *
 * @author Erika
 */

import javafx.application.Application;
import javafx.stage.Stage;

public class ProjectPrototype extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Controller controller = new Controller(primaryStage);
        //This shows the actual window
        primaryStage.show();
    }
}

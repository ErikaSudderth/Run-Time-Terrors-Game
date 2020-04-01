package CatGame.ViewManagers;

/**
 * This class sets the base qualities of the views. Author(s) - Greg Last updated - 3/6/20
 */
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public abstract class ViewManager {

    protected static final int WIDTH = 800;
    protected static final int HEIGHT = 600;
    protected static final int BCKGRD_WIDTH = 820;
    protected static final int BCKGRD_HEIGHT = 800;
    protected static final String TITLE = "Quesadilla Ratón";
    AnchorPane mainPane;
    Scene mainScene;
    Stage mainStage;

    public ViewManager() {

    }
//=================  GETTERS ===============

    public static int getWidth() {
        return ViewManager.WIDTH;
    }

    public static int getHeight() {
        return ViewManager.HEIGHT;
    }

    public AnchorPane getMainPane() {
        return this.mainPane;
    }

    public Scene getMainScene() {
        return this.mainScene;
    }

    public Stage getMainStage() {
        return this.mainStage;
    }
}

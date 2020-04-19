package CatGame.ViewManagers;

/**
 * This class sets the base qualities of the views. Author(s) - Greg Last updated - 4/15/20
 */
import java.io.FileInputStream;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public abstract class ViewManager {

    protected static final int WIDTH = 800;
    protected static final int HEIGHT = 600;
    protected static final int BCKGRD_WIDTH = 830;
    protected static final int BCKGRD_HEIGHT = 830;
    protected static final String TITLE = "Quesadilla Ratón";
    protected static final String FONT_PATH = "src/resources/C64_Pro_Mono-STYLE.ttf";
    protected final Font FONT;
    protected AnchorPane mainPane;
    protected Scene mainScene;
    protected Stage mainStage;
    protected final int DEFAULT_FONT_SIZE = 26;

    public ViewManager() {
        Font font;
        try {
            font = Font.loadFont(new FileInputStream(this.FONT_PATH), this.DEFAULT_FONT_SIZE );
        }
        catch(Exception e){
            font = Font.font("Verdana", this.DEFAULT_FONT_SIZE);
            System.out.println("Whoopsie." + e);
        }
        this.FONT = font;
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

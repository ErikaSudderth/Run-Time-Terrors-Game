package CatGame.ViewManagers;

/**
 * This class handles the subscenes. Author(s) - Greg Last updated - 3/6/20
 */
import CatGame.ButtonExt;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.SubScene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.util.Duration;

public class SubSceneExt extends SubScene {

    private Boolean isHidden = true;
    private final static int PREF_HEIGHT = 400;
    private final static int PREF_WIDTH = 350;
    private final static int LAYOUT_X = ViewManager.WIDTH + 10;
    private final static int CENTER_X = ViewManager.WIDTH / 2;
    private final static int LAYOUT_Y = 150;
    private final static int BUTTON_LAYOUT_X = 75;
    private final static int BUTTON_LAYOUT_Y = 30;
    private final static int BUTTON_SPACING = 100;
    private final static String BACKGROUND = "/resources/imgs/subscene_background.png";
    private final AnchorPane SUB_ANCHOR;

    public SubSceneExt() {
        super(new AnchorPane(), SubSceneExt.PREF_WIDTH, SubSceneExt.PREF_HEIGHT);
        this.setLayoutX(SubSceneExt.LAYOUT_X);
        this.setLayoutY(SubSceneExt.LAYOUT_Y);
        BackgroundImage img = new BackgroundImage(new Image(SubSceneExt.BACKGROUND, SubSceneExt.PREF_WIDTH, SubSceneExt.PREF_HEIGHT, false, true), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        this.SUB_ANCHOR = (AnchorPane) this.getRoot();
        this.SUB_ANCHOR.setBackground(new Background(img));
    }

    /**
     * This method moves the subscene from its hidden position off screen, onto the screen.
     */
    public void moveSubScene() {
        TranslateTransition transition = new TranslateTransition();
        transition.setDuration(Duration.seconds(0.3));
        transition.setNode(this);

        //This block handles if a subscene is already visible or not.
        if (this.isHidden) {
            transition.setToX(-(SubSceneExt.CENTER_X));
        } else {
            transition.setToX(SubSceneExt.CENTER_X);
        }
        this.isHidden = !this.isHidden;
        transition.play();
    }

//=================  GETTERS ===============
    public AnchorPane getSubAnchor() {
        return this.SUB_ANCHOR;
    }

    public int getButtonLayoutX() {
        return SubSceneExt.BUTTON_LAYOUT_X;
    }

    public int getButtonLayoutY() {
        return SubSceneExt.BUTTON_LAYOUT_Y;
    }

    public int getButtonSpacing() {
        return SubSceneExt.BUTTON_SPACING;
    }
}

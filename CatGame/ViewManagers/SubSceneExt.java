package CatGame.ViewManagers;

/**
 * This class handles the subscenes.
 * Author(s) - Greg
 * Last updated - 4/29/20
 */

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
    private static int center_x = ViewManager.WIDTH / 2;
    private final static int LAYOUT_Y = 150;
    private final static int TEXT_LAYOUT_X = 25;
    private final static int TEXT_LAYOUT_Y = 35;
    private final static int TEXT_SPACING = 10;
    private final static int TEXT_SIZE = 12;
    private static int buttonLayoutY = 75;
    private static int buttonLayoutX = 30;
    private static int buttonSpacing = 100;
    private final static String BACKGROUND = "/resources/imgs/subscene_background.png";
    private final AnchorPane SUB_ANCHOR;

    public SubSceneExt(int LAYOUT_X, int LAYOUT_Y) {
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
    public void moveSubScene(int _centerX) {
        setCenterX(_centerX);
        TranslateTransition transition = new TranslateTransition();
        transition.setDuration(Duration.seconds(0.3));
        transition.setNode(this);

        //This block handles if a subscene is already visible or not.
        if (this.isHidden) {
            transition.setToX(-(SubSceneExt.center_x));
        } else {
            transition.setToX(SubSceneExt.center_x);
        }
        this.isHidden = !this.isHidden;
        transition.play();
    }

//=================  SETTERS ===============
    public void setCenterX(int _centerX) {
        this.center_x = _centerX;
    }

    public void setButtonSpacing(int _BUTTON_SPACING) {
        this.buttonSpacing = _BUTTON_SPACING;
    }

     public void setButtonLayoutX(int _button_layout_x) {
        this.buttonLayoutY = _button_layout_x;
    }

    public void setButtonLayoutY(int _button_layout_y) {
        this.buttonLayoutX = _button_layout_y;
    }

//=================  GETTERS ===============
    public AnchorPane getSubAnchor() {
        return this.SUB_ANCHOR;
    }

    public int getButtonLayoutX() {
        return SubSceneExt.buttonLayoutY;
    }

    public int getButtonLayoutY() {
        return SubSceneExt.buttonLayoutX;
    }

    public int getButtonSpacing() {
        return SubSceneExt.buttonSpacing;
    }

    public int getTextLayoutX() {
        return SubSceneExt.TEXT_LAYOUT_X;
    }

    public int getTextLayoutY() {
        return SubSceneExt.TEXT_LAYOUT_Y;
    }

    public int getTextSpacing() {
        return SubSceneExt.TEXT_SPACING;
    }

    public int getTextSize() {
        return SubSceneExt.TEXT_SIZE;
    }

}

package CatGame.ViewManagers;

/**
 * This is the Menu View Manager Author(s) - Greg Last updated - 3/6/20
 */

import CatGame.ButtonExt;
import CatGame.Controller.MenuController;
import CatGame.Events.EventCodes;
import java.awt.event.ActionListener;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BackgroundImage;
import javafx.stage.Stage;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;

public class MenuView extends ViewManager {

    protected static final int BUTTON_START_X = 100;
    protected static final int BUTTON_START_Y = 100;
    protected static final int BUTTON_SPACING = 100;
    protected static final String BACKGROUND = "/resources/imgs/menu_background.png";
    protected MenuController controller;
    protected ButtonExt exitButton;
    private SubSceneExt subSceneOnScreen;

    public MenuView(MenuController _cont) {
        this.mainPane = new AnchorPane();
        this.mainScene = new Scene(this.mainPane, MenuView.WIDTH, MenuView.HEIGHT);
        this.mainStage = new Stage();
        this.mainStage.setScene(this.mainScene);
        this.mainStage.setTitle(this.TITLE);
        this.mainStage.setResizable(false);
        this.controller = _cont;
        this.createMenuButtons();

        BackgroundImage img = new BackgroundImage(new Image(MenuView.BACKGROUND, MenuView.BCKGRD_WIDTH, MenuView.BCKGRD_HEIGHT, true, true), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        this.mainPane.setBackground(new Background(img));
    }

    public void showSubScene(SubSceneExt _subscene) {
        if (subSceneOnScreen != null) {
            subSceneOnScreen.moveSubScene();
        }
        _subscene.moveSubScene();
        subSceneOnScreen = _subscene;
    }

    private void createMenuButtons() {
        this.createButton("Game", EventCodes.START_GAME);
        this.createButton("How to Play", EventCodes.HOW_TO_PLAY);
        this.createButton("Highscores", EventCodes.HIGHSCORES);
        this.createButton("Settings", EventCodes.SETTINGS_MENU);
        this.createButton("Exit", EventCodes.EXIT);
    }

    private void createButton(String _text, int _code) {
        ButtonExt button = new ButtonExt(_text, MenuView.BUTTON_START_X, (MenuView.BUTTON_START_Y + this.mainPane.getChildren().size() * MenuView.BUTTON_SPACING));
        this.mainPane.getChildren().add(button);
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                controller.handle(_code);
            }
        });
    }

    //=================  GETTERS ===============
    public static int getWIDTH() {
        return MenuView.WIDTH;
    }

    public static int getHEIGHT() {
        return MenuView.HEIGHT;
    }

    public static int getBUTTON_START_X() {
        return MenuView.BUTTON_START_X;
    }

    public static int getBUTTON_START_Y() {
        return MenuView.BUTTON_START_Y;
    }

    public static int getBUTTON_SPACING() {
        return MenuView.BUTTON_SPACING;
    }

    public static String getBACKGROUND() {
        return MenuView.BACKGROUND;
    }

}

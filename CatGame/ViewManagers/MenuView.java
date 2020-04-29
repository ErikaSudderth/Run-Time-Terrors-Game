package CatGame.ViewManagers;

/**
 * This is the Menu View Manager.
 * Author(s) - Greg Dwyer
 * Last updated - 4/27/20
 */
import CatGame.Models.ScoreSort;
import CatGame.Controller.MenuController;
import CatGame.Events.EventCodes;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BackgroundImage;
import javafx.stage.Stage;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class MenuView extends ViewManager {

    protected static final int BUTTON_START_X = 100;
    protected static final int BUTTON_START_Y = 100;
    protected static final int BUTTON_SPACING = 100;
    //This is for subscenes.
    private static int buttonLayoutX = 75;
    private static int buttonLayoutY = 30;
    private static int buttonSpacing = 100;

    protected static final String BACKGROUND = "/resources/imgs/menu_background.png";
    protected MenuController controller;
    protected ButtonExt exitButton;
    private SubSceneExt subSceneOnScreen;
    protected SubSceneExt settings;
    protected SubSceneExt howToPlay;
    protected SubSceneExt highscores;
    private final static int LAYOUT_Y = 150;
    private final static int LAYOUT_X = ViewManager.WIDTH + 10;
    private static int centerX = ViewManager.WIDTH / 2;
    private final String HTP_INSTRUCTIONS = "src/resources/htp.txt";
    private ArrayList<String> topScores;
    private final int HIGHSCORE_LENGTH = 15;
    private Text scoresTable;

    public MenuView(MenuController _cont) {
        this.mainPane = new AnchorPane();
        this.mainScene = new Scene(this.mainPane, MenuView.WIDTH, MenuView.HEIGHT);
        this.mainStage = new Stage();
        this.mainStage.setScene(this.mainScene);
        this.mainStage.setTitle(this.TITLE);
        this.mainStage.setResizable(false);
        this.mainStage.sizeToScene();
        this.controller = _cont;
        this.createMenuButtons();
        this.populateSettings();
        this.populateHowToPlay();
        this.populateHighscores();

        BackgroundImage img = new BackgroundImage(new Image(MenuView.BACKGROUND, MenuView.BCKGRD_WIDTH, MenuView.BCKGRD_HEIGHT, true, true), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        this.mainPane.setBackground(new Background(img));
    }

    /**
     * Use this method to show the passed subscene.
     *
     * @param _subscene
     */
    public void showSubScene(SubSceneExt _subscene) {
        if (this.subSceneOnScreen != null) {
            this.subSceneOnScreen.moveSubScene(this.centerX);
        }
        _subscene.moveSubScene(this.centerX);
        this.subSceneOnScreen = _subscene;
    }

    /**
     * This method will get an up to date string of the top scores.
     */
    public void updateHighscores(){
        this.topScores = new ScoreSort().getArrayList();
        String scores="Highscores:\n";
        for(int i = 0; i < this.HIGHSCORE_LENGTH && i < this.topScores.size(); i++){
                scores += (i+1) + "." + this.topScores.get(i) + "\n";
            }
        this.scoresTable.setText(scores);
    }

    /**
     * This method will show the settings subscene.
     */
    public void showSettings() {
        this.showSubScene(this.settings);
    }

    /**
     * This method will show the how to play subscene.
     */
    public void showHowToPlay() {
        this.showSubScene(this.howToPlay);
    }

    /**
     * This method will show the high scores subscene.
     */
    public void showHighscores() {
        this.showSubScene(this.highscores);
    }

    /**
     * This method will populate the main menu with the proper buttons and set their actions.
     */
    private void createMenuButtons() {
        this.createMenuButton("Start Game", EventCodes.START_GAME);
        this.createMenuButton("How to Play", EventCodes.HOW_TO_PLAY);
        this.createMenuButton("Highscores", EventCodes.HIGHSCORES);
        this.createMenuButton("Settings", EventCodes.SETTINGS_MENU);
        this.createMenuButton("Exit", EventCodes.EXIT);
    }

    /**
     * This method is a helper to createMenuButtons. This one repeats the placement and code setting for each button.
     *
     * @param _text
     * @param _code
     */
    private void createMenuButton(String _text, int _code) {
        ButtonExt button = new ButtonExt(_text, MenuView.BUTTON_START_X, (MenuView.BUTTON_START_Y + this.mainPane.getChildren().size() * MenuView.BUTTON_SPACING));
        this.placeButton(button, _code, this.mainPane);
    }

    /**
     * This method handles the actual placement of the button on the screen
     *
     * @param _button
     * @param _code
     * @param _pane
     */
    private void placeButton(ButtonExt _button, int _code, AnchorPane _pane) {
        _pane.getChildren().add(_button);
        _button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                controller.handle(_code);
            }
        });
    }

    /**
     * This method creates buttons that will have an attached subscene.
     *
     * @param _text
     * @param _code
     * @param _scene
     */
    private void createSubSceneButton(String _text, int _code, SubSceneExt _scene) {
        _scene.setButtonLayoutX(this.buttonLayoutX);
        _scene.setButtonLayoutY(this.buttonLayoutY);
        _scene.setButtonSpacing(this.buttonSpacing);
        ButtonExt button = new ButtonExt(_text, _scene.getButtonLayoutX(), (_scene.getButtonLayoutY() + _scene.getSubAnchor().getChildren().size() * _scene.getButtonSpacing()));
        this.placeButton(button, _code, _scene.getSubAnchor());
    }

    /**
     * This method populates the settings subscene.
     */
    private void populateSettings() {

        this.settings = new SubSceneExt(this.LAYOUT_X, this.LAYOUT_Y);
        this.createSubSceneButton("Volume Up", EventCodes.VOL_UP, this.settings);
        this.createSubSceneButton("Volume Down", EventCodes.VOL_DOWN, this.settings);
        this.createSubSceneButton("Toggle SFX", EventCodes.TOGGLE_SFX, this.settings);
        this.createSubSceneButton("Toggle Music", EventCodes.TOGGLE_MUSIC, this.settings);
        this.mainPane.getChildren().add(this.settings);

    }

    /**
     * This method populates the how to play subscene.
     */
    private void populateHowToPlay(){
        this.howToPlay = new SubSceneExt(this.LAYOUT_X,this.LAYOUT_Y);
        Text htp = new Text();

        htp.setLayoutX(this.howToPlay.getTextLayoutX());
        htp.setLayoutY(this.howToPlay.getTextLayoutY());
        htp.setWrappingWidth(this.howToPlay.getWidth()- 2 * this.howToPlay.getTextLayoutX());
        htp.setLineSpacing(this.howToPlay.getTextSpacing());
        htp.setTextAlignment(TextAlignment.JUSTIFY);
        String howToPlay = "Arrow keys to move. Esc to quit.";
        try{
            htp.setFont(Font.loadFont(new FileInputStream(this.FONT_PATH), this.howToPlay.getTextSize() ));
            howToPlay = new String(Files.readAllBytes(Paths.get(this.HTP_INSTRUCTIONS)));
        } catch (Exception e) {
            System.out.println(e);
        }
        htp.setText(howToPlay);
        this.howToPlay.getSubAnchor().getChildren().add(htp);

        this.mainPane.getChildren().add(this.howToPlay);
    }

    /**
     * This method populates the high scores subscene.
     */
    private void populateHighscores() {
        this.highscores = new SubSceneExt(this.LAYOUT_X, this.LAYOUT_Y);
        this.topScores = new ScoreSort().getArrayList();
        this.scoresTable = new Text();
        this.scoresTable.setLayoutX(this.highscores.getTextLayoutX());
        this.scoresTable.setLayoutY(this.highscores.getTextLayoutY());
        this.scoresTable.setWrappingWidth(this.highscores.getWidth()- 2 * this.highscores.getTextLayoutX());
        this.scoresTable.setLineSpacing(this.highscores.getTextSpacing());
        String scores = "Highscores: \n";
        try{
            this.scoresTable.setFont(Font.loadFont(new FileInputStream(this.FONT_PATH), this.highscores.getTextSize() ));
            for(int i = 0; i < this.HIGHSCORE_LENGTH && i < this.topScores.size(); i++){
                scores += (i+1) + "." + this.topScores.get(i) + "\n";
            }
        }
        catch(Exception e){
            System.out.println("populateHighscores: " + e);
        }
        this.scoresTable.setText(scores);
        this.highscores.getSubAnchor().getChildren().add(this.scoresTable);
        this.mainPane.getChildren().add(this.highscores);
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

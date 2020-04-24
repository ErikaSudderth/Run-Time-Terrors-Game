package CatGame.ViewManagers;

/**
 * This is the Menu View Manager Author(s) - Greg, Erika Sudderth, Anthony, Hasler
 * Last Updated - 4/15/20
 */
import CatGame.ButtonExt;
import CatGame.Controller.GameController;
import CatGame.Events.EventCodes;
import CatGame.Sprite.*;
import java.io.FileInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;
import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class GameView extends ViewManager {

    private static final String BACKGROUND = "/resources/imgs/game_background.png";
    private AnimationTimer timer;
    private GameController controller;
    private Cat cat;
    private Mouse mouse;
    public int score = 0;
    public int health = 5;
    //The lower, the harder for di fficulty.
    private final int DIFFICULTY = 3;
    private boolean increaseDifficulty = false;
    private final int STARTING_CHEESE = 10;
    private final int STARTING_HAIRBALLS = 20;
    private int newHairBalls = 0;
    private Label scoreLabel;
    private Label livesLabel;
    private final String LABEL_ID = "label";
    private final String SUBSCENE_ID = "endGame";
    private final static int LAYOUT_Y = 150;
    private final static int LAYOUT_X = ViewManager.WIDTH + 20;

    //This for the subscene button and text
    private static int button_layout_x = 75;
    private static int button_layout_y = 250;
    private static int button_spacing = 50;

    private SubSceneExt subSceneOnScreen;
    protected SubSceneExt ENDGAME;
    private static int center_x = ViewManager.WIDTH - 210;
    private final String LIVES_COLOR = "red";
    private final String SCORE_COLOR = "orange";

    public GameView(GameController _cont, Stage _oldStage) {

        scoreLabel = new Label();
        scoreLabel.setText("Score:" + this.score);
        scoreLabel.setFont(this.FONT);
        scoreLabel.setTextFill(Color.web(this.SCORE_COLOR));

        Node score = scoreLabel;
        score.setId(this.LABEL_ID);

        livesLabel = new Label();
        livesLabel.setText("Lives:" + this.health);
        livesLabel.setFont(this.FONT);
        livesLabel.setTextFill(Color.web(this.LIVES_COLOR));
        livesLabel.relocate(0, 25);
        Node lives = livesLabel;
        lives.setId(this.LABEL_ID);

        this.controller = _cont;
        this.mainPane = new AnchorPane();
        this.mainPane.getChildren().add(score);
        this.mainPane.getChildren().add(lives);

        this.mainScene = new Scene(this.mainPane, GameView.WIDTH, GameView.HEIGHT);
        this.mainStage = new Stage();
        this.mainStage.setScene(this.mainScene);
        this.mainStage.setTitle(this.TITLE);
        this.mainStage.setResizable(false);
        this.mainStage.sizeToScene();
        _oldStage.hide();
        mainStage.show();
        //Create cat and mouse objects
        this.createSprites();
        this.populateEndGame();
        this.initializeTimer();

        BackgroundImage img = new BackgroundImage(new Image(GameView.BACKGROUND, 820, 800, true, true), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        this.mainPane.setBackground(new Background(img));

    }
    /**
     * This method shows the subscene.
     * @param _subscene
     */
    public void showSubScene(SubSceneExt _subscene) {
        if (subSceneOnScreen != null) {
            subSceneOnScreen.moveSubScene(center_x);
        }
        _subscene.moveSubScene(center_x);
        subSceneOnScreen = _subscene;
    }

    /**
     * This method populates the necessary sprites for a game.
     */
    private void createSprites() {
        Door door = new Door(this.mainPane);

        for (int counter = 0; counter < this.STARTING_HAIRBALLS; counter++) {
            Hairball hairball = new Hairball(this.mainPane, this.STARTING_HAIRBALLS);
        }
        for (int counter2 = 0; counter2 < this.STARTING_CHEESE; counter2++) {
            Cheese cheese = new Cheese(this.mainPane);
        }
        this.mouse = new Mouse(this.mainPane);
        this.cat = new Cat(this.mainPane);
    }

    /**
     * This is the game loop. Anything that needs to happen on the cycle should
     * be put inside the "handle."
     */
    private void initializeTimer() {
        this.timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                controller.moveMouse(mouse);
                controller.checkCollisions();

                if (increaseDifficulty) {
                    Hairball hairball = new Hairball(mainPane, STARTING_HAIRBALLS + newHairBalls);
                    increaseDifficulty = false;
                }

            }
        };
        this.timer.start();
    }
    private void placeButton(ButtonExt _button, int _code, AnchorPane _pane) {
        _pane.getChildren().add(_button);
        _button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                controller.handle(_code);
            }
        });
    }
    private void createSubSceneButton(String _text, int _code, SubSceneExt _scene) {
        _scene.setButtonLayoutX(button_layout_x);
        _scene.setButtonLayoutY(button_layout_y);
        _scene.setButtonSpacing(button_spacing);
        ButtonExt button = new ButtonExt(_text, _scene.getButtonLayoutX(), (_scene.getButtonLayoutY() + _scene.getSubAnchor().getChildren().size() * _scene.getButtonSpacing()));
        this.placeButton(button, _code, _scene.getSubAnchor());
    }

    /**
     * This method replaces a collected cheese.
     *
     * @param _cheese This is the cheese to be replaced.
     */
    public void replaceCheese(Node _cheese) {
        this.score++;


        System.out.println("Current Score: " + this.score);
        scoreLabel.setText("Score:" + this.score);

        Cheese.placeCheese(_cheese);
        if (this.score % this.DIFFICULTY == 0) {
            this.increaseDifficulty = true;
        }
    }

    /**
     * Use this method to clear the game pane in order to exit.
     */
    public void exitGame() {
        this.stopGame();
        this.mainPane.getChildren().clear();
    }

    /**
     * This method stops all of the animations and input.
     */
    private void stopGame() {
        this.timer.stop();
        this.controller.endClaws(this.cat);
    }

    /**
     * This method decrements the player's health after a collision.
     */
    public void enemyCollision() {

        this.health--;
        if(this.health == 0){
            this.showEndGameSubscene();
            this.stopGame();

        }


        System.out.println("Remaining Health: " + this.health);
        livesLabel.setText("Lives:" + this.health);

    }
    /**
     * This method will populate buttons and textfields to the subscene.
     */
    private void populateEndGame() {
        //creating subscene
        this.ENDGAME = new SubSceneExt(LAYOUT_X,LAYOUT_Y);
        Node endgame = this.ENDGAME;
        endgame.setId(this.SUBSCENE_ID);

        //Creating buttons
        this.createSubSceneButton("YES", EventCodes.YES_POST_TO_SOCIAL_MEDIA, this.ENDGAME);
        this.createSubSceneButton("NO", EventCodes.NO_POST_TO_SOCIAL_MEDIA, this.ENDGAME);

        //Game over label.
        String endGame = "GAME OVER!";
        Label htp = new Label();
        htp.setLayoutX(this.ENDGAME.getTextLayoutX() + 20);
        htp.setLayoutY(this.ENDGAME.getTextLayoutY());
        htp.setLineSpacing(this.ENDGAME.getTextSpacing());
        htp.setText(endGame);
        htp.setFont(this.FONT);
        htp.setTextFill(Color.web(this.LIVES_COLOR));

        //This label is for if they want to post to social media.
        String instruct = "Enter your name! Then select you want us to display your name and score to our social media";
        Text instruction = new Text();
        instruction.setLayoutX(this.ENDGAME.getTextLayoutX() + 20);
        instruction.setLayoutY(this.ENDGAME.getTextLayoutY() + 80);
        instruction.setWrappingWidth(this.ENDGAME.getWidth()- 2 * this.ENDGAME.getTextLayoutX());
        instruction.setLineSpacing(this.ENDGAME.getTextSpacing());
        instruction.setText(instruct);
        //This is for the font.
        try{
            instruction.setFont(Font.loadFont(new FileInputStream(this.FONT_PATH), this.ENDGAME.getTextSize() ));

        }
        catch(Exception e){
            System.out.println(e);
        }
        //Input textfield
        TextField field = new TextField();
        field.setLayoutX(button_layout_x + 20);
        field.setLayoutY(this.ENDGAME.getTextLayoutY() + 165);

        this.ENDGAME.getSubAnchor().getChildren().add(instruction);
        this.ENDGAME.getSubAnchor().getChildren().add(field);
        this.ENDGAME.getSubAnchor().getChildren().add(htp);
        this.mainPane.getChildren().add(endgame);
    }

    /**
     * This method will show the subscene.
     */
    public void showEndGameSubscene() {
        this.showSubScene(this.ENDGAME);
    }



//=================  GETTERS ===============

    public Cat getCat() {
        return this.cat;
    }

    public Mouse getMouse() {
        return this.mouse;
    }

    public Scene getMainScene() {
        return this.mainScene;
    }

}

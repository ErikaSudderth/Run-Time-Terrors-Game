package CatGame.ViewManagers;

/**
<<<<<<< HEAD
 * This is the Menu View Manager Author(s) - Greg, Erika Sudderth, Anthony, Hasler
 * Last Updated - 4/15/20
 */
import CatGame.Controller.GameController;
import CatGame.Sprite.*;
import java.io.FileInputStream;
import java.util.Random;
import javafx.animation.AnimationTimer;
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
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

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
    private SubSceneExt subSceneOnScreen;
    protected SubSceneExt ENDGAME;
    private static int center_x = ViewManager.WIDTH - 210;

    public GameView(GameController _cont, Stage _oldStage) {

        scoreLabel = new Label();
        scoreLabel.setText("Score:" + this.score);
        scoreLabel.setFont(Font.font("Verdana", 26));
        scoreLabel.setTextFill(Color.web("orange"));
        Node score = scoreLabel;
        score.setId(this.LABEL_ID);

        livesLabel = new Label();
        livesLabel.setText("Lives:" + this.health);
        livesLabel.setFont(Font.font("Verdana", 26));

        livesLabel.setTextFill(Color.web("red"));
        livesLabel.relocate(0, 25);
        Node lives = livesLabel;
        lives.setId("livesLabel");

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
        this.timer.stop();
        this.mainPane.getChildren().clear();
        this.controller.endClaws(this.cat);
    }

    /**
     * This method decrements the player's health after a collision.
     */
    public void enemyCollision() {

        this.health--;
        if(this.health == 0){
            this.showEndGameSubscene();
            //this.exitGame();
            this.controller.endClaws(this.cat);
            this.mainPane.getChildren().remove(this.cat);
            this.timer.stop();

        }


        System.out.println("Remaining Health: " + this.health);
        livesLabel.setText("Lives:" + this.health);

    }
    private void populateEndGame() {
        this.ENDGAME = new SubSceneExt(LAYOUT_X,LAYOUT_Y);
        Node endgame = this.ENDGAME;
        endgame.setId(this.SUBSCENE_ID);
        this.mainPane.getChildren().add(this.ENDGAME);
    }

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

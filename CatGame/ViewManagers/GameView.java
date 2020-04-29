package CatGame.ViewManagers;

/**
 * This is the Menu View Manager
 * Author(s) - Greg, Erika Sudderth, Anthony, Hasler
 * Last Updated - 4/27/20
 */
import CatGame.Controller.GameController;
import CatGame.Events.EventCodes;
import CatGame.Sprite.*;
import java.io.FileInputStream;
import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
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
import javafx.scene.text.TextAlignment;

public class GameView extends ViewManager {

    private static final String BACKGROUND = "/resources/imgs/game_background.png";
    private AnimationTimer timer;
    private GameController controller;
    private Cat cat;
    private Mouse mouse;
    public int score = 0;
    public int health = 5;
    //The lower, the harder for difficulty.
    private final int DIFFICULTY = 3;
    private boolean increaseDifficulty = false;
    private final int STARTING_CHEESE = 6;
    private final int STARTING_HAIRBALLS = 20;
    private int newHairBalls = 0;
    private Label scoreLabel;
    private Label livesLabel;
    private final String LABEL_ID = "label";
    private final String SUBSCENE_ID = "endGame";
    private final static int LAYOUT_Y = 150;
    private final static int LAYOUT_X = ViewManager.WIDTH + 20;

    //This for the subscene button and text
    private static int buttonLayoutX = 75;
    private static int buttonLayoutY = 250;
    private static int buttonSpacing = 50;

    private SubSceneExt subSceneOnScreen;
    protected SubSceneExt endGame;
    private static int centerX = ViewManager.WIDTH - 210;
    private final String LIVES_COLOR = "red";
    private final String SCORE_COLOR = "orange";

    private TextField field = new TextField();

    public GameView(GameController _cont, Stage _oldStage) {

        this.scoreLabel = new Label();
        this.scoreLabel.setText("Score:" + score);
        this.scoreLabel.setFont(this.FONT);
        this.scoreLabel.setTextFill(Color.web(this.SCORE_COLOR));

        Node score = scoreLabel;
        score.setId(this.LABEL_ID);

        this.livesLabel = new Label();
        this.livesLabel.setText("Lives:" + health);
        this.livesLabel.setFont(this.FONT);
        this.livesLabel.setTextFill(Color.web(this.LIVES_COLOR));
        this.livesLabel.relocate(0, 25);
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
        this.mainStage.show();
        //Create cat and mouse objects
        this.createSprites();
        this.populateEndGame();
        this.initializeTimer();

        BackgroundImage img = new BackgroundImage(new Image(GameView.BACKGROUND, 820, 800, true, true), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        this.mainPane.setBackground(new Background(img));

    }

    /**
     * This method shows the subscene.
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
     * This method replaces a collected cheese.
     *
     * @param _cheese This is the cheese to be replaced.
     */
    public void replaceCheese(Node _cheese) {
        this.score++;
        this.scoreLabel.setText("Score:" + this.score);
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
     * This method decrements the player's health after a collision.
     */
    public void enemyCollision() {
        this.health--;
        this.livesLabel.setText("lives:" + this.health);
        if (this.health == 0) {
            this.showEndGameSubscene();
            this.stopGame();
        }
    }

    /**
     * This method will show the subscene.
     */
    public void showEndGameSubscene() {
        this.showSubScene(this.endGame);
    }

    /**
     * This method will show the subscene.
     */
    public void showEndGameSuccess() {
        this.clearEndGameSubscene();
        this.successfulPost();
    }

    /**
     * This method stops all of the animations and input.
     */
    private void stopGame() {
        this.timer.stop();
        this.controller.endClaws(this.cat);
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
     * This is the game loop. Anything that needs to happen on the cycle should be put inside the "handle."
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
        _scene.setButtonLayoutX(this.buttonLayoutX);
        _scene.setButtonLayoutY(this.buttonLayoutY);
        _scene.setButtonSpacing(this.buttonSpacing);
        ButtonExt button = new ButtonExt(_text, _scene.getButtonLayoutX(), (_scene.getButtonLayoutY() + _scene.getSubAnchor().getChildren().size() * _scene.getButtonSpacing()));
        this.placeButton(button, _code, _scene.getSubAnchor());
    }


    /**
     * This method will populate buttons and textfields to the subscene.
     */
    private void populateEndGame() {
        this.endGame = new SubSceneExt(this.LAYOUT_X, this.LAYOUT_Y);
        Node endgame = this.endGame;
        endgame.setId(this.SUBSCENE_ID);
        String instruct = "Enter your name!\nWould you like your score posted to our social media?";

        this.createSubSceneButton("YES", EventCodes.YES_POST_TO_SOCIAL_MEDIA, this.endGame);
        this.createSubSceneButton("NO", EventCodes.NO_POST_TO_SOCIAL_MEDIA, this.endGame);

        this.field.setLayoutX((this.endGame.getWidth() - this.field.getWidth()) / 3.5);
        this.field.setLayoutY(this.endGame.getTextLayoutY() + 165);


        this.endGame.getSubAnchor().getChildren().add(this.createEndInstructions(instruct));
        this.endGame.getSubAnchor().getChildren().add(field);
        this.endGame.getSubAnchor().getChildren().add(this.createLabel());

        this.mainPane.getChildren().add(endgame);
    }
    /**
     * This method will post successful post.
     */
    private void successfulPost() {
        String instruct = "Your Score has been successfully posted";
        this.createSubSceneButton("Go To Menu", EventCodes.EXIT, this.endGame);

        this.endGame.getSubAnchor().getChildren().add(this.createEndInstructions(instruct));
        this.endGame.getSubAnchor().getChildren().add(field);
    }

    /**
     * This method creates the Text object for the End Game subscene.
     * @return This is the created Text object.
     */
    private Text createEndInstructions(String _instruct){
        Text instruction = new Text();
        instruction.setLayoutX(this.endGame.getTextLayoutX());
        instruction.setLayoutY(this.endGame.getTextLayoutY() + 6 * this.endGame.getTextSize());
        instruction.setWrappingWidth(this.endGame.getWidth() - 2 * this.endGame.getTextLayoutX());
        instruction.setLineSpacing(this.endGame.getTextSpacing());
        instruction.setTextAlignment(TextAlignment.CENTER);
        instruction.setText(_instruct);
        //This is for the font.
        try {
            instruction.setFont(Font.loadFont(new FileInputStream(this.FONT_PATH), this.endGame.getTextSize()));

        } catch (Exception e) {
            System.out.println(e);
        }
        return instruction;
    }

    /**
     * This method creates the "Game Over!" label for the endgame subscene.
     * @return This is the created label.
     */
    private Label createLabel() {
        String endGame = "GAME OVER!";
        Label gameOver = new Label();
        gameOver.setLayoutX(this.endGame.getTextLayoutX() + 2 * this.endGame.getTextSize());
        gameOver.setLayoutY(this.endGame.getTextLayoutY());
        gameOver.setLineSpacing(this.endGame.getTextSpacing());
        gameOver.setText(endGame);
        gameOver.setFont(this.FONT);
        gameOver.setTextFill(Color.web(this.LIVES_COLOR));
        return gameOver;
    }

    /**
     * This method will clear End Game subscene.
     */
    private void clearEndGameSubscene() {
        this.endGame.getSubAnchor().getChildren().clear();
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

    public String getUserInput() {
        String player = this.field.getText();
        return player;
    }

    public int getHealth() {
        return this.health;
    }

    public int getScore() {
        return this.score;
    }
}

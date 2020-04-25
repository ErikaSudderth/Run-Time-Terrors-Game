package CatGame.Controller;

/**
 * This class will route the calls from the Game view. Author(s): Greg Dwyer Last Updated: 3/31/20
 */
import CatGame.Events.EventCodes;
import CatGame.Models.CollisionChecker;
import CatGame.Models.Input;
import CatGame.Models.KeyboardInput;
import CatGame.Models.WriteToTxt;
import CatGame.Sprite.Cat;
import CatGame.Sprite.Mouse;
import CatGame.Sprite.Sprite;
import CatGame.ViewManagers.GameView;
import CatGame.ViewManagers.MenuView;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class GameController {
    
    private final GameView VIEW;
    private final Stage MENUSTAGE;
    private final Input INPUT;
    private final CollisionChecker COLLISION_CHECKER;

    public GameController(Stage _menuStage) {
        this.MENUSTAGE = _menuStage;
        this.VIEW = new GameView(this, MENUSTAGE);
        this.INPUT = new KeyboardInput(this);
        this.COLLISION_CHECKER = new CollisionChecker(this, this.VIEW.getMouse());

    }

    /**
     * This method tells the view to put a collected cheese item back on the board.
     * @param _cheese This is the cheese to be placed.
     */
    public void replaceCheese(Node _cheese) {
        this.VIEW.replaceCheese(_cheese);
    }
    /**
     * This method will handle the EndGame buttons action.
     * @param _code
     */
    public void handle(int _code) {
                WriteToTxt write = new WriteToTxt();
        switch (_code) {
            case EventCodes.YES_POST_TO_SOCIAL_MEDIA:
                //This is where you would handle the user input with score and api interface
                try {
                    write.writeTo(this.VIEW.getUserInput(), this.VIEW.getScore());
                } catch (IOException ex) {
                    Logger.getLogger(GameController.class.getName()).log(Level.SEVERE, null, ex);
                }
                this.VIEW.exitGame();
                break;
            case EventCodes.NO_POST_TO_SOCIAL_MEDIA:
                //This is where you would handle the user input with score
             try {
                    write.writeTo(this.VIEW.getUserInput(), this.VIEW.getScore());
                } catch (IOException ex) {
                    Logger.getLogger(GameController.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
        }
        this.exitGame();
    }

    /**
     * This method tells the view that the player has run into an enemy.
     */
    public void enemyCollsion() {
        this.VIEW.enemyCollision();
    }

    /**
     * This method gets a list of all of the pane's children and checks for collisions.
     */
    public void checkCollisions() {
        this.COLLISION_CHECKER.checkCollisionsList(this.VIEW.getMainPane().getChildren());
    }
    /**
     * This method ends the game.
     */
    public void endSubscene() {
        this.VIEW.exitGame();
        this.getViewStage().close();
        this.MENUSTAGE.show();
    }


    /**
     * This method returns the user to the main menu and closes the game stage.
     * KNOWN BUG - All of the path transitions continue to run and play sound after the stage is closed.
     */
    public void exitGame() {
        this.VIEW.exitGame();
        this.getViewStage().close();
        this.MENUSTAGE.show();
    }

    /**
     * This method calls the on the mouse class, and hands over the input device to be checked.
     * @param _mouse
     */
    public void moveMouse(Mouse _mouse) {
        _mouse.moveMouse(this.INPUT);
    }

    /**
     * This method ends the claw shooting timeline. This is called during the exit game protocol.
     * @param _cat
     */
    public void endClaws(Cat _cat) {
        _cat.endTimeline();
    }

    //================GETTERS======================
    public Scene getViewScene() {
        return this.VIEW.getMainScene();
    }

    public AnchorPane getViewPane() {
        return this.VIEW.getMainPane();
    }

    public Stage getViewStage() {
        return this.VIEW.getMainStage();
    }
}

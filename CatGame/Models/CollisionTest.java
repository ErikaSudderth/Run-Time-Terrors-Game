package CatGame.Models;

/**
 *
 * @author Latitude
 */
import CatGame.Controller.GameController;
import CatGame.Sprite.Cat;
import CatGame.Sprite.Cheese;
import CatGame.Sprite.Door;
import CatGame.Sprite.Hairball;
import CatGame.Sprite.Mouse;
import CatGame.Sprite.Projectiles;
import CatGame.Sprite.Sprite;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

public class CollisionTest {

    /**
     * This method tests the collision checker on the standard game objects.
     * @param _pane
     * @param _mouse
     * @return
     */
    public static List<Node> testNormalCases(AnchorPane _pane, Mouse _mouse) {
        System.out.println("Normal Cases: (Cheese, Cat, Hairball, Claw, Door)");
        CollisionTest.setLocationToZero(_mouse);

        Cheese cheese = new Cheese(_pane);
        CollisionTest.setLocationToZero(cheese);

        Cat cat = new Cat(_pane);
        CollisionTest.setLocationToZero(cat);
        cat.endTimeline();

        Hairball hairball = new Hairball(_pane, 1);
        CollisionTest.setLocationToZero(hairball);

        Projectiles claw = new Projectiles(_pane);
        CollisionTest.setLocationToZero(claw);

        Door door = new Door(_pane);
        CollisionTest.setLocationToZero(door);
        return _pane.getChildren();
    }

    /**
     * This method tests the collision checker on non game items that are on the screen.
     * @param _pane
     * @param _mouse
     * @return
     */
    public static List<Node> testEdgeCases(AnchorPane _pane, Mouse _mouse) {
        //test all edge cases
        System.out.println("Edge Cases: (Label, Text) No Output Expected");
        Label edgeCase = new Label();
        edgeCase.setLayoutX(0);
        edgeCase.setLayoutY(0);
        Node edgeNode = edgeCase;
        edgeNode.setId("label");
        _pane.getChildren().add(edgeNode);

        Text edgeCase2 = new Text();
        edgeCase2.setLayoutX(0);
        edgeCase2.setLayoutY(0);
        Node edge2Node = edgeCase2;
        edgeNode.setId("text");
        _pane.getChildren().add(edge2Node);

        return _pane.getChildren();
    }

    /**
     * This method tests the collision checker on an error case.
     * @param _pane
     * @param _mouse
     * @return
     */
    public static List<Node> testErrorCases(AnchorPane _pane, Mouse _mouse) {
        //test error case
        System.out.println("Error Case: (Node with no ID) Error Expected");
        Label errorCase = new Label();
        errorCase.setLayoutX(0);
        errorCase.setLayoutY(0);
        _pane.getChildren().add(errorCase);
        return _pane.getChildren();
    }

    /**
     * This method sets the parameter sprite's location to (0,0) for testing purposes.
     * @param _sprite
     */
    private static void setLocationToZero(Sprite _sprite) {
        _sprite.getImage().setLayoutX(0);
        _sprite.getImage().setLayoutY(0);
    }
}

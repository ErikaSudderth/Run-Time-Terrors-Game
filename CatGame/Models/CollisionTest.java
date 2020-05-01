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
import javafx.scene.layout.AnchorPane;

public class CollisionTest {

    public static List<Node> testNormalCases(AnchorPane _pane) {
        //test 2 normal cases
        List<Node> normalCases = new ArrayList<>();
        Mouse mouse = new Mouse(_pane);
        CollisionTest.setLocationToZero(mouse);

        Cheese cheese = new Cheese(_pane);
        CollisionTest.setLocationToZero(cheese);

        Cat cat = new Cat(_pane);
        CollisionTest.setLocationToZero(cat);

        Hairball hairball = new Hairball(_pane, 1);
        CollisionTest.setLocationToZero(hairball);

        Projectiles claw = new Projectiles(_pane);
        CollisionTest.setLocationToZero(claw);

        Door door = new Door(_pane);
        CollisionTest.setLocationToZero(door);
        return normalCases;
    }

    public static List<Node> testEdgeCases() {
        //test all edge cases
        List<Node> edgeCases = new ArrayList<>();

        return edgeCases;
    }

    public static List<Node> testErrorCases() {
        //test error case
        List<Node> errorCases = new ArrayList<>();

        return errorCases;
    }

    private static void setLocationToZero(Sprite _sprite) {
        _sprite.getImage().setLayoutX(0);
        _sprite.getImage().setLayoutY(0);
    }
}

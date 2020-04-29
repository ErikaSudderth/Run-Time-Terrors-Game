package CatGame.Models;

/**
 *
 * @author Latitude
 */

import CatGame.Controller.GameController;
import CatGame.Sprite.Cat;
import CatGame.Sprite.Cheese;
import CatGame.Sprite.Mouse;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;

public class CollisionTest {

    public static List<Node> testNormalCases(AnchorPane _pane) {
        //test 2 normal cases
        List<Node> normalCases = new ArrayList<>();
        Cheese cheese = new Cheese(_pane);
        Cat cat = new Cat(_pane);
        Claw claw = new Claw(_pane);
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
}

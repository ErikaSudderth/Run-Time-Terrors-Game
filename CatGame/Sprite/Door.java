package CatGame.Sprite;

import CatGame.ViewManagers.ViewManager;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author Latitude
 */
public class Door extends Sprite{
    private final static String IMAGE = "resources/imgs/door.png";
    private final static int DIMENSIONS = 64;
    private final int STARTING_X = (ViewManager.getWidth() / 2) - (this.DIMENSIONS / 2);
    private final int STARTING_Y = 0;
    private final String ID = "door";

    public Door(AnchorPane _pane) {
        this.spriteImage = new ImageView(this.IMAGE);
        Node doorNode = this.spriteImage;
        doorNode.setId(this.ID);
        this.spriteImage.setLayoutX(this.STARTING_X);
        _pane.getChildren().add(doorNode);
    }
}

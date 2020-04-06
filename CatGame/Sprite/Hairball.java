package CatGame.Sprite;

import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

/**
 * Hairball class that simply initializes the location and size of the stationary hairballs on scree.
 *
 * @author Erika Sudderth
 * Last updated: 3/29/20
 */
public class Hairball extends Sprite {

    private final String hairballImage = "/resources/imgs/hairball.png";
    private final AnchorPane pane;

    public Hairball(AnchorPane _pane, int _xPos, int _yPos) {
        this.pane = _pane;
        this.spriteImage = new ImageView(hairballImage);

        this.getImage().setLayoutX(_xPos);
        this.getImage().setLayoutY(_yPos);

        //this.pane.getChildren().add(this.getImage());
    }

    @Override
    public int getX() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getY() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
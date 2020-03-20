package Sprite;

/**
 * Abstract sprite class. Every movable object will have a location and a size
 * and will inherit this class.
 *
 * @author Erika Sudderth
 * Last updated: 3/19/20
 */

import javafx.scene.image.ImageView;

public class Sprite {

    protected ImageView spriteImage;

    /**
     * Constructor to initialize the location and size of any moving
     * object on screen.
     * @param _initialSpriteXValue
     * @param _initialSpriteYValue
     * @param _initialSpriteWidth
     * @param _initialSpriteHeight
     * @param _SpriteImage
     */
    public Sprite(int _initialSpriteXValue, int _initialSpriteYValue, int _initialSpriteWidth, int _initialSpriteHeight, String _SpriteImage) {
        //Initialize sprite specific image.
        this.spriteImage = new ImageView(_SpriteImage);
        //Sets image size.
        this.spriteImage.setFitHeight(_initialSpriteHeight);
        this.spriteImage.setFitWidth(_initialSpriteWidth);
        //Sets initial image location.
        this.spriteImage.setLayoutX(_initialSpriteXValue);
        this.spriteImage.setLayoutY(_initialSpriteYValue);

        //Adds the character image as a node.
        //GameplayGUI.layoutPane.getChildren().add(this.characterImage);
        //Replace this with actual pane.
    }

//=================  GETTERS ===============
    public ImageView getImage() {
        return this.spriteImage;
    }

//=================  SETTERS ===============
    public void setImage(String _imagePNG) {
        this.spriteImage = new ImageView(_imagePNG);
    }
}

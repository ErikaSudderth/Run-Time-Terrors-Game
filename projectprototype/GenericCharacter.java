package projectprototype;

/**
 * This class allows for creation of character objects, which will all have an
 * image and location coordinates. This may become a superclass.
 *
 * @author Erika
 * Last updated: 2/18/20
 */

import javafx.scene.image.ImageView;

public class GenericCharacter {

    protected ImageView characterImage;

    public GenericCharacter(int _initialCharXValue, int _initialCharYValue,
            int _initialCharWidth, int _initialCharHeight, String _charImage) {

        this.characterImage = new ImageView(_charImage);
        //Sets image size.
        this.characterImage.setFitHeight(_initialCharHeight);
        this.characterImage.setFitWidth(_initialCharWidth);
        //Sets initial image location.
        this.characterImage.setLayoutX(_initialCharXValue);
        this.characterImage.setLayoutY(_initialCharYValue);
        //Adds the character image as a node.
        GameplayGUI.layoutPane.getChildren().add(this.characterImage);
    }

//=================  GETTERS ===============
    public ImageView getImage() {
        return this.characterImage;
    }

//=================  SETTERS ===============
    public void setImage(String _imagePNG) {
        this.characterImage = new ImageView(_imagePNG);
    }
}

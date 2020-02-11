package projectprototype;

/**
 * Do we need the getters and setters if they are already a part of the
 * ImageView?
 *
 * @author Erika
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

    public ImageView getImage() {
        return this.characterImage;
    }

    public double getValueX() {
        return this.characterImage.getLayoutX();
    }

    public double getValueY() {
        return this.characterImage.getLayoutY();
    }

    public double getImageWidth() {
        return this.characterImage.getFitWidth();
    }

    public double getImageHeight() {
        return this.characterImage.getFitHeight();
    }

    public void setValueX(double xValue) {
        this.characterImage.setLayoutX(xValue);
    }

    public void setValueY(double yValue) {
        this.characterImage.setLayoutY(yValue);
    }

    public void setImageWidth(double width) {
        this.characterImage.setFitWidth(width);
    }

    public void setImageHeight(double height) {
        this.characterImage.setFitHeight(height);
    }

    public void setImage(String _imagePNG) {
        this.characterImage = new ImageView(_imagePNG);
    }
}

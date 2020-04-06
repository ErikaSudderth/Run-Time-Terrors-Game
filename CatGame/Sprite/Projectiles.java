package CatGame.Sprite;

/**
 * Projectile class (for claws) that extends the Sprite class. Calls on
 * method to rotate claws.
 *
 * @author Erika Sudderth Last updated: 3/31/20
 */

import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.scene.Group;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class Projectiles extends Sprite {

    private final String clawImage = "/resources/imgs/claw.png";
    AnchorPane pane;
    private final int rotationAngle = 360;
    private Group animationGroup;


    public Projectiles(AnchorPane _pane) {
        this.spriteImage = new ImageView(this.clawImage);
        this.pane = _pane;
        this.clawAnimation();
        this.pane.getChildren().add(this.animationGroup);
    }

    /**
     * Removes the claw animation node from pane.
     */
    public void removeClaw() {
        this.pane.getChildren().remove(this.animationGroup);
    }

    /**
     * Animates the sprite image to rotate indefinitely.
     */
    private void clawAnimation() {
        RotateTransition rotation = new RotateTransition();
        rotation.setNode(this.spriteImage);
        rotation.setByAngle(rotationAngle);
        rotation.setInterpolator(Interpolator.LINEAR);
        rotation.setCycleCount(Animation.INDEFINITE);

        this.animationGroup = new Group(this.spriteImage);
        rotation.play();
    }

//=================  GETTERS ===============
    public Group getClawGroup() {
	return this.animationGroup;
    }
}

package CatGame.Sprite;

/**
 * Projectile class (for claws) that extends the Sprite class. Claws follow cat's
 * location for placement. Contains method to rotate claws.
 *
 * @author Erika Sudderth
 * Last updated: 4/9/20
 */

import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class Projectiles extends Sprite {

    private final String CLAW_IMAGE = "/resources/imgs/claw.png";
    private AnchorPane PANE;
    private final int ROTATION_ANGLE = 360;
    private Group animationGroup;
    private final String ID = "claw";

    public Projectiles(AnchorPane _pane) {
        this.spriteImage = new ImageView(this.CLAW_IMAGE);
        this.PANE = _pane;
        this.clawAnimation();
        Node clawNode = this.animationGroup;
        clawNode.setId(this.ID);
        this.PANE.getChildren().add(this.animationGroup);
    }

    /**
     * Removes the claw animation node from pane.
     */
    public void removeClaw() {
        this.PANE.getChildren().remove(this.animationGroup);
    }

    /**
     * Animates the sprite image to rotate indefinitely.
     */
    private void clawAnimation() {
        RotateTransition rotation = new RotateTransition();
        rotation.setNode(this.spriteImage);
        rotation.setByAngle(this.ROTATION_ANGLE);
        rotation.setInterpolator(Interpolator.LINEAR);
        rotation.setCycleCount(Animation.INDEFINITE);

        this.animationGroup = new Group(this.spriteImage);
        rotation.play();
    }

//=================  GETTERS ===============
    public Group getAnimationGroup() {
        return this.animationGroup;
    }
}

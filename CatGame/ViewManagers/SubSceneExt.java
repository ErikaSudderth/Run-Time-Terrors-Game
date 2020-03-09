package CatGame.ViewManagers;

/**
 * This class handles the subscenes.
 * Author(s) - Greg
 * Last updated - 3/6/20
 */

import javafx.animation.TranslateTransition;
import javafx.scene.SubScene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.util.Duration;


public class SubSceneExt extends SubScene {

	private Boolean isHidden = true;
	private final static int PREF_HEIGHT = 200;
	private final static int PREF_WIDTH = 300;
	private final static int LAYOUT_X = ViewManager.WIDTH;
	private final static int LAYOUT_Y = 150;
	private final static String BACKGROUND = "/resources/imgs/subscene_background.png";

	public SubSceneExt() {
		super(new AnchorPane(), SubSceneExt.PREF_WIDTH, SubSceneExt.PREF_HEIGHT);
		this.setLayoutX(SubSceneExt.LAYOUT_X);
		this.setLayoutY(SubSceneExt.LAYOUT_Y);
		BackgroundImage img = new BackgroundImage(new Image(SubSceneExt.BACKGROUND, SubSceneExt.PREF_WIDTH, SubSceneExt.PREF_HEIGHT, false, true), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
		AnchorPane subAnchor = (AnchorPane) this.getRoot();
		subAnchor.setBackground(new Background(img));
	}

	public void moveSubScene() {
		TranslateTransition transition = new TranslateTransition();
		transition.setDuration(Duration.seconds(0.3));
		transition.setNode(this);

		//This block handles if a subscene is already visible or not.
		if (this.isHidden) {
			transition.setToX(-(SubSceneExt.LAYOUT_X / 2));
		} else {
			transition.setToX(SubSceneExt.LAYOUT_X / 2);
		}
		this.isHidden = !this.isHidden;
		transition.play();
	}
}

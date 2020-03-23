package CatGame.ViewManagers;

/**
 * This is the Menu View Manager Author(s) - Greg Last updated - 3/6/20
 */
import CatGame.Sprite.*;
import javafx.animation.AnimationTimer;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.stage.Stage;

public class GameView extends ViewManager {

	private static final String BACKGROUND = "/resources/imgs/background.png";
	private AnimationTimer timer;
	private static final long FPS30 = 33333333;

	public GameView(Stage _oldStage) {
		this.mainPane = new AnchorPane();
		this.mainScene = new Scene(this.mainPane, MenuView.WIDTH, MenuView.HEIGHT);
		this.mainStage = new Stage();
		this.mainStage.setScene(this.mainScene);
		this.mainStage.setTitle(this.TITLE);
		this.mainStage.setMaxHeight(this.HEIGHT);
		this.mainStage.setMaxWidth(this.WIDTH);
		this.mainStage.setMinHeight(this.HEIGHT);
		this.mainStage.setMinWidth(this.WIDTH);
		this.initializeTimer();
		_oldStage.hide();
		mainStage.show();

		createSprites();

		BackgroundImage img = new BackgroundImage(new Image(GameView.BACKGROUND, GameView.WIDTH, GameView.HEIGHT, false, true), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
		this.mainPane.setBackground(new Background(img));
	}

	private void createSprites() {
		Cat cat = new Cat(this.mainPane);
		Mouse mouse = new Mouse(this.mainPane);
	}

	private void initializeTimer() {
		this.timer = new AnimationTimer() {
			long lastUpdate = 0;
			int i = 0;

			@Override
			public void handle(long now) {
				//This if block will update every 30th of a second for animations.
				if (now - lastUpdate >= GameView.FPS30) {
					lastUpdate = now;

					i++;
				}
			}

		};
		timer.start();
	}
}

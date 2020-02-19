package gametest;

import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BackgroundImage;
import javafx.stage.Stage;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;

public class ViewManager {

	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;
	private static final int BUTTON_START_X = 300;
	private static final int BUTTON_START_Y = 200;
	private static final int BUTTON_SPACING = 100;
	private static final String BACKGROUND = "/resources/cat.png";
	private AnchorPane mainPane;
	private Scene mainScene;
	private Stage mainStage;

	public ViewManager() {
		this.mainPane = new AnchorPane();
		this.mainScene = new Scene(mainPane, WIDTH, HEIGHT);
		this.mainStage = new Stage();
		this.mainStage.setScene(mainScene);
		this.mainStage.setTitle("Space Game");
		this.mainStage.setMaxHeight(HEIGHT);
		this.mainStage.setMaxWidth(WIDTH);
		this.mainStage.setMinHeight(HEIGHT);
		this.mainStage.setMinWidth(WIDTH);
		createButtons();
		BackgroundImage img = new BackgroundImage(new Image(ViewManager.BACKGROUND, ViewManager.WIDTH, ViewManager.HEIGHT, false, true), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
		this.mainPane.setBackground(new Background(img));
	}

	public Stage getMainStage() {
		return this.mainStage;
	}

	private void createButtons() {
		ButtonExt button2 = new ButtonExt("Up", ViewManager.BUTTON_START_X, (ViewManager.BUTTON_START_Y + this.mainPane.getChildren().size() * ViewManager.BUTTON_SPACING));
		this.mainPane.getChildren().add(button2);
		button2.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				SFX.musicVolUp();
			}
		});

		ButtonExt button = new ButtonExt("Down", ViewManager.BUTTON_START_X, (ViewManager.BUTTON_START_Y + this.mainPane.getChildren().size() * ViewManager.BUTTON_SPACING));
		this.mainPane.getChildren().add(button);
		button.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				SFX.musicVolDown();
			}
		});
	}
}

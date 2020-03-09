package CatGame.ViewManagers;

/**
 * This is the Menu View Manager
 * Author(s) - Greg
 * Last updated - 3/6/20
 */

import CatGame.ButtonExt;
import java.awt.event.ActionListener;
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

public class MenuView extends ViewManager {

	protected static final int BUTTON_START_X = 100;
	protected static final int BUTTON_START_Y = 200;
	protected static final int BUTTON_SPACING = 100;
	protected static final String BACKGROUND = "/resources/imgs/cat.png";
	protected ButtonExt exitButton;
	private SubSceneExt subSceneOnScreen;

	public MenuView() {
		this.mainPane = new AnchorPane();
		this.mainScene = new Scene(this.mainPane, MenuView.WIDTH, MenuView.HEIGHT);
		this.mainStage = new Stage();
		this.mainStage.setScene(this.mainScene);
		this.mainStage.setTitle(this.TITLE);
		this.mainStage.setMaxHeight(MenuView.HEIGHT);
		this.mainStage.setMaxWidth(MenuView.WIDTH);
		this.mainStage.setMinHeight(MenuView.HEIGHT);
		this.mainStage.setMinWidth(MenuView.WIDTH);
		this.createButtons();

		BackgroundImage img = new BackgroundImage(new Image(MenuView.BACKGROUND, MenuView.WIDTH, MenuView.HEIGHT, false, true), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
		this.mainPane.setBackground(new Background(img));
	}

	public void showSubScene(SubSceneExt _subscene) {
		if(subSceneOnScreen != null){
			subSceneOnScreen.moveSubScene();
		}
		_subscene.moveSubScene();
		subSceneOnScreen = _subscene;
	}


	private void createButtons() {
		ButtonExt button = new ButtonExt("SubScene", MenuView.BUTTON_START_X, (MenuView.BUTTON_START_Y + this.mainPane.getChildren().size() * MenuView.BUTTON_SPACING));
		this.mainPane.getChildren().add(button);
		SubSceneExt test = new SubSceneExt();
		this.mainPane.getChildren().add(test);
		button.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				//test.moveSubScene();
				GameView _gameview = new GameView(mainStage);
			
			}
		});
		this.exitButton = new ButtonExt("Exit", MenuView.BUTTON_START_X, (MenuView.BUTTON_START_Y + this.mainPane.getChildren().size() * MenuView.BUTTON_SPACING));
		this.mainPane.getChildren().add(exitButton);
		this.setExitButtonBehavior();
	}

	private void setExitButtonBehavior() {
		this.exitButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
			mainStage.close();
			}
		});
	}
	//=================  GETTERS ===============
	public static int getWIDTH() {
		return MenuView.WIDTH;
	}

	public static int getHEIGHT() {
		return MenuView.HEIGHT;
	}


	public static int getBUTTON_START_X() {
		return MenuView.BUTTON_START_X;
	}

	public static int getBUTTON_START_Y() {
		return MenuView.BUTTON_START_Y;
	}

	public static int getBUTTON_SPACING() {
		return MenuView.BUTTON_SPACING;
	}

	public static String getBACKGROUND() {
		return MenuView.BACKGROUND;
	}

	public AnchorPane getMainPane() {
		return this.mainPane;
	}

	public Scene getMainScene() {
		return this.mainScene;
	}

	public Stage getMainStage() {
		return this.mainStage;
	}


}

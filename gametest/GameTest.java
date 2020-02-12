package gametest;

import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;

import javafx.stage.Stage;


public class GameTest extends Application {

	@Override
	public void start(Stage mainMenu) {

		ViewManager manager = new ViewManager();
		mainMenu = manager.getMainStage();
		mainMenu.show();
		SFX.music();
	}

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		launch();
	}

}

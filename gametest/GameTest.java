package gametest;

import javafx.application.Application;
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

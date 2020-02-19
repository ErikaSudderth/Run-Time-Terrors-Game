package gametest;

import javafx.application.Application;
import javafx.stage.Stage;

public class GameTest extends Application {

	@Override
	public void start(Stage _mainMenu) {

		ViewManager manager = new ViewManager();
		_mainMenu = manager.getMainStage();
		_mainMenu.show();
		SFX.music();
	}

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		launch();
	}

}

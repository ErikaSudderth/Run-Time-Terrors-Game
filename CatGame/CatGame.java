package CatGame;

/**
 * This is the main method for the game. It calls the method to start the Menu view.
 * Author(s) - Greg
 * Last updated - 3/6/20
 */

import CatGame.ViewManagers.MenuView;
import javafx.application.Application;
import javafx.stage.Stage;

public class CatGame extends Application {

	@Override
	public void start(Stage _mainMenu) {

		MenuView manager = new MenuView();
		_mainMenu = manager.getMainStage();
		_mainMenu.show();
		//SFX.music();
	}

	public static void main(String[] args) {
		launch();
	}

}
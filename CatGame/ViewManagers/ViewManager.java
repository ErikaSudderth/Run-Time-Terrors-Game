package CatGame.ViewManagers;

/**
 * This class handles the subscenes.
 * Author(s) - Greg
 * Last updated - 3/6/20
 */

import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public abstract class ViewManager {
	static final int WIDTH = 800;
	static final int HEIGHT = 600;
	AnchorPane mainPane;
	Scene mainScene;
	Stage mainStage;

	public ViewManager() {

	}
}

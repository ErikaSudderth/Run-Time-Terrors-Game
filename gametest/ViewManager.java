package gametest;

import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BackgroundImage;
import javafx.stage.Stage;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;


public class ViewManager {

	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;
	private AnchorPane mainPane;
	private Scene mainScene;
	private Stage mainStage;

	public ViewManager(){
		mainPane = new AnchorPane();
		mainScene = new Scene(mainPane, WIDTH, HEIGHT );
		mainStage = new Stage();
		mainStage.setScene(mainScene);
		mainStage.setTitle("Space Game");
		mainStage.setMaxHeight(HEIGHT);
		mainStage.setMaxWidth(WIDTH);
		mainStage.setMinHeight(HEIGHT);
		mainStage.setMinWidth(WIDTH);
		createButtons();
		BackgroundImage img = new BackgroundImage(new Image("/resources/cat.png", 800, 600, false, true), BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
          BackgroundSize.DEFAULT);
		mainPane.setBackground(new Background(img));
	}

	public Stage getMainStage(){
		return mainStage;
	}

	private void createButtons(){
		ButtonExt button = new ButtonExt("Down", 300, 300);
		mainPane.getChildren().add(button);
		button.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				SFX.musicVolDown();
			}
		});
		ButtonExt button2 = new ButtonExt("Up", 300, 200, 18);
		mainPane.getChildren().add(button2);
		button2.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				SFX.musicVolUp();
			}
		});
//		button.setLayoutX(300);
//		button.setLayoutY(300);
//		button.setOnMouseEntered(new EventHandler<Event>(){
//			@Override
//			public void handle(Event event){
//				System.out.println("Mouse Entered");
//			}
//		});
	}
}

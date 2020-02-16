package gametest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;

public class ButtonExt extends Button {

	private final String FONT_PATH = "src/resources/C64_Pro_Mono-STYLE.ttf";
	private final String BACKGROUND_COLOR = "-fx-background-color: transparent";
	private final String BUTTON_PRESSED_STYLE = BACKGROUND_COLOR + "; -fx-background-image: url('/resources/button_pressed.png')";
	private final String BUTTON_FREE_STYLE = BACKGROUND_COLOR + "; -fx-background-image: url('/resources/button.png')";

	public ButtonExt(String _text, int _x, int _y) {
		this.setText(_text);
		this.setId(_text);
		this.setButtonFont(20);
		this.setPrefWidth(200);
		this.setPrefHeight(40);
		this.setStyle(BUTTON_FREE_STYLE);
		this.initializeButtonListeners();
		this.setLayoutX(_x);
		this.setLayoutY(_y);
	}

	public ButtonExt(String _text, int _x, int _y, int _font_size){
		this.setText(_text);
		this.setId(_text);
		this.setButtonFont(_font_size);
		this.setPrefWidth(200);
		this.setPrefHeight(40);
		this.setStyle(BUTTON_FREE_STYLE);
		this.initializeButtonListeners();
		this.setLayoutX(_x);
		this.setLayoutY(_y);
	}

	private void setButtonFont(int _size) {
		try {
			this.setFont(Font.loadFont(new FileInputStream(FONT_PATH), _size));
		} catch (FileNotFoundException e) {
			this.setFont(Font.font("Verdana", 15));
			System.out.println("Whoopsie." + e);
		}

	}

	private void setButtonPressedStyle() {
		this.setStyle(BUTTON_PRESSED_STYLE);
		//setPrefHeight(35);
		//setLayoutY(getLayoutY() + 4);
	}

	private void setButtonReleasedStyle() {
		this.setStyle(BUTTON_FREE_STYLE);
		//setPrefHeight(35);
		//setLayoutY(getLayoutY() - 4);
	}

	private void initializeButtonListeners() {
		setOnMousePressed(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				if (event.getButton().equals(MouseButton.PRIMARY)) {
					setButtonPressedStyle();
					SFX.playClick();
				}
			}
		});

		setOnMouseReleased(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				if (event.getButton().equals(MouseButton.PRIMARY)) {
					setButtonReleasedStyle();
					Button source = (Button) event.getSource();
					String sourceButt = source.getText();
					System.out.println(sourceButt);
					ButtonController.buttonDecoder(sourceButt);
					SFX.playRelease();
				}
			}
		});

		setOnMouseEntered(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				setEffect(new DropShadow());
			}
		});

		setOnMouseExited(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				setEffect(null);
			}
		});
	}
}

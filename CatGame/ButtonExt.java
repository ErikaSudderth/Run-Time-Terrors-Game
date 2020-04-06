package CatGame;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;

public class ButtonExt extends Button {

    private final static String FONT_PATH = "src/resources/C64_Pro_Mono-STYLE.ttf";
    private final static String BACKGROUND_COLOR = "-fx-background-color: transparent";
    private final static String BUTTON_PRESSED_STYLE = BACKGROUND_COLOR + "; -fx-background-image: url('/resources/imgs/button_pressed.png')";
    private final static String BUTTON_FREE_STYLE = BACKGROUND_COLOR + "; -fx-background-image: url('/resources/imgs/button.png')";
    private final static int PREF_WIDTH = 200;
    private final static int PREF_HEIGHT = 40;
    private final static int DEFAULT_FONT_SIZE = 15;

    public ButtonExt(String _text, int _x, int _y) {
        this.setText(_text);
        this.setId(_text);
        this.setButtonFont(ButtonExt.DEFAULT_FONT_SIZE);
        this.setPrefWidth(ButtonExt.PREF_WIDTH);
        this.setPrefHeight(ButtonExt.PREF_HEIGHT);
        this.setStyle(ButtonExt.BUTTON_FREE_STYLE);
        this.initializeButtonListeners();
        this.setLayoutX(_x);
        this.setLayoutY(_y);
    }

    public ButtonExt(String _text, int _x, int _y, int _font_size) {
        this.setText(_text);
        this.setId(_text);
        this.setButtonFont(_font_size);
        this.setPrefWidth(200);
        this.setPrefHeight(40);
        this.setStyle(ButtonExt.BUTTON_FREE_STYLE);
        this.initializeButtonListeners();
        this.setLayoutX(_x);
        this.setLayoutY(_y);
    }

    private void setButtonFont(int _size) {
        try {
            this.setFont(Font.loadFont(new FileInputStream(ButtonExt.FONT_PATH), _size));
        } catch (FileNotFoundException e) {
            this.setFont(Font.font("Verdana", _size));
            System.out.println("Whoopsie." + e);
        }

    }

    private void setButtonPressedStyle() {
        this.setStyle(ButtonExt.BUTTON_PRESSED_STYLE);
    }

    private void setButtonReleasedStyle() {
        this.setStyle(ButtonExt.BUTTON_FREE_STYLE);
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

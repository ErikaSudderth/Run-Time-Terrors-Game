package CatGame.ViewManagers;

import CatGame.Models.SFX;
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

    /**
     * This constructor creates an Extended Button
     *
     * @param _text This is the text for the button.
     * @param _x This is the X position value.
     * @param _y This is the Y position value.
     */
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

    /**
     * This constructor creates an Extended Button
     *
     * @param _text This is the text for the button.
     * @param _x This is the X position value.
     * @param _y This is the Y position value.
     * @param _font_size This is the font size.
     */
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

    /**
     * Use this method to change the font size of the button's text. If this method cannot find the font specified in the class, it will default to Veranda.
     *
     * @param _size This is the font size to be used.
     */
    private void setButtonFont(int _size) {
        try {
            this.setFont(Font.loadFont(new FileInputStream(ButtonExt.FONT_PATH), _size));
        } catch (FileNotFoundException e) {
            this.setFont(Font.font("Verdana", _size));
            System.out.println("Whoopsie." + e);
        }

    }

    /**
     * Use this to set the button to the pre defined pressed style.
     */
    private void setButtonPressedStyle() {
        this.setStyle(ButtonExt.BUTTON_PRESSED_STYLE);
    }

    /**
     * Use this to set the button to the pre defined released style.
     */
    private void setButtonReleasedStyle() {
        this.setStyle(ButtonExt.BUTTON_FREE_STYLE);
    }

    /**
     * This method sets the button styles and sounds for the clicks.
     */
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

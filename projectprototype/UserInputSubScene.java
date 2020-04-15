package projectprototype;


/**
 * The purpose of this file is so the users can input their name
 *
 *
 * Author Hasler, anthony Last updated: 3/9/20
 *
 */
import CatGame.Models.WriteToTxt;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class UserInputSubScene extends Application {


    // launch the application
    public void start(Stage s) {

        // set title for the stage
        s.setTitle("textfield");
        TextField field = new TextField();
        WriteToTxt write = new WriteToTxt();

        TilePane pane = new TilePane();
        Label l = new Label("Enter name");

        // action event
        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                l.setText(field.getText());
                String player = field.getText();
                
                try {
                    write.writeTo(player,score);
                } catch (IOException ex) {
                    Logger.getLogger(UserInputSubScene.class.getName()).log(Level.SEVERE, null, ex);
                }
                s.close();
            }
        };

        // when pressing enter
        field.setOnAction(event);

        // textfield
        pane.getChildren().add(l);
        pane.getChildren().add(field);


        Scene scn = new Scene(pane, 400, 400);

        s.setScene(scn);

        s.show();
    }

    public static void main(String[] args) throws IOException {
        launch(args);

    }
}

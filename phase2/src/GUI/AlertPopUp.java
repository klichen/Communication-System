package GUI;

import javafx.scene.*;
import javafx.stage.*;
import javafx.geometry.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class AlertPopUp implements AlertInterface{

    public void display(String title, String message){
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(250);
        window.setMinHeight(150);

        Label errorMessage = new Label(message);
        Button exitButton = new Button("Close");

        exitButton.setOnAction(e-> window.close());
        VBox layout = new VBox(10);
        layout.getChildren().addAll(errorMessage, exitButton);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout, 250, 150);
        window.setScene(scene);
        window.show();
    }
}

package GUI;

import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.*;
import javafx.geometry.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class SingleMessageScreen{

    public void display(String title, String msg) {
        Stage window = new Stage();

        window.setTitle(title);
        window.setMinWidth(400);
        window.setMinHeight(300);

        Label message = new Label(msg);
        Button exitButton = new Button("Close");

        exitButton.setOnAction(e-> window.close());
        VBox layout = new VBox(10);
        layout.getChildren().addAll(message, exitButton);
        layout.setAlignment(Pos.CENTER);

        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(layout);
        scrollPane.setFitToWidth(true);

        Scene scene = new Scene(scrollPane, 400, 300);
        window.setScene(scene);
        window.show();
    }
}

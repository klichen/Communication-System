package GUI;

import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.*;
import javafx.geometry.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import ControllerLayer.ReadMessageScreen;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;

import java.util.List;

public class SendMessagesScreen implements SendMessagesInterface{
    private String message;
    private String receiver;

    @Override
    public void display(List<String> names) {
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Send a Message");
        window.setMinWidth(300);
        window.setMinHeight(500);

        Label message = new Label("Choose a contact to send to:");


        VBox layout = new VBox(10);
        layout.getChildren().add(message);
        layout.setAlignment(Pos.CENTER);
        for(String name:names){
            Button nameButton = new Button(name);
            layout.getChildren().add(nameButton);
            nameButton.setOnAction(e -> {
                AlertPopUpLargeInput inputScreen = new AlertPopUpLargeInput();
                inputScreen.display("Send Message", "Enter your message:");
                this.message = inputScreen.getInput();
                Button button = (Button) e.getSource();
                receiver = button.getText();
                window.close();
            });
        }
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(layout);
        scrollPane.setFitToWidth(true);

        Scene scene = new Scene(scrollPane, 300, 500);
        window.setScene(scene);
        window.showAndWait();
    }

    public String getMessage(){
        return message;
    }

    public String getReceiver(){
        return receiver;
    }
}

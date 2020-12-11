package GUI;

import ControllerLayer.GUIControllers.SingleMessageScreenController;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.*;
import javafx.geometry.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class SingleMessageScreen{
    private final SingleMessageScreenController controller = new SingleMessageScreenController();

    public void display(String title, String msg) {
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(400);
        window.setMinHeight(300);

        Label message = new Label(msg);
        Button exitButton = new Button("Close");
        Button unreadButton = new Button("Mark as unread");
        Button deleteMessageButton = new Button("Delete Message");
        Button archiveMessageButton = new Button("Archive Message");

        archiveMessageButton.setOnAction(e -> {
            controller.setArchive(true);
            AlertPopUp alert2 = new AlertPopUp();
            alert2.display("Alert", "Message archived.\nExit view message window to see changes.");
            window.close();
        });
        deleteMessageButton.setOnAction(e -> {
            AlertPopUpInput alert = new AlertPopUpInput();
            alert.display("Confirmation", "Are you sure? Enter Yes/No.");
            if(alert.getInput().equals("Yes")){
                controller.setDelete(true);
                AlertPopUp alert2 = new AlertPopUp();
                alert2.display("Alert", "Message deleted.\nExit view message window to see changes.");
                window.close();
            }
            else if(alert.getInput().equals("No")){
                controller.setDelete(false);
            }
            else{
                alert.display("Confirmation", "Invalid input. Enter Yes/No.");
            }
        });
        unreadButton.setOnAction(e-> {
            AlertPopUp alert2 = new AlertPopUp();
            alert2.display("Alert", "Message marked as unread.\nExit view message window to see changes.");
            controller.setRead(false);
            window.close();
        });
        exitButton.setOnAction(e-> window.close());

        HBox buttonLayout = new HBox(8);
        buttonLayout.getChildren().addAll(unreadButton, deleteMessageButton, archiveMessageButton, exitButton);
        buttonLayout.setAlignment(Pos.CENTER);

        VBox layout = new VBox(10);
        layout.getChildren().addAll(message, buttonLayout);
        layout.setAlignment(Pos.CENTER);
        layout.setFillWidth(true);

        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(layout);
        scrollPane.setFitToWidth(true);

        Scene scene = new Scene(scrollPane, 400, 300);
        window.setScene(scene);
        window.showAndWait();
    }
    public SingleMessageScreenController getController(){
        return controller;
    }
}

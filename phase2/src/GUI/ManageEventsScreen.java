package GUI;

import ControllerLayer.GUIControllers.ManageEventController;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.List;

public class ManageEventsScreen implements ManageEventsInterface{
    private final ManageEventController controller = new ManageEventController();

    @Override
    public void display(List<String> eventIDs) {
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("My Messages");
        window.setMinWidth(300);
        window.setMinHeight(500);

        Label message = new Label("Here are the current events.\nClick an event to Delete.");


        VBox layout = new VBox(10);
        layout.getChildren().add(message);
        layout.setAlignment(Pos.CENTER);
        int i = 0;
        for(String id:eventIDs){
            Button nameButton = new Button(id);
            layout.getChildren().add(nameButton);
            nameButton.setOnAction(e -> {
                AlertPopUpInput alert = new AlertPopUpInput();
                alert.display("Confirmation", "Are you sure you want to delete?\n" +
                        "\"Yes\" or \"No\".");
                if(alert.getInput() != null) {
                    if (alert.getInput().equals("Yes")) {
                        controller.setCancelEvent(true);
                        controller.setId(id);
                    }
                }
                window.close();
            });
            i++;
        }

        Button addEventButton = new Button("Add Event");

        addEventButton.setOnAction(e -> {
            AlertPopUpInput alert = new AlertPopUpInput();
            AlertPopUp alert2 = new AlertPopUp();
            boolean valid = true;
            alert.display("Creating Event", "Enter Room (String)");
            controller.setRoomNum(alert.getInput());

            alert.display("Creating Event", "Enter Room ID (String)");
            controller.setId(alert.getInput());

            boolean firstLoop = true;
            while(!valid || firstLoop) {
                firstLoop = false;
                alert.display("Creating Event", "Enter time (Integer)");
                try {
                    valid = true;
                    int input = Integer.parseInt(alert.getInput());
                } catch (NumberFormatException exception) {
                    alert2.display("Error", "Enter an Integer.");
                    valid = false;
                }
            }

            firstLoop = true;
            while(!valid || firstLoop) {
                firstLoop = false;
                controller.setTime(Integer.parseInt(alert.getInput()));
                alert.display("Creating Event", "Enter the speakers.\nSeparate each speaker with a \", \".");
                controller.setListSpeakerUsername(alert.getInput());

                alert.display("Creating Event", "Is this event VIP exclusive? Enter \"Yes\" or \"No\".");
                if (alert.getInput().equals("Yes")) {
                    controller.setVip(true);
                    valid = true;
                } else if (alert.getInput().equals("No")) {
                    controller.setVip(false);
                    valid = true;
                } else {
                    alert2.display("Error", "Invalid input. Try again.");
                    valid = false;
                }
            }

            firstLoop = true;
            while(!valid || firstLoop) {
                firstLoop = false;
                alert.display("Creating Event", "Enter the duration (Integer)");
                try {
                    valid = true;
                    int input = Integer.parseInt(alert.getInput());
                } catch (NumberFormatException exception) {
                    alert2.display("Error", "Enter an Integer.");
                    valid = false;
                }
            }
            controller.setDuration(Integer.parseInt(alert.getInput()));

            firstLoop = true;
            while(!valid || firstLoop) {
                firstLoop = false;
                alert.display("Creating Event", "Enter room capacity (Integer)");
                try {
                    valid = true;
                    int input = Integer.parseInt(alert.getInput());
                } catch (NumberFormatException exception) {
                    alert2.display("Error", "Enter an Integer.");
                    valid = false;
                }
            }
            controller.setCapacity(Integer.parseInt(alert.getInput()));
            controller.setAddEvent(true);
            window.close();

        });
        Button downloadEventsButton = new Button("Get All Events");
        downloadEventsButton.setOnAction(e -> {
            controller.setDownloadEvent(true);
            window.close();
        });
        layout.getChildren().add(addEventButton);

        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(layout);
        scrollPane.setFitToWidth(true);

        Scene scene = new Scene(scrollPane, 300, 500);
        window.setScene(scene);
        window.showAndWait();
    }
    public ManageEventController getController(){
        return controller;
    }
}

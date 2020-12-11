package GUI;

import javafx.scene.*;
import javafx.scene.input.KeyCode;
import javafx.stage.*;
import javafx.geometry.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class AlertPopUpInput implements AlertInputInterface{
    private String inputValue;

    public void display(String title, String message){
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(300);
        window.setMinHeight(150);

        Label msg = new Label(message);
        Button exitButton = new Button("Close");
        TextField input = new TextField();
        input.setPromptText("Enter here");

        input.setOnKeyReleased(e ->{
            if(e.getCode().equals(KeyCode.ENTER)) {
                inputValue = input.getText();
                window.close();
            }
        });
        exitButton.setOnAction(e-> window.close());
        VBox layout = new VBox(10);
        layout.getChildren().addAll(msg, input, exitButton);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout, 350, 150);
        window.setScene(scene);
        window.showAndWait();
    }

    public String getInput(){
        return inputValue;
    }
}

package GUI;

import javafx.scene.*;
import javafx.scene.input.KeyCode;
import javafx.stage.*;
import javafx.geometry.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class AlertPopUpLargeInput implements AlertInputInterface{
    private String inputValue;

    public void display(String title, String message){
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(300);
        window.setMinHeight(150);

        Label msg = new Label(message);
        Button exitButton = new Button("Close");
        TextArea input = new TextArea();
        input.setPromptText("Enter here");

        input.setOnKeyReleased(e ->{
            if(e.getCode() == KeyCode.ENTER){
                inputValue = input.getText();
                window.close();
            }
            else if(e.getCode() == KeyCode.TAB){
                String newLine = "\n";
                input.appendText(newLine);
            }
        });
        exitButton.setOnAction(e-> window.close());
        VBox layout = new VBox(10);
        layout.getChildren().addAll(msg, input, exitButton);
        layout.setAlignment(Pos.CENTER);
        layout.setFillWidth(true);

        Scene scene = new Scene(layout, 250, 150);
        window.setScene(scene);
        window.showAndWait();
    }

    public String getInput(){
        return inputValue;
    }
}

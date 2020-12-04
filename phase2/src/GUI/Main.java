package GUI;

import ControllerLayer.MainPresenter;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        MainPresenter mainPresenter = new MainPresenter();
        Parent root = FXMLLoader.load(getClass().getResource("GUI.fxml"));
        primaryStage.setTitle("Event Manager");
        primaryStage.setScene(new Scene(root));
        primaryStage.setResizable(false);
        primaryStage.show();
        primaryStage.setOnCloseRequest(e -> {
            try {
                mainPresenter.closeProgram(primaryStage);
            } catch (IOException ioException) {
                System.out.println("Pop up fxml not available.");
            }
        });
    }


    public static void main(String[] args) {
        launch(args);
    }
}

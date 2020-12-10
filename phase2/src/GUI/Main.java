package GUI;

import ControllerLayer.AttendeeMainScreen;
import ControllerLayer.MainPresenter;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application{
    private Scene mainScene;

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GUI.fxml"));
        Parent root = fxmlLoader.load();
        MainPresenter mainPresenter = fxmlLoader.getController();
        mainScene = new Scene(root);
        mainPresenter.setMainScene(mainScene);
        primaryStage.setTitle("Event Manager");
        primaryStage.setScene(mainScene);
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

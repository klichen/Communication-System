package Backup;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.geometry.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;

import java.io.IOException;

public class Main extends Application implements ViewInterface{
    private final MainPresenter mainPresenter = new MainPresenter(this);
    private Stage window;
    private Scene mainScreen;

    public Main() throws IOException {
    }

    public Stage getWindow(){
        return this.window;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("../GUI/GUI.fxml"));
        primaryStage.setTitle("Event Manager");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
        //window = primaryStage;
        //window.setTitle("Event Manager");
        //window.setOnCloseRequest(e -> {
            //try {
                //closeWindow();
            //} catch (IOException ioException) {
                //AlertPopUp alert = new AlertPopUp();
                //alert.display("Exit Warning", "Failed to save!");
            //}
        //});
        //Button logInButton = new Button("Log In");
        //Button exitButton = new Button("Exit");
        //logInButton.setOnAction(e);

        //mainPresenter.readButtonInput(logInButton, logInHandler);
        //mainPresenter.readButtonInput(exitButton, exitHandler);

        //VBox buttonLayout = new VBox(10);
        //buttonLayout.getChildren().addAll(logInButton, exitButton);
        //buttonLayout.setAlignment(Pos.CENTER);
        //mainScreen = new Scene(buttonLayout, 400, 250);
        //window.setScene(mainScreen);
        //window.show();

    }

    public void closeWindow() throws IOException {
        mainPresenter.save();
        window.close();
    }

    public Scene logInScreen(){
        Label instruction = new Label("Enter your username and password.");
        Label usernameLabel = new Label("Username:");
        Label passwordLabel = new Label("Password:");

        TextField passwordInput = new TextField();
        passwordInput.setPromptText("Password");
        TextField usernameInput = new TextField();
        usernameInput.setPromptText("Username");

        Button signInButton = new Button("Sign in");
        Button backButton = new Button("Back");

        HBox buttonLayout = new HBox(10);
        buttonLayout.getChildren().addAll(signInButton, backButton);
        buttonLayout.setAlignment(Pos.CENTER);

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.getChildren().addAll(instruction, usernameLabel, passwordLabel, usernameInput, passwordInput);
        GridPane.setConstraints(instruction, 0, 0);
        GridPane.setConstraints(usernameLabel, 0, 1);
        GridPane.setConstraints(passwordLabel, 0, 2);
        GridPane.setConstraints(usernameInput, 1, 1);
        GridPane.setConstraints(passwordInput, 1, 2);

        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(grid);
        borderPane.setBottom(buttonLayout);
        borderPane.setPadding(new Insets(10, 10, 10, 10));

        return new Scene(borderPane);

    }

    public static void main(String[] args) {
        launch(args);
    }

}

package ControllerLayer;

import GUI.AlertInterface;
import GUI.AlertPopUp;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;
import java.util.Map;


public class MainPresenter {
    @FXML
    private Button exitButton;
    @FXML
    private TextField usernameInput;
    @FXML
    private TextField passwordInput;
    private final LoginType loginType = new LoginType();

    @FXML
    private Button logInButton;

    private Scene mainScene;

    public MainPresenter() throws IOException {
    }


    public void clickedLogInButton() throws IOException {
        usernameInput.setText("");
        passwordInput.setText("");
        loginType.setMainScene(mainScene);
        List<Object> newMap = loginType.checkLogin();

        if(newMap == null){
            AlertInterface alertPopUp = new AlertPopUp();
            alertPopUp.display("Log in Error", "Incorrect password/username.");
        }
        else{
            Scene newScene = (Scene) newMap.get(0);
            MainScreen presenter = (MainScreen) newMap.get(1);
            Stage stage = (Stage) logInButton.getScene().getWindow();
            presenter.getWelcomeText().setText("Welcome " + loginType.getUsername());
            stage.setScene(newScene);
        }
    }

    public void clickedExitButton() throws IOException {
        Stage stage = (Stage) exitButton.getScene().getWindow();
        closeProgram(stage);
    }

    public void closeProgram(Stage stage) throws IOException {
        try {
            loginType.save();
        } catch (IOException ioException) {
            AlertInterface alertPopUp = new AlertPopUp();
            alertPopUp.display("Error", "Failed to save.");
        }
        stage.close();
    }

    public void setUsername() {
        loginType.setUsername(usernameInput.getText());
    }

    public void setPassword() {
        loginType.setPassword(passwordInput.getText());
    }

    public void setMainScene(Scene mainScene){
        this.mainScene = mainScene;
    }
}

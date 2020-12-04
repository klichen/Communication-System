package ControllerLayer;

import GUI.AlertPopUp;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;


public class MainPresenter {
    @FXML
    private Button closeButton;
    @FXML
    private Button exitButton;
    @FXML
    private TextField usernameInput;
    @FXML
    private TextField passwordInput;
    private final LoginType loginType = new LoginType();

    @FXML
    private Button logInButton;

    public MainPresenter() throws IOException {
    }


    public void clickedLogInButton() throws IOException {
        boolean valid = loginType.checkLogin();
        if(!valid){
            AlertPopUp alertPopUp = new AlertPopUp();
            alertPopUp.display("Log in Error", "Incorrect password/username.");

        }
    }

    public void clickedExitButton() throws IOException {
        Stage stage = (Stage) exitButton.getScene().getWindow();
        closeProgram(stage);
    }

    public void closeProgram(Stage stage) throws IOException {
        try {
            loginType.save();
            System.out.println("Saved!");
        } catch (IOException ioException) {
            AlertPopUp alertPopUp = new AlertPopUp();
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

    public void clickedCloseButton(){
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }
}

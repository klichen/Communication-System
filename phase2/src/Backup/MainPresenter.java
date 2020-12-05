package Backup;

import java.io.IOException;

import ControllerLayer.LoginType;
import javafx.scene.control.*;
import javafx.stage.Stage;


public class MainPresenter{
    public Button logInbutton;
    private LoginType loginType;

    public MainPresenter() throws IOException {
        loginType = new LoginType();
    }

    public void save() throws IOException {
        loginType.save();
    }


    public void clickedLogInButton(){
        System.out.println("hey");
        logInbutton.setText("yeah!");
    }

    public void closeScreen(Stage window){

    }
}

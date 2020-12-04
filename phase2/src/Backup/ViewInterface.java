package Backup;

import ControllerLayer.*;
import javafx.application.Application;
import javafx.event.Event;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.geometry.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public interface ViewInterface {
    Stage getWindow();

    Scene logInScreen();
}

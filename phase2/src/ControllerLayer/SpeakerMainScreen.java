package ControllerLayer;

import GUI.AlertInterface;
import GUI.AlertPopUp;
import UseCases.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SpeakerMainScreen implements MainScreen {
    @FXML
    private Button logOutButton;
    @FXML
    private Text welcomeText;
    private Scene mainScene;
    String username;
    SpeakerSystem ss;
    SpeakerManager sm;
    EventScheduler es;
    SpeakerMessageScreen sms;
    AttendeeManager am;
    OrganizerManager om;
    VipManager vm;
    EventsToHtml eth;

    /**
     * Create a ControllerLayer.SpeakerMainScreen object and sets its variables username, am, es, om, and sm to the ones passed in
     * the constructor.
     *
     * @param username String representing a Entities.Person's username.
     * @param am UseCases.AttendeeManager object
     * @param es UseCases.EventScheduler object
     * @param om UseCases.OrganizerManager object
     * @param sm UseCases.SpeakerManager object
     * @param vm UseCases.VipManager object
     */
    public SpeakerMainScreen(String username, AttendeeManager am, EventScheduler es, OrganizerManager om,
                             SpeakerManager sm, VipManager vm, EventsToHtml eth) {
        setInstances(username, am, es, om, sm, vm, eth);
    }
    public void setInstances(String username, AttendeeManager am, EventScheduler es, OrganizerManager om,
                             SpeakerManager sm, VipManager vm, EventsToHtml eth){
        this.ss = new SpeakerSystem(sm);
        this.username = username;
        this.sm = sm;
        this.es = es;
        this.am = am;
        this.om = om;
        this.vm = vm;
        this.eth = eth;
    }
    public SpeakerMainScreen(){}
    /**
     * Prints the available actions to the screen, and takes in inputs accordingly.
     */
    public void run() {
        System.out.println("Hello " + username + ".");
        System.out.println("The list of talks you are giving is:");
        List<String> schedule = ss.getSchedule(username);
        for (String i : schedule) {
            System.out.println(i);
        }
        boolean logout = false;
        while (!logout) {
            System.out.println("To do an action, please press the corresponding number:");
            System.out.println("1 - Message");
            System.out.println("2 - Log out");
            System.out.println("3 - Save Full Schedule (HTML)");
            String response = ss.readString();
            if (response.equals("1")) {
                sms = new SpeakerMessageScreen(am, om, sm, vm, username);
                this.sms.run();
            }
            else if (response.equals("2")) {
                logout = true;
            }
            else if (response.equals("3")){
                eth.saveToHtml(es);
            }
        }
    }

    public void viewMessages() {
        ReadMessageScreen messageScreen = new ReadMessageScreen(am, om, sm, vm, username);
        messageScreen.showMessages();

    }

    public void viewTalks() {
        SpeakerMessageScreen messageScreen = new SpeakerMessageScreen(am, om, sm, vm, username);
        messageScreen.sendMessage();
    }

    public void logOut() {
        Stage stage = (Stage) logOutButton.getScene().getWindow();
        stage.setScene(mainScene);
    }

    @Override
    public List<Object> openMainScreen() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/GUI/SpeakerScreen.fxml"));
        Parent root = fxmlLoader.load();
        SpeakerMainScreen myPresenter = fxmlLoader.getController();
        myPresenter.setInstances(username, am, es, om, sm, vm ,eth);
        myPresenter.setMainScene(mainScene);
        List<Object> map = new ArrayList<>();
        map.add(new Scene(root));
        map.add(myPresenter);
        return map;
    }
    public void setMainScene(Scene mainScene){
        this.mainScene = mainScene;
    }


    @Override
    public Text getWelcomeText() {
        return welcomeText;
    }

    public void getAllEvents() {
        eth.saveToHtml(es);
        AlertInterface alert = new AlertPopUp();
        alert.display("Downloaded", "Events saved as HTML file.");
    }
}
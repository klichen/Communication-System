package ControllerLayer;

import GUI.*;
import UseCases.*;
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

public class VipMainScreen implements MainScreen{
    @FXML
    private Button viewEventsButton;
    @FXML
    private Text welcomeText;
    @FXML
    private Button logOutButton;
    private Scene mainScene;
    VipSystem vs;
    String username;
    AttendeeManager am;
    EventScheduler es;
    OrganizerManager om;
    SpeakerManager sm;
    VipManager vm;
    EventsToHtml eth;

    /**
     * Constructor for the presenter showing all of the Actions VIP can do
     * @param username The username of the VIP as a String
     * @param am Instance of UseCases.AttendeeManager with loaded information
     * @param es Instance of UseCases.EventScheduler with loaded information
     * @param om Instance of UseCases.OrganizerManager with loaded information
     * @param sm Instance of UseCases.SpeakerManager with loaded information
     * @param vm Instance of UseCases.VipManager with loaded information
     */
    public VipMainScreen(String username, AttendeeManager am, EventScheduler es, OrganizerManager om,
                              SpeakerManager sm, VipManager vm, EventsToHtml eth){
        setInstances(username, am, es, om, sm, vm, eth);
    }

    private void setInstances(String username, AttendeeManager am, EventScheduler es, OrganizerManager om,
                              SpeakerManager sm, VipManager vm, EventsToHtml eth) {
        this.vs = new VipSystem(am, es, om, sm, vm);
        this.username = username;
        this.am = am;
        this.es = es;
        this.om = om;
        this.sm = sm;
        this.vm = vm;
        this.eth = eth;
    }
    public VipMainScreen(){}

    /**
     * Prints the texts for the VIP to see, and takes in inputs accordingly.
     */
    public void run() {
        boolean logOut = false;
        while (!logOut) {

            System.out.println("Hello " + username + ".");
            System.out.println("To do an action, please press the corresponding number:");
            System.out.println("1 - View your Schedule");
            System.out.println("2 - Register for an event");
            System.out.println("3 - Cancel your registration in an event");
            System.out.println("4 - Add a contact to your contact list");
            System.out.println("5 - Send a message to a contact");
            System.out.println("6 - View previous messages");
            System.out.println("7 - Save Full Schedule (HTML)");
            System.out.println("8 - Log out");

            String response = vs.readString();

            // returns schedule of user
            switch (response) {
                case "1":
                    System.out.println(this.vs.getScheduleIds(username));

                    break;
                // if applicable adds an event to the users schedule, otherwise tells them they cannot
                case "2": {
                    System.out.println("Please enter the id of the event you would like to register for: ");
                    String eventID = this.vs.readString();

                    // adds the event
                    if (this.vs.canAddEvent(username, eventID)) {
                        this.vs.addEvent(username, eventID);
                        System.out.println("You have successfully registered for event " + eventID);
                    }
                    // tells them event cannot be added
                    else {
                        System.out.println("Sorry this action cannot be done.");
                    }

                    break;
                }
                // if applicable removes an event from the users schedule, otherwise tells them they cannot
                case "3": {
                    System.out.println("Please enter the id of the event you would like to unregister for: ");
                    String eventID = this.vs.readString();

                    // cancels the event
                    if (this.vs.canCancelEnrollment(username, eventID)) {
                        this.vs.cancelEnrollment(username, eventID);
                        System.out.println("You have successfully cancelled your enrollment in event " + eventID);
                    }
                    // tells them event cannot be cancelled
                    else {
                        System.out.println("Sorry this action cannot be done.");
                    }

                    break;
                }
                // adds a contact to contact list
                case "4": {
                    System.out.println("Please enter the username of the contact you would like to add: ");
                    String contactID = this.vs.readString();

                    // adds contact
                    if (this.vs.canAddContact(username, contactID)) {
                        this.vs.addContact(username, contactID);
                        System.out.println("You have successfully added a contact to your contact list.");
                    }
                    // tells them contact cannot be added
                    else {
                        System.out.println("Sorry this action cannot be done.");
                    }

                    break;
                }
                // Sends a message to a contact
                case "5": {
                    VipMessageScreen messageScreen = new VipMessageScreen(am, om, sm, vm, username);
                    messageScreen.run();

                    break;
                }
                // View previous messages
                case "6": {
                    ReadMessageScreen messageScreen = new ReadMessageScreen(am, om, sm, vm, username);
                    messageScreen.run();

                    break;
                }
                // Save full list of events (HTML)
                case "7": {
                    eth.saveToHtml(es);
                    break;
                }
                // Log off
                case "8": {
                    logOut = true;
                    //pass screen back to login screen
                    break;
                }

            }

        }

    }
    public List<Object> openMainScreen() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/GUI/VipScreen.fxml"));
        Parent root = fxmlLoader.load();
        VipMainScreen myPresenter = fxmlLoader.getController();
        myPresenter.setInstances(username, am, es, om, sm, vm ,eth);
        myPresenter.setMainScene(mainScene);
        List<Object> map = new ArrayList<>();
        map.add(new Scene(root));
        map.add(myPresenter);
        return map;
    }

    public void viewMessages() {
        ReadMessageScreen messageScreen = new ReadMessageScreen(am, om, sm, vm, username);
        messageScreen.showMessages();
    }

    public Text getWelcomeText(){
        return welcomeText;
    }

    public void logOut() throws IOException {
        Stage stage = (Stage) logOutButton.getScene().getWindow();
        stage.setScene(mainScene);
    }
    public void addContact() {
        AlertInputInterface alertInterface = new AlertPopUpInput();
        alertInterface.display("Add a Contact", "Enter the name of the Contact you wish you add");
        String contactID = alertInterface.getInput();
        System.out.println(contactID);
        if (this.vs.canAddContact(username, contactID)) {
            this.vs.addContact(username, contactID);
            AlertInterface alert = new AlertPopUp();
            alert.display("Alert Message", "Contact added!");
        } else {
            AlertInterface alert = new AlertPopUp();
            alert.display("Error", "Error occured.\n Please try again.");
        }
    }
    public void sendMessage(){
        VipMessageScreen messageScreen = new VipMessageScreen(am, om, sm, vm, username);
        messageScreen.sendMessage();
    }
    public void setMainScene(Scene mainScene){
        this.mainScene = mainScene;
    }

    public void viewEvents(){
        ManageEventsViewInterface manageEventsScreen = new ManageEventsView();
        List<String> events = this.vs.getScheduleIds(username);
        manageEventsScreen.display("My Events", events);
        AlertInterface alert = new AlertPopUp();
        if(manageEventsScreen.getEventController() != null && manageEventsScreen.getEventController().getCancel()){
            if(vs.canCancelEnrollment(username, manageEventsScreen.getEventController().getEventID())){
                vs.cancelEnrollment(username, manageEventsScreen.getEventController().getEventID());
                alert.display("Success!", "Event Cancelled");
            }
            else{
                alert.display("Error", "Event can not be cancelled");
            }
        }
        if(manageEventsScreen.getController().getAddEvent()){
            if(vs.canAddEvent(username, manageEventsScreen.getController().getEventID())){
                vs.addEvent(username, manageEventsScreen.getController().getEventID());
                alert.display("Success!", "Event Added!");
            }
            else{
                alert.display("An Error Has Occurred", "Event could not be added.");
            }
        }
        if(manageEventsScreen.getController().getSaveEvents()){
            eth.saveToHtml(es);
            alert.display("Downloaded", "Events downloaded as HTML.");
        }
    }
}


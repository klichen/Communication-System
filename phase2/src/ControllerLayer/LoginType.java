package ControllerLayer;

import UseCases.*;
import javafx.scene.control.*;

import java.io.IOException;
import java.util.Scanner;

public class LoginType {
    private String username;
    private String password;
    private loadAndSave las;
    private LoadAndSaveObjects laso;
    private SpeakerManager sm;
    private AttendeeManager am;
    private OrganizerManager om;
    private EventScheduler es;
    private VipManager vm;

    /**
     * Constructor, saves login information of current user
     *
     */
    public LoginType() throws IOException {
        username = "";
        password = "";
        las = new loadAndSave();
        laso = new LoadAndSaveObjects();
        sm = new SpeakerManager();
        am = new AttendeeManager();
        om = new OrganizerManager();
        es = new EventScheduler();
        vm = new VipManager();
        laso.loadAll(es, sm, am, om, vm);

    }

    public void run() throws IOException {
        //LoginScreen loginScreen = new LoginScreen();
        //loginScreen.enterUsername();
        //this.readUsername();
        //loginScreen.enterPw();
       // this.readPassword();
        this.checkLogin();
        //this.save();
    }

    public void save() throws IOException {
        laso.saveAll(es, sm, am, om, vm);
    }

    /**
     * Reads user input and stores it in variable "username"
     *
     */
    public void readUsername() {
        Scanner scan = new Scanner(System.in);
        username = scan.nextLine();
    }

    public void setUsername(String username){
        this.username = username;
    }

    public void setPassword(String password){
        this.password = password;
    }

    /**
     * Reads user input and stores it in variable "password"
     *
     */
    public void readPassword() {
        Scanner scan = new Scanner(System.in);
        password = scan.nextLine();
    }

//    public String readInput(){
//        Scanner scan = new Scanner(System.in);
//        String input = scan.nextLine();
//        return input;
//    }

    /**
     * Reads user input and stores it in variable "password"
     *
     * @return variable username
     */
    public String getUsername() {
        return this.username;
    }

    /**
     * Matches username and password to an Entities.Attendee, Entities.Organizer or Entities.Speaker.
     * Shows the respective presenter.
     *
//     * @param am UseCases.AttendeeManager instance passed from Main method
//     * @param om UseCases.OrganizerManager instance passed from Main method
//     * @param sm UseCases.SpeakerManager instance passed from Main method
//     * @param es UseCases.EventScheduler instance passed from Main method
//     * @param vm UseCases.VipManager instance passed from Main method
     */
    public boolean checkLogin() {

        if (am.checkLogin(username, password)) {
            //show attendee presenter
            AttendeeMainScreen ams = new AttendeeMainScreen(username, am, es, om, sm, vm);
            ams.run();
            return true;
        }
        else if (sm.checkLogin(username, password)) {
            //show speaker presenter
            SpeakerMainScreen sms = new SpeakerMainScreen(username, am, es, om, sm, vm); // assuming its implemented like other presenters
            sms.run();
            return true;
        }
        else if (om.checkLogin(username, password)) {
            //show organizer presenter
            OrganizerMainScreen oms = new OrganizerMainScreen(username, am, es, om ,sm, vm);
            oms.run();
            return true;
        }
        else if(vm.checkLogin(username, password)){
            //show VIP presenter
            VipMainScreen vms = new VipMainScreen(username, am, es, om, sm, vm);
            vms.run();
            return true;
        }
        else{
            System.out.println("Invalid username or password");
            return false;
        }


    }
}

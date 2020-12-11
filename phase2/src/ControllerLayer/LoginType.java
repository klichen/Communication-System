package ControllerLayer;

import UseCases.*;
import javafx.scene.control.*;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import javafx.scene.Scene;

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
    private EventsToHtml eth;
    private Scene mainScene;

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
        eth = new EventsToHtml();
        laso.loadAll(es, sm, am, om, vm);
        //las.loadAll(es, sm, am, om, vm);
        //eth.saveToHtml(es);

    }

    /**
     * Outputs requests for user to enter username and password. Starts hierarchy of program.
     */
    public void run() throws IOException {
        LoginScreen loginScreen = new LoginScreen();
        loginScreen.enterUsername();
        this.readUsername();
        loginScreen.enterPw();
        this.readPassword();
        this.checkLogin();
        this.save();
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
    public void setMainScene(Scene mainScene){
        this.mainScene = mainScene;
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
    public List<Object> checkLogin() throws IOException {
        if (am.checkLogin(username, password)) {
            //show attendee presenter
            AttendeeMainScreen ams = new AttendeeMainScreen(username, am, es, om, sm, vm, eth);
            //ams.run();
            ams.setMainScene(mainScene);
            return ams.openMainScreen();
        }
        else if (sm.checkLogin(username, password)) {
            //show speaker presenter
            SpeakerMainScreen sms = new SpeakerMainScreen(username, am, es, om, sm, vm, eth); // assuming its implemented like other presenters
            //sms.run();
            //return true;
            sms.setMainScene(mainScene);
            return sms.openMainScreen();
        }
        else if (om.checkLogin(username, password)) {
            //show organizer presenter
            OrganizerMainScreen oms = new OrganizerMainScreen(username, am, es, om ,sm, vm, eth);
            //oms.run();
            //return null;
            oms.setMainScene(mainScene);
            return oms.openMainScreen();
        }
        else if(vm.checkLogin(username, password)){
            //show VIP presenter
            VipMainScreen vms = new VipMainScreen(username, am, es, om, sm, vm, eth);
            //vms.run();
            //return true;
            vms.setMainScene(mainScene);
            return vms.openMainScreen();
        }
        else{
            System.out.println("Invalid username or password");
            return null;
        }
    }
}

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
     */
    public LoginType() {
        username = "";
        password = "";
        las = new loadAndSave();
        laso = new LoadAndSaveObjects();
        sm = new SpeakerManager();
        am = new AttendeeManager();
        om = new OrganizerManager();
        es = new EventScheduler();
        vm = new VipManager();
        //las.loadAll(es, sm, am, om, vm);


    }

    /**
     * Outputs requests for user to enter username and password. Starts hierarchy of program.
     */
    public void run() throws IOException {
        laso.loadAll(es, sm, am, om, vm);
        LoginScreen loginScreen = new LoginScreen();
        loginScreen.enterUsername();
        this.readUsername();
        loginScreen.enterPw();
        this.readPassword();
        this.checkLogin();
        laso.saveAll(es, sm, am, om, vm);
    }

    /**
     * Reads user input and stores it in variable "username"
     */
    public void readUsername() {
        Scanner scan = new Scanner(System.in);
        username = scan.nextLine();
    }

    /**
     * Reads user input and stores it in variable "password"
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
     * Matches username and password to an Attendee, Organizer or Speaker.
     * Shows the respective presenter.
     * <p>
     * //     * @param am AttendeeManager instance passed from Main method
     * //     * @param om OrganizerManager instance passed from Main method
     * //     * @param sm SpeakerManager instance passed from Main method
     * //     * @param es EventScheduler instance passed from Main method
     * //     * @param vm VipManager instance passed from Main method
     */
    public void checkLogin() {

        if (am.checkLogin(username, password)) {
            //show attendee presenter
            AttendeeMainScreen ams = new AttendeeMainScreen(username, am, es, om, sm, vm);
            ams.run();
        } else if (sm.checkLogin(username, password)) {
            //show speaker presenter
            SpeakerMainScreen sms = new SpeakerMainScreen(username, am, es, om, sm, vm); // assuming its implemented like other presenters
            sms.run();
        } else if (om.checkLogin(username, password)) {
            //show organizer presenter
            OrganizerMainScreen oms = new OrganizerMainScreen(username, am, es, om, sm, vm);
            oms.run();
        } else if (vm.checkLogin(username, password)) {
            //show VIP presenter
            VipMainScreen vms = new VipMainScreen(username, am, es, om, sm, vm);
            vms.run();
        } else {
            System.out.println("Invalid username or password");
        }


    }
}

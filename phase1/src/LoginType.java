import java.util.Scanner;

public class LoginType {
    private String username;
    private String password;

    /**
     * Constructor, saves login information of current user
     *
     */
    public LoginType() {
        username = "";
        password = "";

    }

    /**
     * Reads user input and stores it in variable "username"
     *
     */
    public void readUsername() {
        Scanner scan = new Scanner(System.in);
        username = scan.nextLine();
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
     * @param am UseCases.AttendeeManager instance passed from Main method
     * @param om UseCases.OrganizerManager instance passed from Main method
     * @param sm UseCases.SpeakerManager instance passed from Main method
     * @param es UseCases.EventScheduler instance passed from Main method
     */
    public void checkLogin(AttendeeManager am, OrganizerManager om, SpeakerManager sm, EventScheduler es) {

        if (am.checkLogin(username, password)) {
            //show attendee presenter
            AttendeeMainScreen ams = new AttendeeMainScreen(username, am, es, om, sm);
            ams.run();
        }
        else if (sm.checkLogin(username, password)) {
            //show speaker presenter
            SpeakerMainScreen sms = new SpeakerMainScreen(username, am, es, om, sm); // assuming its implemented like other presenters
            sms.run();
        }
        else if (om.checkLogin(username, password)) {
            //show organizer presenter
            OrganizerMainScreen oms = new OrganizerMainScreen(username, am, es, om ,sm);
            oms.run();
        }
        else{
            System.out.println("Invalid username or password");
        }


    }
}

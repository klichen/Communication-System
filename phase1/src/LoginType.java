import java.sql.SQLOutput;
import java.util.Scanner;
import java.util.List;

public class LoginType {
    private String username;
    private String password;

    public LoginType() {
        username = "";
        password = "";

    }

    public void readUsername() {
        Scanner scan = new Scanner(System.in);
        username = scan.nextLine();
        scan.close();
    }

    public void readPassword() {
        Scanner scan1 = new Scanner(System.in);
        password = scan1.nextLine();
        scan1.close();
    }

    public String getUsername() {
        return this.username;
    }

    public void checkLogin(AttendeeManager am, OrganizerManager om, SpeakerManager sm, EventScheduler es) {

        if (am.checkLogin(username, password)) {
            //show attendee presenter
            //AttendeeMainScreen ams = new AttendeeMainScreen(username, am, es, om, sm);
            //ams.run();
        }
        else if (sm.checkLogin(username, password)) {
            //show speaker presenter
            //SpeakerMainScreen sms = new SpeakerMainScreen(username, am, es, om, sm); // assuming its implemented like other presenters
            //sms.run();
        }
        else if (om.checkLogin(username, password)) {
            //show organizer presenter
            //OrganizerMainScreen oms = new OrganizerMainScreen(am, es, om, username, sm);
            //oms.run();
        }
        else{
            System.out.println("Invalid username or password");
        }


    }

    public void logOut(){
        this.username = "";
        this.password = "";
    }
}

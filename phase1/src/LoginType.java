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

    public void checkLogin(PersonManager pManager) {

        if (pManager.getPersonType(username, password).equals("Attendee")) {
            //show attendee presenter
        }
        else if (pManager.getPersonType(username, password).equals("Speaker")) {
            //show speaker presenter
            SpeakerMainScreen speakerMainScreen = new SpeakerMainScreen(username);
        }
        else if (pManager.getPersonType(username, password).equals("Organizer")) {
            //show organizer presenter
        }
        else{
            System.out.println("Invalid username or password");
        }


    }
}

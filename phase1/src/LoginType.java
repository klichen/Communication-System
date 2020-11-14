import java.util.Scanner;
import java.util.List;

public class LoginType {
    private String username;
    private String password;

    public LoginType(){
        username = "";
        password = "";

    }

    public void readUsername(){
        Scanner scan = new Scanner(System.in);
        username = scan.nextLine();
    }

    public void readPassword(){
        Scanner scan = new Scanner(System.in);
        password = scan.nextLine();
    }

    public String getUsername(){
        return this.username;
    }

    public void checkLogin(List<Person> logins){
        for (Person user: logins){
            if (user.getUsername().equals(username) && user.getPassword().equals(password)){
                if(user.isAttendeeType()){
                    //show attendee presenter
                }
                else if(user.isSpeakerType()){
                    //show speaker presenter
                    SpeakerMainScreen speakerMainScreen = new SpeakerMainScreen(user.getUsername());
                }
                else if(user.isOrganizerType()){
                    //show organizer presenter
                }
            }
        }
    }
}

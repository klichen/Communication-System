import java.util.List;
import java.util.Scanner;

public class SpeakerMainScreen {
    LoginType lt;
    SpeakerSystem ss;
    SpeakerManager sm;
    EventScheduler es;
    SpeakerMessageScreen sms;

    public SpeakerMainScreen(LoginType lt, SpeakerManager sm, EventScheduler es, SpeakerSystem ss) {
        this.ss = new SpeakerSystem(sm);
        this.lt = lt;
        this.sm = sm;
        this.es = es;
    }

    public void run() {
        String username = lt.getUsername();
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
            String response = ss.readString();
            if (response.equals("1")) {
                this.sms.run();
            }
            else if (response.equals("2")) {
                logout = true;
            }
        }
    }
}
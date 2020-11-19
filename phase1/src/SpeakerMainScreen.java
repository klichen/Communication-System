import java.util.List;
import java.util.Scanner;

public class SpeakerMainScreen {
    private List<String> schedule;
    private SpeakerText st = new SpeakerText();
    public SpeakerMainScreen(String username, SpeakerManager sm){
        SpeakerSystem ss = new SpeakerSystem(sm);
        System.out.println("The list of talks you are giving is:");
        schedule = ss.getSchedule(username);
        for(String i: schedule){
            System.out.println(i);
        }
        System.out.println("To do an action, please press the corresponding number:");
        System.out.println("1 - Message All Attendees in an Event");
        System.out.println("2 - Message An Attendee");
        Scanner scan = new Scanner(System.in);
        String id = scan.nextLine();
        scan.close();
        // Message all attendees in an Event
        if (id.equals("1")) {
            System.out.println("Please Write the Event's ID:");
            String eventID = scan.nextLine();
            scan.close();
            System.out.println("Please Write Out the Message:");
            String message = scan.nextLine();
            scan.close();
        }
        // Message one attendee
        if (id.equals("2")) {
            System.out.println("Please Write the Username of the Attendee:");
            String attendeeUsername = scan.nextLine();
            scan.close();
            System.out.println("Please Write Out the Message:");
            String message = scan.nextLine();
            scan.close();
            st.respondAttendee(message, attendeeUsername, username);
        }
    }
}

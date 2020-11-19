import java.util.ArrayList;
public class AttendeeMessageScreen {
    private AttendeeManager am;
    private OrganizerManager om;
    private SpeakerManager sm;
    private LoginType loginType;

    public AttendeeMessageScreen(AttendeeManager am, OrganizerManager om, SpeakerManager sm, LoginType loginType){
        this.am = am;
        this.om = om;
        this.sm = sm;
        this.loginType = loginType;
    }

    public void run() {
        MessageSystem messageSystem = new MessageSystem(am, om, sm, loginType);
        System.out.println("This is your contact list:");

        //need method from attendee manager
        ArrayList<String> contacts = am.getContactList(loginType.getUsername());
        for (String contact: contacts){
            System.out.println(contact);
        }
        System.out.println("Enter the username of the person you want to message");
        String receiver = messageSystem.userInput();

        System.out.println("Enter the message");
        String message = messageSystem.userInput();

        messageSystem.createMessage(message, receiver);
    }
}
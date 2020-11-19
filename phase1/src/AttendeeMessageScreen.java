import java.util.ArrayList;
import java.util.List;

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
        List<String> contacts = am.getContactList(loginType.getUsername());
        for (String contact: contacts){
            System.out.println(contact);
        }

        System.out.println("To do an action, please enter the corresponding number:");
        System.out.println("1 - Send a message to someone in your contact list");
        System.out.println("2 - See and respond to your messages");

        String choice = messageSystem.userInput();

        switch(choice){
            case "1": {
                System.out.println("Enter the username of the person you want to message");
                String receiver = messageSystem.userInput();

                System.out.println("Enter the message");
                String message = messageSystem.userInput();

                messageSystem.createMessage(message, receiver);
            }
            case "2":{
                ReadMessageScreen currMessages = new ReadMessageScreen(am, om, sm, loginType);
                currMessages.run();
            }
            default:
                throw new IllegalArgumentException("input not valid");

        }


    }
}
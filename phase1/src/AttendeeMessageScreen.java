import java.util.ArrayList;
import java.util.List;

public class AttendeeMessageScreen {
    private final AttendeeManager am;
    private final OrganizerManager om;
    private final SpeakerManager sm;
    private final String username;

    /**
     * Creates instance of AttendeeMessageScreen, the presenter class for the messaging hub of an attendee user.
     *
     * @param am Instance of AttendeeManager with loaded information
     * @param om Instance of OrganizerManager with loaded information
     * @param sm Instance of SpeakerManager with loaded information
     * @param username String of the username of current user logged in
     */
    public AttendeeMessageScreen(AttendeeManager am, OrganizerManager om, SpeakerManager sm, String username){
        this.am = am;
        this.om = om;
        this.sm = sm;
        this.username = username;
    }

    /**
     * Outputs the options that the current user can perform
     *
     */
    public void run() {
        MessageSystem messageSystem = new MessageSystem(am, om, sm, username);
        System.out.println("This is your contact list:");

        //need method from attendee manager
        List<String> contacts = am.getContactList(username);
        for (String contact: contacts){
            System.out.println(contact);
        }

        System.out.println("To do an action, please enter the corresponding number:");
        System.out.println("1 - Send a message to someone in your contact list");
        System.out.println("2 - See and respond to your messages");
        System.out.println("3 - Exit");

        String choice = messageSystem.userInput();

        switch(choice){
            case "1": {
                System.out.println("Enter the username of the person you want to message");
                String receiver = messageSystem.userInput();

                System.out.println("Enter the message");
                String message = messageSystem.userInput();

                messageSystem.createMessage(message, receiver);
                break;
            }
            case "2":{
                ReadMessageScreen currMessages = new ReadMessageScreen(am, om, sm, username);
                currMessages.run();
                break;
            }
            case "3":{
                break;
            }

        }
    }
}
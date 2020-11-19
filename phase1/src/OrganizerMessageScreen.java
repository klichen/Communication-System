public class
        OrganizerMessageScreen {
    private AttendeeManager am;
    private OrganizerManager om;
    private SpeakerManager sm;
    private String username;

    public OrganizerMessageScreen(String username, AttendeeManager am, OrganizerManager om,
                                  SpeakerManager sm){
        this.am = am;
        this.om = om;
        this.sm = sm;
        this.username = username;
    }

    /**
     * Prints the available actions to the screen, and takes in inputs accordingly.
     */
    public void run(){
        MessageSystem messageSystem = new MessageSystem(am, om, sm, username);
        System.out.println("Enter the username of the recipient. Enter \"All Attendees\" to message all attendees, and" +
                " enter \" All Speakers\" to message all speakers.");
        String receiver = messageSystem.userInput();
        System.out.println("Enter your message:");
        String message = messageSystem.userInput();
        messageSystem.createMessage(message, receiver);
    }
}

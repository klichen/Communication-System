public class
        OrganizerMessageScreen {
    private AttendeeManager am;
    private OrganizerManager om;
    private SpeakerManager sm;
    private VipManager vm;
    private String username;

    /**
     * Creates instance of OrganizerMessageScreen, the presenter class for the messaging hub of an organizer user.
     *
     * @param username String of the username of current user logged in
     * @param am Instance of AttendeeManager with loaded information
     * @param om Instance of OrganizerManager with loaded information
     * @param sm Instance of SpeakerManager with loaded information
     * @param vm Instance of VipManager with loaded information
     */
    public OrganizerMessageScreen(String username, AttendeeManager am, OrganizerManager om,
                                  SpeakerManager sm, VipManager vm){
        this.am = am;
        this.om = om;
        this.sm = sm;
        this.vm = vm;
        this.username = username;
    }

    /**
     * Prints the available actions to the screen, and takes in inputs accordingly.
     */
    public void run(){
        boolean sent = false;
        MessageSystem messageSystem = new MessageSystem(am, om, sm, vm, username);
        System.out.println("Enter the username of the recipient. Enter \"All Attendees\" to message all attendees, and" +
                " enter \"All Speakers\" to message all speakers.");
        String receiver = messageSystem.userInput();
        System.out.println("Enter your message:");
        String message = messageSystem.userInput();
        sent = messageSystem.createMessage(message, receiver);
        if(sent){
            System.out.println("Message sent!");
        }
        else{
            System.out.println("An error occurred. Message not sent.");
        }
    }
}

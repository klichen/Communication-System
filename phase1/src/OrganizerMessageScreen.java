public class OrganizerMessageScreen {
    private AttendeeManager am;
    private OrganizerManager om;
    private SpeakerManager sm;
    private LoginType loginType;

    public OrganizerMessageScreen(AttendeeManager am, OrganizerManager om, SpeakerManager sm, LoginType loginType){
        this.am = am;
        this.om = om;
        this.sm = sm;
        this.loginType =loginType;
    }

    public void run(){
        MessageSystem messageSystem = new MessageSystem(am, om, sm, loginType);
        System.out.println("Enter the username of the recipient. Enter \"All Attendees\" to message all attendees, and" +
                " enter \" All Speakers\" to message all speakers.");
        String receiver = messageSystem.inputReceiver();
        System.out.println("Enter your message.");
        String message = messageSystem.inputMessage();
        messageSystem.createMessage(message, receiver);
    }
}

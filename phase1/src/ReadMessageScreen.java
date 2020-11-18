public class ReadMessageScreen {
    private AttendeeManager am;
    private OrganizerManager om;
    private SpeakerManager sm;
    private LoginType loginType;

    public ReadMessageScreen(AttendeeManager am, OrganizerManager om, SpeakerManager sm, LoginType loginType){
        this.am = am;
        this.om = om;
        this.sm = sm;
        this.loginType =loginType;
    }

    public void run(){
        MessageSystem messageSystem = new MessageSystem(am, om, sm, loginType);
        System.out.println("Here are your messages:");
        String messages = messageSystem.readMessage(loginType.getUsername());
        System.out.println(messages);
        System.out.println("Type \"main menu\" to return to the main screen.");
        messageSystem.userInput();
    }
}
